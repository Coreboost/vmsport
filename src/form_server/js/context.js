const _ = require('lodash');
const beep = require('./beep.js');

const Context = function() {
  return {
    layout: null,
    panels: [],
    data_changed_listeners: [],
    form_data: {},
    form_records: {},
    root_frame: null,
    add_form_data: function (definition) {
      definition.form_data.forEach(function (data_item) {
        this.form_data[data_item.name] = {definition: data_item, value: null};
      }, this);
      return this;
    },
    clear_form_data: function () {
      _.forOwn(this.form_data, function (data_item) {
        data_item.value = null;
      });
      this.fire_data_changed();
    },
    get_data_item: function (item_name) {
      return this.form_data[item_name];
    },
    set_data_item: function (item_name, value) {
      this.form_data[item_name].value = value;
      this.fire_data_changed();
    },
    register_data_changed_listener(listener) {
      this.data_changed_listeners.push(listener);
    },
    fire_data_changed() {
      this.data_changed_listeners.forEach(function (listener) {
        listener();
      });
      // Check out how I did this in coolgraphy
    },
    // Note the confused terminology receive means receive in the application, i.e.,
    // we should gather up the data and send it back to the server
    receive_data: function (record_name) {
      // Maybe we should have a state variable here of some kind, i.e., pending receive or similar.
      if (this.form_records[record_name]) {
        var handler = _.find(this.root_frame.on_receive, function (handler) {
          return handler.record_type === record_name;
        });
        if (handler) {
          handler.behavior(this);
        }
      } else {
        console.log("Received request for unknown record type: " + record_name)
      }
      /*
      What needs to be done next??
      ----------------------------
      0. From the beginning no panel should be activated.
         Need to understand which items are activated / not activated by default.
         The default action is to activate the items corresponding to The
         record specified in receive. ACTIVATE CORRESPONDING RECEIVE
         ACTIVATE PANEL NAME activates all fields on the panel.
      2. Then when TRANSMIT is send, i.e., Ctrl-Z, F10 I believe
      3. Then we should emit the Data
      4. Maybe we should have a very simple state variable here and on the server
         to keep track of if we are in a recieve transaction, a send transaction, a call transaction
         or similar and we will simply lock the UI in between, check how we can do that quickly with CSS. Maybe we can just
         have a top level property on the layout that we propagate with react.
      */
    },
    // Note the confused terminology, send mean that the data was sent from the server
    // i.e., it is really received herr.
    send_data: function (record) {
      if (this.form_records[record.name]) {
        var ctx = this;
        _.forOwn(record.data, function (val, key) {
          if (ctx.form_data[key]) {
            ctx.form_data[key].value = _.cloneDeep(val);
            ctx.fire_form_data_updated(key);
          } else {
            console.log("Record type " + record.name + " had an unknown member: " + key);
          }
        });
      } else {
        console.log("Received unknown record type: " + record_name)
      }
    },
    add_form_records: function (definition) {
      definition.form_records.forEach(function (record) {
        this.form_records[record.name] = _.cloneDeep(record);
      }, this);
      return this;
    },
    register_message_panel: function (message_panel) {
      this.message_panel = message_panel;
    },
    register_layout: function (layout) {
      this.layout = layout;
    },
    register_panel: function (panel) {
      this.panels.push(panel);
    },
    new_child_frame: function (parent_frame) {
      var frame = {
        functions: [],
        on_key: [],
        on_receive: [],
        on_disable: null,
        on_entry: null,
        on_exit: null,
        key_bindings: [],
        child_frames: [],
        parent_frame: parent_frame,
        add_handlers: function (definition) {
          if (definition.functions) {
            definition.functions.forEach(function (funcdef) {
              var fn = eval(funcdef.behavior);
              this.functions.push(
                {
                  name: funcdef.name,
                  behavior: fn
                }
              );
            }, this);
          }
          if (definition.on_key) {
            definition.on_key.forEach(function (handler) {
              var fn = eval(handler.behavior);
              this.on_key.push(
                {
                  name: handler.name,
                  behavior: fn
                }
              );
            }, this);
          }
          if (definition.on_receive) {
            definition.on_receive.forEach(function (handler) {
              var fn = eval(handler.behavior);
              this.on_receive.push(
                {
                  record_type: handler.record_type,
                  behavior: fn
                }
              );
            }, this);
          }
          if (definition.on_disable) {
            this.on_disable = eval(definition.on_disable);
          }
          if (definition.on_entry) {
            this.on_entry = eval(definition.on_entry);
          }
          if (definition.on_exit) {
            this.on_exit = eval(definition.on_exit);
          }
          if (definition.key_bindings) {
            definition.key_bindings.forEach(function (binding) {
              this.key_bindings.push(
                {
                  key: binding.key,
                  key_code: binding.key_code,
                  handler: binding.handler
                }
              );
            }, this);
          }
          return this;
        }
      };
      if (parent_frame) {
        parent_frame.child_frames.push(frame);
      } else {
        this.root_frame = frame;
      }
      return frame;
    },
    handle_key_up: function(e, widget) {
      var hdef;
      var i_frame = widget.frame;
      while (i_frame && !hdef) {
        hdef = _.find(i_frame.key_bindings, function (hdef) {
          return hdef.key_code === e.keyCode;
        });
        i_frame = i_frame.parent_frame;
      }
      if (hdef) {
        this.invoke_on_key(widget, hdef.handler);
        e.preventDefault();
      }
    },
    handle_disable: function() {
      // This should be firec when the disable message is recieved from the server
      // we should then search for the on_disable handler if any and execute it if it exists
    },
    invoke_function: function (widget, function_name) {
      var fdef;
      var i_frame = widget.frame;
      while (i_frame && !fdef) {
        fdef = _.find(i_frame.functions, function (fdef) {
          return fdef.name === function_name;
        });
        i_frame = i_frame.parent_frame;
      }
      if (fdef) {
        fdef.behavior(this, widget);
      } else {
        console.log("Function not found: " + function_name)
      }
    },
    invoke_on_key: function (widget, handler_name) {
      var hdef;
      var i_frame = widget.frame;
      while (i_frame && !hdef) {
        hdef = _.find(i_frame.on_key, function (hdef) {
          return hdef.name === handler_name;
        });
        i_frame = i_frame.parent_frame;
      }
      if (hdef) {
        hdef.behavior(this, widget);
      } else {
        console.log("On-Key handler not found: " + handler_name)
      }
    },
    reset_all: function () {
      this.clear_form_data();
    },
    display_message: function(message) {
      if (this.message_panel) {
        this.message_panel.display_message(message);
      } else {
        console.log("Could not display the following message as no message panel is registered.");
        console.log("Message: " + message);
      }
    },
    signal: function () {
      beep();
    },
    position_to_panel: function () {
      console.log("position_to_panel not implemented in context.js");
    },
    return_immediate: function () {
      console.log("return_immediate not implemented in context.js");
    },
    remove_all: function () {
      console.log("remove_all not implemented in context.js");
    },
    activate_panel: function (panel_name) {
      var panel = _.find(this.panels, function (panel) {
        return panel.props.definition.name === panel_name;
      });
      if (panel) {
        panel.activate();
      }
    },
    position_to_panel: function (panel_name) {
      var panel = _.find(this.panels, function (panel) {
        return panel.props.definition.name === panel_name;
      });
      if (panel) {
        panel.focus();
      }
    },
  };
};

module.exports = Context;

const _ = require('lodash');
const beep = require('./beep.js');

const Context = function() {
  return {
    form_data: {},
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
    },
    get_data_item: function (item_name) {
      return this.form_data[item_name];
    },
    set_data_item: function (item_name, value) {
      this.form_data[item_name].value = value;
    },
    recieve_data: function (records) {
      console.log("Data recieved:");
      console.dir(records);
    },
    register_message_panel: function (message_panel) {
      this.message_panel = message_panel;
    },
    new_child_frame: function (parent_frame) {
      var frame = {
        functions: [],
        on_key_handlers: [],
        on_recieve_handlers: [],
        on_disable_handler: null,
        on_entry_handler: null,
        on_exit_handler: null,
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
          if (definition.on_key_handlers) {
            definition.on_key_handlers.forEach(function (handler) {
              var fn = eval(handler.behavior);
              this.on_key_handlers.push(
                {
                  name: handler.name,
                  behavior: fn
                }
              );
            }, this);
          }
          if (definition.on_recieve_handlers) {
            definition.on_recieve_handlers.forEach(function (handler) {
              var fn = eval(handler.behavior);
              this.on_recieve_handlers.push(
                {
                  name: handler.name,
                  behavior: fn
                }
              );
            }, this);
          }
          if (definition.on_disable_handler) {
            this.on_disable_handler = eval(definition.on_disable_handler);
          }
          if (definition.on_entry_handler) {
            this.on_entry_handler = eval(definition.on_entry_handler);
          }
          if (definition.on_exit_handler) {
            this.on_exit_handler = eval(definition.on_exit_handler);
          }
          if (definition.key_bindings) {
            definition.key_bindings.forEach(function (binding) {
              this.key_bindings.push(
                {
                  key: binding.key,
                  scan_code: binding.scan_code,
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
    handle_key_press: function(scan_code, frame) {
      // search the on_key_handlers if there is a match, return true if the key was handled, false otherwise.
    },
    handle_recieve: function(record_type, data) {
      // This should be fired when records are recieved from the server
      // we should then search for the appropriate on_recieve_handler and execute it if found
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
    invoke_on_key_handler: function (widget, handler_name) {
      var hdef;
      var i_frame = widget.frame;
      while (i_frame && !hdef) {
        hdef = _.find(i_frame.on_key_handlers, function (hdef) {
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
  };
};

module.exports = Context;

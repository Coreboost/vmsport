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
    handle_key_press: function(scan_code) {
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
    current_frame: function () {
      return this.frames[this.frames.length-1];
    },
    call_function: function (function_name) {
      var iframe;
      var fdef;
      for (iframe = frames.length-1; iframe >= 0; iframe -= 1) {
        fdef = _.find(frames[iframe].functions, function (fdef) {
          fdef.name === function_name;
        });
      }
      fdef.behavior();
    }
  };
};

module.exports = Context;

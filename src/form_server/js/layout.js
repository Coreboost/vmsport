const React = require('react');
const Panel = require('./panel.js');
const MessagePanel = require('./messagepanel.js');

const Layout = React.createClass({
  componentWillMount: function () {
    // setup handlers here, we need to parse/compile them here
    // regular functions
    // on_recieve_handlers
    // on_disable:handler
    // on_key_handlers
    // on_entry
    // possibly somethin more
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
  render: function () {
    var lines = this.props.definition.lines;
    var columns = this.props.definition.columns;
    // Viewed in Chrome on the Mac this gives a pretty good size of things
    // This probably needs to be tweaked later on
    var layout_style = {
      position: "absolute",
      top: 25,
      left: 25,
      padding: 0,
      margin: 0,
      width: columns * 10,
      height: lines * 20,
      backgroundColor: "Beige",
      fontFamily: "Inconsolata",
      fontSize: 20
    };
    var panels = [];
    var lists = this.props.definition.lists;
    var viewports = this.props.definition.viewports;
    var layout = this;
    this.props.definition.panels.forEach(function(panel) {
      panels.push(
        <Panel key={panel.name} definition={panel} lists={lists} viewports={viewports} layout={layout} />
      );
    });
    if (this.props.definition.message_panel) {
      panels.push(
        <MessagePanel key="__message_panel__" viewport_name={this.props.definition.message_panel.viewport} viewports={viewports} />
      );
    }
    return (
      <div className="layout" style={layout_style}>
      {panels}
      </div>
    );
  },
});

module.exports = Layout;

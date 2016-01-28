const React = require('react');
const _ = ('lodash');
const Panel = require('./panel.js');
const MessagePanel = require('./messagepanel.js');

const Layout = React.createClass({
  componentWillMount: function () {
    this.my_frame = this.props.context.
                        new_child_frame(null).
                        add_handlers(this.props.definition);
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
      height: lines * 22,
      backgroundColor: "Beige",
      fontFamily: "Inconsolata",
      fontSize: 20
    };
    var panels = [];
    var lists = this.props.definition.lists;
    var viewports = this.props.definition.viewports;
    var layout = this;
    var form = this.props.form;
    this.props.definition.panels.forEach(function(panel) {
      panels.push(
        <Panel key={panel.name} definition={panel} lists={lists} viewports={viewports} context={this.props.context} parentframe={this.my_frame} />
      );
    }, this);
    if (this.props.definition.message_panel) {
      panels.push(
        <MessagePanel key="__message_panel__" viewport_name={this.props.definition.message_panel.viewport} viewports={viewports} context={this.props.context} parentframe={this.my_frame} />
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

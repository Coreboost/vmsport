const React = require('react');
const _ = require('lodash');
const Icon = require('./icon.js');
const renderWidgets = require('./renderwidgets.js');

const Panel = React.createClass({
  componentWillMount: function () {
    var this_ = this;
    this.on_entry_handler = undefined;
    if (this.props.definition.on_entry_handler) {
      this.on_entry_handler = eval(this.props.definition.on_entry_handler);
    }
    this.on_exit_handler = undefined;
    if (this.props.definition.on_exit_handler) {
      this.on_exit_handler = eval(this.props.definition.on_exit_handler);
    }
    this.on_key_handlers = [];
    this.props.definition.on_key_handlers.forEach(function (handler) {
      var fn = eval(handler.behavior);
      this_.on_key_handlers.push(
        {
          name: handler.name,
          behavior: fn
        }
      );
    });
  },
  getInitialState: function () {
    return {
      visible: true
    };
  },
  render: function () {
    var vp_name = this.props.definition.viewport;
    var vp = _.find(this.props.viewports, function (vps) {
      return vps.name === vp_name;
    });
    var panel_style = {
      padding: 0,
      margin: 0,
      position: "absolute",
      visibility: this.state.visible ? "visible" : "hidden",
      left: (vp.col_from - 1) * 10,
      top: (vp.line_from - 1) * 20,
      width: (vp.col_to - vp.col_from + 1) * 10,
      height: (vp.line_to - vp.line_from + 1) * 20,
      backgroundColor:"LightSteelBlue"
    };

    var fields = [];
    var icons  = [];
    var widgets = renderWidgets(this.props.definition.text_literals, this.props.definition.polyline_literals, this.props.definition.rectangle_literals)
    var key = 1000;  // KSL: Not so nice but should be enough...
    this.props.definition.icons.forEach(function (ic_def) {
      icons.push(
        <Icon key={key++} definition={ic_def} />
      );
    });

    return (
      <div className="panel" style={panel_style}>
        {widgets}
        {fields}
        {icons}
      </div>
    );
  }
});

module.exports = Panel;

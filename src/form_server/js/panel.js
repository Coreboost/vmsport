const React = require('react');
const _ = require('lodash');
const Icon = require('./icon.js');
const renderWidgets = require('./renderWidgets.js');

const Panel = React.createClass({
  componentWillMount: function () {
    // Need to parse and hook
    // on_entry
    // on_exit
    // on_key_handlers
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

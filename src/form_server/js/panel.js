const React = require('react');
const _ = require('lodash');
const TextLiteral = require('./textliteral.js');

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

    var text_literals = [];
    var polyline_literals = [];
    var rectangle_literals = [];
    var fields = [];
    var icons  = [];
    var key = 1;
    this.props.definition.text_literals.forEach(function (tl_def) {
      text_literals.push(
        <TextLiteral key={key++} definition={tl_def} />
      );
    });

    return (
      <div className="panel" style={panel_style}>
        {text_literals}
        {polyline_literals}
        {rectangle_literals}
        {fields}
        {icons}
      </div>
    );
  },
});

module.exports = Panel;

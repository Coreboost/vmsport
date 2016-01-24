const React = require('react');
const _ = require('lodash');
//const Panel = require('./panel.js');

const Panel = React.createClass({
  componentWillMount: function () {
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
    return (
      <div className="panel" style={panel_style}>
        Panel: {this.props.definition.name}
      </div>
    );
  },
});

module.exports = Panel;

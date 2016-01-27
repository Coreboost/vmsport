const React = require('react');
const _ = require('lodash');

const MessagePanel = React.createClass({
  componentWillMount: function () {
  },
  getInitialState: function () {
    return {
      visible: true
    };
  },
  render: function () {
    var vp_name = this.props.viewport_name;
    var vp = _.find(this.props.viewports, function (vps) {
      return vps.name === vp_name;
    });
    var message_panel_style = {
      padding: 0,
      margin: 0,
      position: "absolute",
      visibility: this.state.visible ? "visible" : "hidden",
      left: (vp.col_from - 1) * 10,
      top: (vp.line_from - 1) * 22,
      width: (vp.col_to - vp.col_from + 1) * 10,
      height: (vp.line_to - vp.line_from + 1) * 22,
      backgroundColor:"Khaki"
    };
    return (
      <div className="messagepanel" style={message_panel_style}>
        Message panel...
      </div>
    );
  },
});

module.exports = MessagePanel;

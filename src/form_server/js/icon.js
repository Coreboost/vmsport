const React = require('react');
const _ = require('lodash');
const renderWidgets = require('./renderwidgets.js');
const Icon = React.createClass({
  componentWillMount: function () {
    var this_ = this;
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
  select_handler: function () {
    var behavior = _.find(this.on_key_handlers, function (handler) {
      return handler.name === "SELECT";
    });
    if (behavior) {
      behavior.behavior();
    } else {
      throw "No SELECT handler defined for Icon.";
    }
  },
  render: function () {
    if (this.props.definition.text_literals.length === 1 && !this.props.definition.polyline_literals && this.props.definition.rectangle_literals.length === 1) {
      var caption = this.props.definition.text_literals[0].value;
      var rect = this.props.definition.rectangle_literals[0];
      var oneCorner = rect[0];
      var otherCorner  = rect[1];
      var leftColumn = Math.min(oneCorner.column, otherCorner.column);
      var rightColumn = Math.max(oneCorner.column, otherCorner.column);
      var topLine = Math.min(oneCorner.line, otherCorner.line);
      var bottomLine = Math.max(oneCorner.line, otherCorner.line);
      var button_style = {
            position: "absolute",
            left: (leftColumn - 1) * 10 + 5,
            top: (topLine - 1) * 22 + 11,
            width: (rightColumn - leftColumn) * 10,
            height: (bottomLine - topLine) * 22,
            fontFamily: "Inconsolata",
            fontSize: 20
          };
      return (
        <input tabIndex="1" className="icon" type="button" onClick={this.select_handler} style={button_style} value={caption} />
      );
    } else {
      throw "Unsupported Icon format."
    }
  }
});

module.exports = Icon;

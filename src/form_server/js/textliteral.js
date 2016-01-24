const React = require('react');
const _ = require('lodash');

const TextLiteral = React.createClass({
  render: function () {
    var scale = "scale(1, 1)"
    if (this.props.definition.style) {
      if (this.props.definition.style.indexOf("Font_Size_Double_Wide") != -1) {
        scale = "scale(2,1)";
      }
    }
    var text_literal_style = {
      position: "absolute",
      left: (this.props.definition.column - 1) * 10,
      top: (this.props.definition.line - 1) * 20,
      transformOrigin: "left center",
      transform: scale
    };
    return (
      <span className="textliteral" style={text_literal_style}>{this.props.definition.value}</span>
    );
  },
});

module.exports = TextLiteral;

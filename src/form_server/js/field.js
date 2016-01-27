const React = require('react');
const _ = require('lodash');

const Field = React.createClass({
  render: function () {
    var field_style = {
      position: "absolute",
      left: (this.props.definition.column - 1) * 10,
      top: (this.props.definition.line - 1) * 22,
      borderWidth: 0,
      borderColor: "Transparent",
      backgroundColor: "Lavender",
      height: 22,
      width: 200,
      fontFamily: "Inconsolata",
      fontSize: 20
    };
    return (
      <input className="field" type="text" maxLength="10" style={field_style} />
    );
  },
});

module.exports = Field;

const React = require('react');
const _ = require('lodash');

const Field = React.createClass({
  componentWillMount: function () {
  },
  getInitialState: function () {
    this.data_item = this.props.form.get_data_item(this.props.definition.name);
    return {
      field_value: this.data_item.value
    };
  },
  handleChange: function (e) {
    this.data_item.value = e.target.value;
    this.setState(
      {
        field_value: e.target.value
      }
    )
  },
  render: function () {
    var field_style = {
      position: "absolute",
      left: (this.props.definition.column - 1) * 10,
      top: (this.props.definition.line - 1) * 22,
      borderWidth: 0,
      borderColor: "Transparent",
      backgroundColor: "Lavender",
      height: 22,
      width: this.data_item.definition.multiplicity*10,
      fontFamily: "Inconsolata",
      fontSize: 20
    };
    return (
      <input tabIndex="1" className="field" type="text" maxLength={this.data_item.definition.multiplicity} style={field_style} value={this.state.field_value} onChange={this.handleChange} />
    );
  },
});

module.exports = Field;

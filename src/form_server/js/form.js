const React = require('react');
const Layout = require('./layout.js');

const Form = React.createClass({
  componentWillMount: function () {
    var form_data = {};
    this.props.definition.form_data.forEach(function (data_item) {
      form_data[data_item.name] = null;
    });
    this.setState({form_data: form_data});
  },
  recieveData: function (records) {

  },
  sendData: function () {
    this.props.socket.emit('sendData', "some data");
  },
  render: function () {
/**
  What needs to be done?
  ----------------------
  // Need to set on handlers when created and tear them down.
  // Alternative is to handle it above somehow and register a callback, perhaps better...
  * Set up structures to keep form-data
  * Set up send/recieve functions for send/recieve/trancieve which updates/reads from form data
  * Maybe we should set up eventhandlers around the data so that we can register fields to update them
    as data get updated.
  * We should also populate the fields from the data as they are first rendered
  * Find the appropriate layout and generate the visuals for it
  * Create the div to a size that corresponds to the f


**/
    return (
      <Layout definition={this.props.definition.layouts[0]} form={this} />
    );
  },
});

module.exports = Form;

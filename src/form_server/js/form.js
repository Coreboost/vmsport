const React = require('react');
const _ = require('lodash');
const Layout = require('./layout.js');
const Context = require('./context.js')

const Form = React.createClass({
  componentWillMount: function () {
    this.context = Context().
                    add_form_data(this.props.definition);
  },
  recieveData: function (records) {
    this.context.recieve_data(records);
  },
  sendData: function () {
    this.props.socket.emit('sendData', this.context.form_data);
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
      <Layout definition={this.props.definition.layouts[0]} context={this.context} />
    );
  },
});

module.exports = Form;

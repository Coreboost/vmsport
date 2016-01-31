const React = require('react');
const _ = require('lodash');
const Layout = require('./layout.js');
const Context = require('./context.js')

const Form = React.createClass({
  componentWillMount: function () {
    var context = Context().
                    add_form_data(this.props.definition);
    this.context = context;
    this.props.socket.on('receive', function(record_name) {
      context.receive_data(record_name);
    });
  },
  render: function () {
/**
  * Maybe we should set up eventhandlers around the data so that we can register fields to update them
    as data get updated.
  * We should also populate the fields from the data as they are first rendered
**/
    return (
      <Layout definition={this.props.definition.layouts[0]} context={this.context} />
    );
  },
});

module.exports = Form;

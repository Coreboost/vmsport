const React = require('react');

const Form = React.createClass({
  // Need to set on handlers when created and tear them down.
  // Alternative is to handle it above somehow and register a callback, perhaps better...
  sendData: function () {
    this.props.socket.emit('sendData', "some data");
  },
  render: function () {
    return (
      <div className="form">
        <p>Name of the loaded form: {this.props.definition.name}</p>
      </div>
    );
  },
});

module.exports = Form;

const React = require('react');

const FormManager = React.createClass({
  loadForm: function (e) {
    this.props.socket.emit('load form', e.target.id);
  },
  render: function () {
    var formLabels = []
    var formManager = this;
    this.props.forms.forEach(function (form) {
      formLabels.push(
        <p key={form.key}><a id={form.key} onClick={formManager.loadForm}>{form.name}</a></p>
      );
    });
    return (
      <div className="forms">
        <p>Load a form by clicking on it:</p>
        {formLabels}
      </div>
    );
  },
});

module.exports = FormManager;

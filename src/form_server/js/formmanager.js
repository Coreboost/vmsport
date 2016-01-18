const React = require('react');

const FormManager = React.createClass({
  render: function () {
    var formLabels = []
    var key = 0;
    this.props.forms.forEach(function (formName) {
      formLabels.push(
        <p key={key++}><a>{formName}</a></p>
      );
    });
    return (
      <div className="forms">
        <p>Here comes a list of forms</p>
        {formLabels}
      </div>
    );
  },
});

module.exports = FormManager;

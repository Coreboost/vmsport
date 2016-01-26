const React = require('react');
const renderWidgets = require('./renderWidgets.js');
const Icon = React.createClass({
  componentWillMount: function () {
    // Need to parse and hook
    // on_key_handlers
  },
  render: function () {
    var icons  = [];
    var widgets = renderWidgets(this.props.definition.text_literals, this.props.definition.polyline_literals, this.props.definition.rectangle_literals)
    var key = 1000;  // KSL: Not so nice but should be enough...
    return (
      <div className="icon">
        {widgets}
      </div>
    );
  }
});

module.exports = Icon;

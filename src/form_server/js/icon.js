const React = require('react');
const renderWidgets = require('./renderwidgets.js');
const Icon = React.createClass({
  componentWillMount: function () {
    var this_ = this;
    this.on_key_handlers = [];
    this.props.definition.on_key_handlers.forEach(function (handler) {
      var fn = eval(handler.behavior);
      this_.on_key_handlers.push(
        {
          name: handler.name,
          behavior: fn
        }
      );
    });
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

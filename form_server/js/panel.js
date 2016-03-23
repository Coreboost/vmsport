const React = require('react');
const ReactDOM = require('react-dom');
const _ = require('lodash');
const Icon = require('./icon.js');
const Field = require('./field.js');
const renderWidgets = require('./renderwidgets.js');

const Panel = React.createClass({
  componentWillMount: function () {
    this.frame = this.props.context.
                        new_child_frame(this.props.parentframe).
                        add_handlers(this.props.definition);
    this.props.context.register_panel(this);
    this.activatable_children = [];
  },
  register_activatable_child: function (child) {
    this.activatable_children.push(child);
  },
  getInitialState: function () {
    return {
      visible: false
    };
  },
  activate: function() {
    this.setState({visible: true});
    if (this.frame.on_entry) {
      this.frame.on_entry(this.props.context, this);
    }
    this.activatable_children.forEach(function (comp) {
      comp.activate();
    });
  },
  deactivate: function() {
    activatable_children.forEach(function (comp) {
      comp.deactivate();
    });
    if (this.frame.on_exit) {
      this.frame.on_exit(this.props.context, this);
    }
    this.setState({visible: false});
  },
  focus: function() {
    if (this.activatable_children.length > 0) {
      ReactDOM.findDOMNode(this.activatable_children[0]).focus();
    }
  },
  render: function () {
    var vp_name = this.props.definition.viewport;
    var vp = _.find(this.props.viewports, function (vps) {
      return vps.name === vp_name;
    });
    var panel_style = {
      padding: 0,
      margin: 0,
      position: "absolute",
      visibility: this.state.visible ? "visible" : "hidden",
      left: (vp.col_from - 1) * 10,
      top: (vp.line_from - 1) * 22,
      width: (vp.col_to - vp.col_from + 1) * 10,
      height: (vp.line_to - vp.line_from + 1) * 22,
      backgroundColor:"LightSteelBlue"
    };
    var widgets = renderWidgets(this.props.definition.text_literals,
                                this.props.definition.polyline_literals,
                                this.props.definition.rectangle_literals);
    var key = 1000;  // KSL: Not so nice but should be enough...
    this.props.definition.fields.forEach(function (fl_def) {
      widgets.push(
        <Field ref={this.register_activatable_child} key={key++} definition={fl_def} context={this.props.context} parentframe={this.frame} />
      );
    }, this);
    this.props.definition.icons.forEach(function (ic_def) {
      widgets.push(
        <Icon ref={this.register_activatable_child} key={key++} definition={ic_def} context={this.props.context} parentframe={this.frame} />
      );
    }, this);

    return (
      <div className="panel" style={panel_style}>
        {widgets}
      </div>
    );
  }
});

module.exports = Panel;

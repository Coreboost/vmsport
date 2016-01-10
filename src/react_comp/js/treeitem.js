const React = require('react');
const _ = require('lodash');
const utils = require('./utils.js');

const TreeItem = React.createClass({
  getInitialState: function () {
    return {
      expanded: false,
      focused: false
    };
  },
  touchTapped: function (e) {
    this.props.root.handleTreeItemTap(this, e);
  },
  getLabelClass: function () {
    if (_.contains(this.props.selection, this.props.id)) {
        return "tree-item-label-selected";
    }
    return "tree-item-label";
  },
  toggleExpanded: function () {
    this.setState({expanded: !this.state.expanded});
  },
  render: function () {
    var icon;
    var childContainerStyle = {display: "block"};
    let childLevel = this.props.level + 1;
    if (this.props.childData.length == 0) {
      icon = utils.renderIcon();
      childContainerStyle.display = "block";
    } else {
      if (this.state.expanded) {
        icon = utils.renderIcon("keyboard_arrow_down", this.toggleExpanded);
        childContainerStyle.display = "block";
      } else {
        icon = utils.renderIcon("keyboard_arrow_right", this.toggleExpanded);
        childContainerStyle.display = "none";
      }
    }
    var r = this.props.root;
    let renderedChildren = [];
    this.props.childData.forEach(function (c) {
      renderedChildren.push(utils.renderTreeItemRow(c, r, childLevel));
    });
    return (
      <div className="treeItem">
        <div className="treeItemRow" style={this.props.style}>{icon}<span contentEditable="true" className={this.getLabelClass()} onTouchTap={this.touchTapped}>{this.props.name}</span></div>
        <div className="treeItemChildren" style={childContainerStyle}>
          {renderedChildren}
        </div>
      </div>
    );
  },
});

module.exports = TreeItem;

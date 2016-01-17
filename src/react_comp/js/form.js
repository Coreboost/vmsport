const React = require('react');
var utils = require('./utils.js');
const Tree = React.createClass({
  getInitialState: function () {
    return {
      this.props.
      selection: [],
      focused: undefined,
      edited: undefined
    }
  },
  render: function () {
    var rows = [];
    var root = this;
    this.props.treeData.forEach(function (treeItemData) {
      rows.push(utils.renderTreeItemRow(treeItemData, root, 0));
    });
    return (
      <div className="tree">
        {rows}
      </div>
    );
  },
});

module.exports = Tree;

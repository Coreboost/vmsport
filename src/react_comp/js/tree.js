const React = require('react');
var utils = require('./utils.js');
const Tree = React.createClass({
  getInitialState: function () {
    return {
      selection: [],
      focused: undefined,
      edited: undefined
    }
  },
  handleTreeItemTap: function(treeItem, e) {
    function ctrlPressed(e) {
      return (e && e.nativeEvent && e.nativeEvent.ctrlKey);
    }
    function shiftPressed(e) {
      return (e && e.nativeEvent && e.nativeEvent.shiftKey);
    }
    if (treeItem.props.id === this.state.focused) {
        this.setState({edited: treeItem.props.id});
    }
    this.setState({focused: treeItem.props.id});
    if (!ctrlPressed(e) && !shiftPressed(e)) {
      this.setState({selection: [treeItem.props.id]});
    } else if (ctrlPressed(e)) {
      if (_.contains(this.state.selection, treeItem.props.id)) {
          this.setState({selection: _.without(this.state.selection, treeItem.props.id)});
      } else {
        this.setState({selection: this.state.selection.push(treeItem.props.id)});
      }
    } else {
      throw "Shift-click not implemented";
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

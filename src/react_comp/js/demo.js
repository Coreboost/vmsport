const React = require('react');
const Tree = require('./tree.js');
const TreeItem = require('./treeitem.js');

const Demo = React.createClass({
formData: {
  layout: {
    name: "VT_LAYOUT",
    size: {
      rows: 24,
      columns: 80
    },
    lists: {
      LOCATION_CODES:
    }
  }
},

  render: function () {
    return (
      <div className="demo">
        <Tree treeData={this.treeData}/>
      </div>
    );
  },
});

module.exports = Demo;

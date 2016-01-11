const TreeItem = require('./treeitem.js')

function renderTreeItemRow(treeItemData, root, level) {
  console.log("id:" + treeItemData.id + " level:" + level);
  let style = {
    paddingLeft: level*10
  }
  return (<TreeItem
              id={treeItemData.id}
              key={treeItemData.id}
              name={treeItemData.name}
              childData={treeItemData.childData}
              style={style}
              root={root}
              selection={root.state.selection}
              level={level}
          />);
}

function renderIcon(face, touchTapCallback) {
  return (
    <span className="clickable-icon"><i onTouchTap={touchTapCallback} className="material-icons" >{face}</i></span>
  );
}

exports.renderTreeItemRow = renderTreeItemRow;
exports.renderIcon = renderIcon;

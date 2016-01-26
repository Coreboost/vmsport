const React = require('react');
const _ = require('lodash');

const RectangleLiteral = React.createClass({
  render: function () {
    var nseg = this.props.definition.length - 1;
    var oneCorner, otherCorner, topLine, bottomLine, leftColumn, rightColumn;
    oneCorner = this.props.definition[0];
    otherCorner  = this.props.definition[1];
    leftColumn = Math.min(oneCorner.column, otherCorner.column);
    rightColumn = Math.max(oneCorner.column, otherCorner.column);
    topLine = Math.min(oneCorner.line, otherCorner.line);
    bottomLine = Math.max(oneCorner.line, otherCorner.line);


    var segments = [];
    var key = 1;
    var style = {
      position: "absolute",
      left: (leftColumn - 1) * 10 + 5,
      top: (topLine - 1) * 20 + 10,
      width: (rightColumn - leftColumn) * 10,
      height: (bottomLine - topLine) * 20,
      borderWidth: 2,
      borderStyle: "solid",
      borderColor: "Black",
      backgroundColor: "Transparent"
    };
    return (
      <div className="rectangleliteral" style={style} />
    );
  },
});

module.exports = RectangleLiteral;

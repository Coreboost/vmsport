const React = require('react');
const _ = require('lodash');

const PolylineLiteral = React.createClass({
  render: function () {
    var nseg = this.props.definition.length - 1;
    var iseg, topLine, bottomLine, leftColumn, rightColumn, start, end;
    var segments = [];
    var key = 1;
    for (iseg=1; iseg<=nseg; iseg += 1) {
      start = this.props.definition[iseg-1];
      end = this.props.definition[iseg];
      if (start.line === end.line) {
        // Horizontal line
        leftColumn = Math.min(start.column, end.column);
        rightColumn = Math.max(start.column, end.column);
        topLine = bottomLine = start.line;
      } else if (start.column === end.column) {
        // Vertical line
        topLine = Math.min(start.line, end.line);
        bottomLine = Math.max(start.line, end.line);
        leftColumn = rightColumn = start.column;
      } else {
        throw "Polyline-segments was not orthogonal and is ignored.";
      }
      var style = {
        position: "absolute",
        left: (leftColumn - 1) * 10 + 4,
        top: (topLine - 1) * 22 + 10,
        width: (rightColumn - leftColumn) * 10 + 2,
        height: (bottomLine - topLine) * 22 + 2,
        borderWidth: "1px",
        borderColor: "Black",
        backgroundColor: "Black"
      };
      segments.push(
        <div key={key++} className="polylineliteral" style={style} />
      );
    }
    var cstyle = {
      position: "absolute",
      left: 0,
      top: 0,
      right: "100%",
      bottom: "100%",
      borderWidth: "0",
      backgroundColor: "Transparent"
    };
    return (
      <div style={cstyle}>
        {segments}
      </div>
    );
  },
});

module.exports = PolylineLiteral;

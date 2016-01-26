const TextLiteral = require('./textliteral.js');
const PolylineLiteral = require('./polylineliteral.js');
const RectangleLiteral = require('./rectangleliteral.js');

var key = 1;
function renderWidgets(text_literals, polyline_literals, rectangle_literals) {
  var widgets = [];
  if (text_literals) {
    text_literals.forEach(function (tl_def) {
      widgets.push(
        <TextLiteral key={key++} definition={tl_def} />
      );
    });
  }
  if (polyline_literals) {
    polyline_literals.forEach(function (pl_def) {
      widgets.push(
        <PolylineLiteral key={key++} definition={pl_def} />
      );
    });
  }
  if (rectangle_literals) {
    rectangle_literals.forEach(function (rt_def) {
      widgets.push(
        <RectangleLiteral key={key++} definition={rt_def} />
      );
    });
  }
  return widgets;
}
module.exports =  renderWidgets;

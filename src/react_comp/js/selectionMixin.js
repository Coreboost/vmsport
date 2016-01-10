const React = require('react');
const _ = require('lodash');

var SelectionMixin = {
  _selection: [],
  getSelected: function () {
    return _.clone(_selection);
  },
  setSelection: function(selection) {
    oldSelection = _.clone(_selection);
    newSelection = _clone(selection);
    _selection = _clone(selection);
    fireSelectionChanged(oldSelection, newSelection);
    return this;
  },
  clearSelection: function() {
    oldSelection = _.clone(_selection);
    _selection = [];
    fireSelectionChanged(oldSelection, []);
    return this;
  },
  addToSelection: function(ids) {
    oldSelection = _.clone(_selection);
    ids.forEach(function (id) {
      if (!_.contains(_selection, id)) {
        _selection.push(id);
      }
    });
    newSelection = _.clone(_selection);
    fireSelectionChanged(oldSelection, newSelection);
    return this;
  },
  removeFromSelection: function (ids) {
    oldSelection = _.clone(_selection);
    ids.forEach(function (id) {
      if (_.contains(_selection, id)) {
        _selection = _selection.without(id);
      }
    });
    newSelection = _.clone(_selection);
    fireSelectionChanged(oldSelection, newSelection);
    return this;
  },
  toggleInSelection: function(ids) {
    oldSelection = _.clone(_selection);
    ids.forEach(function (id) {
      if (_.contains(_selection, id)) {
        _selection = _selection.without(id);
      } else {
        _selection.push(id);
      }
    });
    newSelection = _.clone(_selection);
    fireSelectionChanged(oldSelection, newSelection);
    return this;
  }
};

module.exports = SelectionMixin;

// Support for handling of ifdl forms

// This should be a module of some kind and handle it with require

var _forms = {};

var _form_prototype = {

};

function form(name) {
  this.name = name;
  this.formData = {};
  this.formRecords = {};
  this.layouts = {};
  this.addFormData = function(name) {
    this.formData[name] = undefined;
  };
  this.addFormRecord = function(name) {
    this.formData[name] = new formRecord();
  };
  this.addLayout = function(name) {
    this.layouts[name] = new layout(name);
  };

}

  _forms[name] = newForm;
  return newForm;
}

function getForm(name) {
  return _forms[name];
}

function addFormRecord

function addLayout(form, name) {

}

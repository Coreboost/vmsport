/*jslint indent: 2 */
"use strict";
(function () {
  const React = require('react');
  const ReactDOM = require('react-dom');
  const FormManager = require('./formmanager.js');

  //Needed for React Developer Tools
  window.React = React;
  $(document).ready(function(){
      namespace = '/ifdl';
      var socket = io.connect('http://' + document.domain + ':' + location.port + namespace);

      socket.on('connect', function() {
        socket.emit('send forms');
      });

      socket.on('disconnect', function() {
      });

      socket.on('forms', function(msg) {
        console.log(msg);
        this.forms = ['One form', 'Another form'];
        ReactDOM.render(<FormManager forms={this.forms} />, document.getElementById('content'));
      });
  });


})();

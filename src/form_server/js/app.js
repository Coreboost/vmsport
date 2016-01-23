/*jslint indent: 2 */
"use strict";
(function () {
  const React = require('react');
  const ReactDOM = require('react-dom');
  const FormManager = require('./formmanager.js');
  console.log('Intializing');

  //Needed for React Developer Tools
  window.React = React;
  $(document).ready(function(){
      var namespace = '/ifdl';
      var socket = io.connect('http://' + document.domain + ':' + location.port + namespace);

      socket.on('connect', function() {
        socket.emit('send forms');
      });

      socket.on('disconnect', function() {
      });

      socket.on('forms', function(msg) {
        ReactDOM.render(<FormManager forms={msg} socket={socket} />, document.getElementById('content'));
      });

      socket.on('initialize form', function(form_data) {
        console.log('*** Initializing form ***');
        ReactDOM.render(<p>Initializing form...</p>, document.getElementById('content'));
        console.log(form_data);
      });
  });


})();

Notes about the parser implementation
=====================================
* The parser is not supporting the complete IFDL language but the first goal is just to be able to parse the Mileage example from the DecForms documentation.
* Some parts go a bit further, for example the parsing of logical/relational/value expressions. However, note in particular that parenthesis are not
  supported in numeric expressions, when they are part of a conditional expression in the current parse implementation. It may be that this is not possible to
  support given the IFDL language and the Yapps2 parser generator (only one token of look-ahead, it might be that infinite look-ahead is needed here.). Further
  analysis needed here but I would believe that this is an acceptable limitation given the purpose of the parser/translator.

Notes about the generation of JavaScript/HTML/Backend
=====================================================
- Get a Python server up and running with Socket.io and Flask (Flask is for Rest so is it really needed or??)
- Define an end-point for loading up a form. Something like: /loadform/form-name
- This should send over the form definition and the initial data and then we go into send/recieve mode until we close things
 some kind of session/auth needs to be done but that can be left for later.
- Need to generate code for the default keybindings:
  Tab/Enter -> Next field
  F12/Backspace/Shift-tab -> Previous field
  F10/Ctrl-Z -> Save and exit
- En Function i IFDL blir egentligen en key-binding i Javascript.
- En Function response i IFDL är själva funktionen. Function responses kan gömma varandra
  Layout/Panel/Group/Field-Icon
- Need to generate code for the lifecycle, something like this:
  - Navigate to a URL which corresponds to a particular form and initiate a session
  - The HTML and Javascript for the form is downloaded to the client, a websocket is setup-
  - Now the following actions can be taken:
    SEND: Data is sent from the application to the form
    RECEIVE: Data is sent from the form to the application
    TRANSCEIVE:
    CALL:





1. ENABLE
2. SEND
3. RECEIVE
4. TRANSCEIVE
5. DISABLE
6. CANCEL

Notes about the parser implementation
=====================================
* The parser is not supporting the complete IFDL language but the first goal is just to be able to parse the Mileage example from the DecForms documentation.
* Some parts go a bit further, for example the parsing of logical/relational/value expressions. However, note in particular that parenthesis are not
  supported in numeric expressions, when they are part of a conditional expression in the current parse implementation. It may be that this is not possible to
  support given the IFDL language and the Yapps2 parser generator (only one token of look-ahead, it might be that infinite look-ahead is needed here.). Further
  analysis needed here but I would believe that this is an acceptable limitation given the purpose of the parser/translator.

Notes about the generation of JavaScript/HTML/Backend
=====================================================
- Field defaults (bold, underline and so on) are ignored for now. Need to decide if they should be handled at all and then how.
  The thing is of course that it may be more interesting to generate classes for the tags we generate so that it is easy enough
  to tweak visuals in CSS. If we generate anything from the field defaults it should probably be CSS anyway.
- Display %Keypad_Appplication is currently ignored
- There is something with that the tab order does't work for the buttons/icons as I think it should...
- This should send over the form definition and the initial data and then we go into send/recieve mode until we close things
 some kind of session/auth needs to be done but that can be left for later.
- Need to generate code for the default keybindings:
  Tab/Enter -> Next field ** Not done/needed
  F12/Backspace/Shift-tab -> Previous field  ** Not done/needed
  F10/Ctrl-Z -> Save and exit

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

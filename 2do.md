Short term
----------
* Update the vagrant box so that:
 - Install Atom
 - Write makefiles for generating the python parser and running the translation
 - Test interoperability Fortran/C/Go, interestingly it is so that this should be a
   non-issue under VMS since calling conventions, stack usage etc are standardized on the OS
   level. Try this on an emulator.
 - Write makefiles for building the example Programs
 - Make sure that kernel messaging is available, try to run that in Fortran
 - Write a wrapper for kernel messaging  that is similar to Mailboxes and try it
 - Write another wrapper for ZeroMQ
 - Write test harnesses and apply load to evaluate performance/throughput
 - Test in on OpenVMS
 - Whenever I am tired, work on the parsers
 - Write React components that map to IFDL concepts
 - Add the generation of javascript based on these react components.
OpenVMS Mailboxes
-----------------
* POC Mailbox Replacement Create two Fortran Programs that communicate through message passing using:
  * Zero MQ
  * Posix Kernel queues
  * Wrap this in a generic interface that can map either to:
    - OpenVMS Mailboxes
    - ZeroMQ
    - Posix Kernel queues
  * Det känns litet orimligt att olika moduler ska skriva på samma filer samtidigt. Det känns ju som en rätt hopplös design.
  * Google Protocol buffers or eProsima Fast Buffers (http://www.eprosima.com/index.php/products-all/eprosima-fast-buffers)

IFDL / DecForms
---------------
  * Create IFDL Translator in Python
  * Generate a HTML/Javascript client, possibly by implementing a number of React components that map to the IFDL components.
  * Use (possibly) protocolbuffers and something, socket.io, nullMQ, whatever to communicate with the backend
  which will be a go-webserver.

Test on OpenVMS
---------------
* Set up an Alpha Emulator and get OpenVMS from the hobbyist program
* Compile and run the application above and test with Mailboxes and with ZeroMQ/Protocolbuffers

Other of interest
-----------------
* There is a GNU VMSLib

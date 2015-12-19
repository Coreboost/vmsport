Short term
----------

OpenVMS Mailboxes
-----------------
* POC Mailbox Replacement Create two Fortran Programs that communicate through message passing using:
  * Zero MQ
  * Named pipes (not so good)
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

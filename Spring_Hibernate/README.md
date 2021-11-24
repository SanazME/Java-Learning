### What is Java Servelet and Tomcat?
- A servlet is simply a class which responds to a particular type of network request - most commonly an HTTP request. Basically servlets are usually used to implement web applications - but there are also various frameworks which operate on top of servlets (e.g. Struts) to give a higher-level abstraction than the "here's an HTTP request, write to this HTTP response" level which servlets provide.

Servlets run in a servlet container which handles the networking side (e.g. parsing an HTTP request, connection handling etc). One of the best-known open source servlet containers is Tomcat.

A servlet at its very core is a java class; which can handle HTTP requests. Typically the internal nitty-gritty of reading a HTTP request and response over the wire is taken care of by the containers like Tomcat. This is done so that as a server side developer you can focus on what to do with the HTTP request and responses and not bother about dealing with code that deals with networking etc. The container will take care of things like wrapping the whole thing in a HTTP response object and send it over to the client (say a browser).

Assuming you have a container, your servlets are now java classes whose lifecycle will be maintained by the container but their reaction to incoming HTTP requests will be decided by you. You do that by writing what-you-want-to-do in the pre-defined methods like init(), doGet(), doPost() etc. Look at Resource 3. Simple servlet example: https://www.tutorialspoint.com/servlets/servlets-first-example.htm

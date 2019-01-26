
wsdl2java -> CXF   -> implements  JAX-WS specification  JBOSS
wsimport  -> Metro -> implements  JAX-WS specification  JRE


Generating client stubs or server skeletons

stubs <-> port <-> remote proxy



Generating model classes and message classes

from project folder text:

 wsimport -s src -p br.com.caelum.estoque.cliente  http://localhost:8080/estoquews-web/EstoqueWSImpl?wsdl


With these classes we can create a client for our service. EstoqueWS interface is ready
to receive something which calls Port. Port is nothing but an object that communicate with service!
It abstract all details of how establish a HTTP connection and generate SOAP message. In some cases
it is also called stub. Anyway, in the design patterns world this object is also called proxy
or remote proxy. Three names for just one thing. Port, Stub or Remote Proxy



Correios
http://www.correios.com.br/precos-e-prazos/calculador-remoto-de-precos-e-prazos
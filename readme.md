**Getting Started**
git clone [<repository-url>](https://github.com/IvanCausera/invoice-processor-back)
cd invoice-processor-back
mvn clean install
Configure the database connection in application.yml

**Upload Invoices**
URL: /api/invoices/xml
Method: POST
Consumes: application/xml
Produces: text/csv

Example:
curl -X POST -H "Content-Type: application/xml" -d @invoices.xml http://localhost:8080/api/invoices/xml


**Get Tolls**
URL: /api/invoices/toll
Method: GET
Produces: text/csv

Example
curl -X GET http://localhost:8080/api/invoices/toll
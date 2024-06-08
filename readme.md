## Getting Started

To get a local copy up and running follow these simple steps:

1. Clone the repository
   ```sh
   git clone https://github.com/IvanCausera/invoice-processor-back
   ```
2. Install dependencies
   ```sh
   cd invoice-processor-back
   mvn clean install
   ```
3. Configure application.yml
  ```yml
spring:
    application:
        name: invoice-processor-back
    data:
        mongodb:
            uri: mongodb://localhost:27018/invoicesdb
            database: invoicesdb
  ```

## Usage

### Upload Invoices
  * URL: /api/invoices/xml
  * Method: POST
  * Consumes: application/xml
  * Produces: text/csv

**Example:**
  ```sh
  curl -X POST -H "Content-Type: application/xml" -d @invoices.xml http://localhost:8080/api/invoices/xml
  ```

### Get Tolls
  * URL: /api/invoices/toll
  * Method: GET
  * Produces: text/csv

**Example:**
  ```sh
  curl -X GET http://localhost:8080/api/invoices/toll
  ```

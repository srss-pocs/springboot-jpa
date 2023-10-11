A simple Spring boot application which connects to Postgresql and creates a table 
All 5 CRUD operation APIs are available in controller

Make sure db created according to the app properties files
Note in properties file : spring.jpa.hibernate.ddl-auto=update (to create table/columns automatically)


The values create, create-drop, validate, and update basically influence how the schema tool management will manipulate the database schema at startup.

For example, the update operation will query the JDBC driver's API to get the database metadata and then Hibernate compares the object model it creates based on reading your annotated classes or HBM XML mappings and will attempt to adjust the schema on-the-fly.

The update operation for example will attempt to add new columns, constraints, etc but will never remove a column or constraint that may have existed previously but no longer does as part of the object model from a prior run.

Typically in test case scenarios, you'll likely use create-drop so that you create your schema, your test case adds some mock data, you run your tests, and then during the test case cleanup, the schema objects are dropped, leaving an empty database.

In development, it's often common to see developers use update to automatically modify the schema to add new additions upon restart. But again understand, this does not remove a column or constraint that may exist from previous executions that is no longer necessary.

In production, it's often highly recommended you use none or simply don't specify this property. That is because it's common practice for DBAs to review migration scripts for database changes, particularly if your database is shared across multiple services and applications.
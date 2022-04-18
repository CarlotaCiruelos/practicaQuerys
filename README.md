# practicaQuerys

## Java package
### Entidades
He creado dos clases: User y Account cada una de ellas con un @Id y @Table
### Repository: aquí definimos las operaciones básicas y los joins
1. UserJdbcTemplateRepository uso de jdbcTemplate para update y delete
2. UserRepository uso de select y update con @Query
3. AccountRepository dos joins con @Query:
    - 3.1 Inner-join 
    - 3.2 Left-join  

### Database : insert con jdbTemplate
Inicialización de las bases de datos con insert. 

## Resources package
### Propierties
He introducido la base de datos H2

### Schema
Create tables: User y Account con los atributos de las clases User y Account

## PracticaQueryApplication: secuencia de operaciones
1. INSERT
- INSERT FORMA 1 CON jdbcTemplate
- INSERT FORMA 2 CON save()
2. UPDATE
- UPDATE FORMA 1 CON @QUERY
- UPDATE FORMA 2 CON JdbcTemplate
3. SELECT
- SELECT FORMA 1 CON @QUERY
- SELECT CON EL MÉTODO FINDBY() y findALL()
4. DELETE
- DELETE FORMA 1 CON DELETE()
- DELETE CON JdbcTemplate
5. JOINS CON @QUERY
- INNER JOIN
- LEFT JOIN

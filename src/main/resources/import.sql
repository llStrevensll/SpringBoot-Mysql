/* Populate tables */
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Angel', 'Rodriguez', 'correo@email.com', '2019-03-01', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Steven', 'Rodriguez', 'correo1@email.com', '2019-03-02', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Emanuel', 'Rodriguez', 'correo2@email.com', '2019-03-03', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Jhon', 'Lopez', 'correo3@email.com', '2019-03-04', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Angelo', 'Gutierrez', 'correo4@email.com', '2019-03-05', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre1', 'Apellido1', 'correo5@email.com', '2019-03-06', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre2', 'Apellido2', 'correo6@email.com', '2019-03-07', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre3', 'Apellido3', 'correo7@email.com', '2019-03-08', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre4', 'Apellido4', 'correo8@email.com', '2019-03-09', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre5', 'Apellido5', 'correo9@email.com', '2019-03-10', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre6', 'Apellido6', 'correo10@email.com', '2019-03-11', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre7', 'Apellido7', 'correo11@email.com', '2019-03-12', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre8', 'Apellido8', 'correo12@email.com', '2019-03-13', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre9', 'Apellido9', 'correo13@email.com', '2019-03-14', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre10', 'Apellido10', 'correo14@email.com', '2019-03-15', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre11', 'Apellido11', 'correo15@email.com', '2019-03-16', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre12', 'Apellido12', 'correo16@email.com', '2019-03-17', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre13', 'Apellido13', 'correo17@email.com', '2019-03-18', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre14', 'Apellido14', 'correo18@email.com', '2019-03-19', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre15', 'Apellido15', 'correo19@email.com', '2019-03-20', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre16', 'Apellido16', 'correo20@email.com', '2019-03-21', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre17', 'Apellido17', 'correo21@email.com', '2019-03-22', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre18', 'Apellido18', 'correo22@email.com', '2019-03-23', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre19', 'Apellido19', 'correo23@email.com', '2019-03-24', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre20', 'Apellido20', 'correo24@email.com', '2019-03-25', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre21', 'Rodriguez21', 'correo25@email.com', '2019-03-26', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre22', 'Rodriguez22', 'correo26@email.com', '2019-03-27', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre23', 'Rodriguez23', 'correo27@email.com', '2019-03-28', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre24', 'Rodriguez24', 'correo28@email.com', '2019-03-29', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre25', 'Rodriguez25', 'correo29@email.com', '2019-03-30', '');
INSERT INTO clientes(nombre, apellido, email, create_at, foto) VALUES('Nombre26', 'Rodriguez26', 'correo30@email.com', '2019-03-31', '');

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, create_at) VALUES ('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Bianchi Bicicleta Aro 26',69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Mica Comoda 5 Cajones', 299990, NOW());

/* Crear facturas */
INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas(descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', null, 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);



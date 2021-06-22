INSERT INTO ASEGURADO (ID, DIRECCION, EDAD, NOMBRE)
VALUES(1, 'JDJ 432', 34, 'Lucas Diaz');

INSERT INTO ASEGURADO (ID, DIRECCION, EDAD, NOMBRE)
VALUES(2, 'PD 901', 23, 'Sofia Velez');

INSERT INTO COBERTURA 
VALUES(1, 'Vida Total', 'VIDA');

INSERT INTO COBERTURA 
VALUES(2, 'Vida Ahorro', 'VIDA');

INSERT INTO COBERTURA 
VALUES(3, 'Vida Temporal', 'VIDA');

INSERT INTO COBERTURA 
VALUES(4, 'Deportistas', 'AP');

INSERT INTO COBERTURA 
VALUES(5, 'Trabajo', 'AP');

INSERT INTO COBERTURA 
VALUES(6, 'Profesionales', 'AP');

INSERT INTO POLIZA 
VALUES( 1, 200.0 ,  '2019-06-12' ,'tarjeta visa', 'pesos', 'debito' , 200000 , 2, 3);

INSERT INTO POLIZA 
VALUES( 2, 500.0 ,  '2018-03-12' , 'tarjeta visa', 'pesos',  'debito' , 900000 , 1, 2);

INSERT INTO POLIZA 
VALUES( 3, 200.0 ,  '2020-09-10' , 'tarjeta master', 'USD', 'debito' , 200000 , 2, 3);

INSERT INTO POLIZA 
VALUES( 4, 600.0 ,  '2020-04-12' , 'tarjeta master', 'pesos',  'debito' , 1000000 , 1, 4);

INSERT INTO POLIZA 
VALUES( 5, 890.0 ,  '2019-03-10' , 'tarjeta visa', 'USD', 'debito' , 1500000 , 1, 6);

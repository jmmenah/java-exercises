DROP TABLE IF EXISTS PROVINCIAS;

DROP TABLE IF EXISTS AUTONOMIAS;

CREATE TABLE AUTONOMIAS
(
  COD_AUT INTEGER PRIMARY KEY,
  AUTONOMIA TEXT NOT NULL
);

CREATE TABLE PROVINCIAS
( 
  COD_PROV INTEGER PRIMARY KEY,
  PROVINCIA TEXT NOT NULL, 
  COD_AUT INTEGER,
  CONSTRAINT fk_PROV_AUT FOREIGN KEY (COD_AUT) REFERENCES AUTONOMIAS(COD_AUT)
);	

INSERT INTO AUTONOMIAS VALUES(1,'ANDALUCIA');
INSERT INTO AUTONOMIAS VALUES(2,'ARAGON');
INSERT INTO AUTONOMIAS VALUES(3,'PRINCIPADO DE ASTURIAS');
INSERT INTO AUTONOMIAS VALUES(4,'ILLES BALEARS');
INSERT INTO AUTONOMIAS VALUES(5,'CANARIAS');
INSERT INTO AUTONOMIAS VALUES(6,'CANTABRIA');
INSERT INTO AUTONOMIAS VALUES(7,'CASTILLA Y LEON');
INSERT INTO AUTONOMIAS VALUES(8,'CASTILLA - LA MANCHA');
INSERT INTO AUTONOMIAS VALUES(9,'CATALUÑA');
INSERT INTO AUTONOMIAS VALUES(10,'EXTREMADURA');
INSERT INTO AUTONOMIAS VALUES(11,'GALICIA');
INSERT INTO AUTONOMIAS VALUES(12,'MADRID');
INSERT INTO AUTONOMIAS VALUES(13,'REGION DE MURCIA');
INSERT INTO AUTONOMIAS VALUES(14,'COMUNIDAD FORAL DE NAVARRA');
INSERT INTO AUTONOMIAS VALUES(15,'COMUNIDAD VALENCIANA');
INSERT INTO AUTONOMIAS VALUES(16,'PAIS VASCO');
INSERT INTO AUTONOMIAS VALUES(17,'LA RIOJA');
INSERT INTO AUTONOMIAS VALUES(18,'CEUTA');
INSERT INTO AUTONOMIAS VALUES(19,'MELILLA');

INSERT INTO PROVINCIAS VALUES(1,'ALAVA',16);
INSERT INTO PROVINCIAS VALUES(2,'ALBACETE',8);
INSERT INTO PROVINCIAS VALUES(3,'ALICANTE',15);
INSERT INTO PROVINCIAS VALUES(4,'ALMERIA',1);
INSERT INTO PROVINCIAS VALUES(5,'AVILA',7);
INSERT INTO PROVINCIAS VALUES(6,'BADAJOZ',10);
INSERT INTO PROVINCIAS VALUES(7,'ILLES BALEARS',4);
INSERT INTO PROVINCIAS VALUES(8,'BARCELONA',9);
INSERT INTO PROVINCIAS VALUES(9,'BURGOS',7);
INSERT INTO PROVINCIAS VALUES(10,'CACERES',10);
INSERT INTO PROVINCIAS VALUES(11,'CADIZ',1);
INSERT INTO PROVINCIAS VALUES(12,'CASTELLON',15);
INSERT INTO PROVINCIAS VALUES(13,'CIUDAD REAL',8);
INSERT INTO PROVINCIAS VALUES(14,'CORDOBA',1);
INSERT INTO PROVINCIAS VALUES(15,'A CORUÑA',11);
INSERT INTO PROVINCIAS VALUES(16,'CUENCA',8);
INSERT INTO PROVINCIAS VALUES(17,'GIRONA',9);
INSERT INTO PROVINCIAS VALUES(18,'GRANADA',1);
INSERT INTO PROVINCIAS VALUES(19,'GUADALAJARA',8);
INSERT INTO PROVINCIAS VALUES(20,'GUIPUZCOA',16);
INSERT INTO PROVINCIAS VALUES(21,'HUELVA',1);
INSERT INTO PROVINCIAS VALUES(22,'HUESCA',2);
INSERT INTO PROVINCIAS VALUES(23,'JAEN',1);
INSERT INTO PROVINCIAS VALUES(24,'LEON',7);
INSERT INTO PROVINCIAS VALUES(25,'LLEIDA',9);
INSERT INTO PROVINCIAS VALUES(26,'LA RIOJA',17);
INSERT INTO PROVINCIAS VALUES(27,'LUGO',11);
INSERT INTO PROVINCIAS VALUES(28,'MADRID',12);
INSERT INTO PROVINCIAS VALUES(29,'MALAGA',1);
INSERT INTO PROVINCIAS VALUES(30,'MURCIA',13);
INSERT INTO PROVINCIAS VALUES(31,'NAVARRA',14);
INSERT INTO PROVINCIAS VALUES(32,'OURENSE',11);
INSERT INTO PROVINCIAS VALUES(33,'ASTURIAS',3);
INSERT INTO PROVINCIAS VALUES(34,'PALENCIA',7);
INSERT INTO PROVINCIAS VALUES(35,'LAS PALMAS',5);
INSERT INTO PROVINCIAS VALUES(36,'PONTEVEDRA',11);
INSERT INTO PROVINCIAS VALUES(37,'SALAMANCA',7);
INSERT INTO PROVINCIAS VALUES(38,'SANTA CRUZ DE TENERIFE',5);
INSERT INTO PROVINCIAS VALUES(39,'CANTABRIA',6);
INSERT INTO PROVINCIAS VALUES(40,'SEGOVIA',7);
INSERT INTO PROVINCIAS VALUES(41,'SEVILLA',1);
INSERT INTO PROVINCIAS VALUES(42,'SORIA',7);
INSERT INTO PROVINCIAS VALUES(43,'TARRAGONA',9);
INSERT INTO PROVINCIAS VALUES(44,'TERUEL',2);
INSERT INTO PROVINCIAS VALUES(45,'TOLEDO',8);
INSERT INTO PROVINCIAS VALUES(46,'VALENCIA',15);
INSERT INTO PROVINCIAS VALUES(47,'VALLADOLID',7);
INSERT INTO PROVINCIAS VALUES(48,'VIZCAYA',16);
INSERT INTO PROVINCIAS VALUES(49,'ZAMORA',7);
INSERT INTO PROVINCIAS VALUES(50,'ZARAGOZA',2);
INSERT INTO PROVINCIAS VALUES(51,'CEUTA',18);
INSERT INTO PROVINCIAS VALUES(52,'MELILLA',19);
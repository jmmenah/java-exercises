/*
 * Pool de conexiones: BasicDataSource
 * http://www.chuidiang.org/java/mysql/BasicDataSource-Pool-Conexiones.php
 */
/*
CREATE TABLE testdb.person (
  PERSON_ID int auto_increment PRIMARY KEY,
  age int NOT NULL,
  firstname varchar(10) NOT NULL,
  lastname varchar(20) NOT NULL
);
 */
package com.chuidiang.ejemplos.datasource_mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Ejemplo simple de uso de BasicDataSource.
 *
 * @author Chuidiang
 */
public class EjemploDataSource {

    /**
     * @param args
     */
    public static void main(String[] args) {
        new EjemploDataSource();
    }

    /**
     * Pool de conexiones
     */
    private DataSource dataSource;

    /**
     * Inicializa el pool de conexiones BasicDataSource y realiza una inserción
     * y una consulta
     */
    public EjemploDataSource() {
        inicializaDataSource();
        inserta();
        realizaConsulta();
    }

    /**
     * Inicializacion de BasicDataSource
     */
    private void inicializaDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        // Loading class `com.mysql.jdbc.Driver'. This is deprecated.
        // The new driver class is `com.mysql.cj.jdbc.Driver'.
        // The driver is automatically registered via the SPI and manual loading of the driver class
        // is generally unnecessary.
        //basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");
        basicDataSource.setUrl("jdbc:mysql://localhost/testdb");

        // Opcional. Sentencia SQL que le puede servir a BasicDataSource
        // para comprobar que la conexión es correcta.
        basicDataSource.setValidationQuery("select 1");

        dataSource = basicDataSource;
    }

    /**
     * Realiza una inserción, pidiendo una conexión al dataSource y cerrándola
     * inmediatamente después, para liberarla.
     */
    private void inserta() {
        Connection conexion = null;
        try {
            // BasicDataSource nos reserva una conexión y nos la devuelve.
            conexion = dataSource.getConnection();

            // La inserción.
            Statement ps = conexion.createStatement();
            ps.executeUpdate("insert into person values (null,22,'Pedro','Martinez')");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            liberaConexion(conexion);
        }
    }

    /**
     * Cierra la conexión. Al provenir de BasicDataSource, en realidad no se
     * está cerrando. La llamada a close() le indica al BasicDataSource que
     * hemos terminado con dicha conexión y que puede asignársela a otro que la
     * pida.
     *
     * @param conexion
     */
    private void liberaConexion(Connection conexion) {
        try {
            if (null != conexion) {
                // En realidad no cierra, solo libera la conexión.
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Realiza una consulta a la base de datos y muestra los resultados en
     * pantalla.
     */
    private void realizaConsulta() {
        Connection conexion = null;
        try {
            conexion = dataSource.getConnection();
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery("select * from person");

            // La tabla tiene cuatro campos.
            while (rs.next()) {
                System.out.println(rs.getObject("PERSON_ID"));
                System.out.println(rs.getObject("age"));
                System.out.println(rs.getObject("lastname"));
                System.out.println(rs.getObject("firstname"));
                System.out.println("--------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // En el finally, para asegurar que se ejecuta, se cierra la
            // conexión.
            liberaConexion(conexion);
        }
    }
}

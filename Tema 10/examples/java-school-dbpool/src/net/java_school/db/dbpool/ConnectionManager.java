/*
 * Connection Pool
 * http://www.java-school.net/jdbc/Connection-Pool
 */

package net.java_school.db.dbpool;

import java.sql.*;
import java.io.*;
import java.util.*;

import net.java_school.util.Log;

public abstract class ConnectionManager {
    protected DBConnectionPoolManager connMgr;
    protected String poolName, dbServer, dbName, port, userID, passwd;
    protected int maxConn,initConn, maxWait;
    private Properties dbProperties;
    private String configFile;

    public ConnectionManager(String pool) {
        poolName = pool;
        //Specifying the directory for the Property file
        configFile = "resources/"+poolName+".properties";

        try {
            dbProperties = readProperties();
            dbServer = getProperty("dbServer");
            port = getProperty("port");
            dbName = getProperty("dbName");
            userID = getProperty("userID");
            passwd = getProperty("passwd");
            maxConn = Integer.parseInt(getProperty("maxConn"));
            initConn = Integer.parseInt(getProperty("initConn"));
            maxWait = Integer.parseInt(getProperty("maxWait"));
        } catch (IOException ioe) {
            Log.err("Error reading properties of " + configFile);
        }
    }

    public Connection getConnection() {
        return (connMgr.getConnection(poolName));
    }

    public void freeConnection(Connection conn) {
        connMgr.freeConnection(poolName, conn);
    }

    private String getProperty(String prop) throws IOException {
        return (dbProperties.getProperty(prop));
    }

    protected synchronized Properties readProperties() throws IOException {
        Properties tempProperties = new Properties();
        FileInputStream in = new FileInputStream(configFile);
        tempProperties.load(in);
        return tempProperties;
    }

    public int getDriverNumber() {
        return connMgr.getDriverNumber();
    }

}
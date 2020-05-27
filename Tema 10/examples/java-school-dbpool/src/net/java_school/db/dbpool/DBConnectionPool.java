/*
 * Connection Pool
 * http://www.java-school.net/jdbc/Connection-Pool
 */

package net.java_school.db.dbpool;

import java.util.*;
import java.sql.*;
import java.util.Date;

import net.java_school.util.Log;

class DBConnectionPool {
    //Number of connections currently in use
    private int checkedOut;

    // Free Connection List
    private Vector<Connection> freeConnections = new Vector<Connection>();

    //Maximum number of connections
    private int maxConn;

    //Initial number of connections
    private int initConn;

    //Waiting time (maximum time to wait when there is no connection in the pool)
    private int maxWait;

    //Connection Pool Name
    private String name;

    //DB Password
    private String password;

    //DB URL
    private String URL;

    //DB UserID
    private String user;

    //Constructor
    public DBConnectionPool(String name,
                            String URL,
                            String user,
                            String password,
                            int maxConn,
                            int initConn,
                            int waitTime) {

        this.name = name;
        this.URL = URL;
        this.user = user;
        this.password = password;
        this.maxConn = maxConn;
        this.maxWait = waitTime;

        for (int i = 0; i < initConn; i++) {
            freeConnections.addElement(newConnection());
        }
    }

    //Returning Connection
    //@param con : Connection to return
    public synchronized void freeConnection(Connection con) {
        freeConnections.addElement(con);
        checkedOut--;
        //Notify thread waiting to get Connection
        notifyAll();
    }

    //Get Connection
    public synchronized Connection getConnection() {
        Connection con = null;
        //If Connection is in Free List, get the first of List
        if (freeConnections.size() > 0) {
            con = (Connection) freeConnections.firstElement();
            freeConnections.removeElementAt(0);

            try {
                //If the connection is closed by the DBMS, request again
                if (con.isClosed()) {
                    Log.err("Removed bad connection from " + name);
                    con = getConnection();
                }
            } //If strange connection occurs, request again
            catch (SQLException e) {
                Log.err(e, "Removed bad connection from " + name);
                con = getConnection();
            }
        } //If Connection is not in Free List, create new
        else if (maxConn == 0 || checkedOut < maxConn) {
            con = newConnection();
        }

        if (con != null) {
            checkedOut++;
        }

        return con;
    }

    //Get Connection
    //@param timeout : Maximum Wait Time to Obtain a Connection
    public synchronized Connection getConnection(long timeout) {
        long startTime = new Date().getTime();
        Connection con;
        while ((con = getConnection()) == null) {
            try {
                wait(timeout * maxWait);
            } catch (InterruptedException e) {}
            if ((new Date().getTime() - startTime) >= timeout) {
                //Wait timeout
                return null;
            }
        }

        return con;
    }

    //Get Connection
    private Connection newConnection() {
        Connection con = null;
        try {
            if (user == null) {
                con = DriverManager.getConnection(URL);
            } else {
                con = DriverManager.getConnection(URL, user, password);
            }
            Log.out("Created a new connection in pool " + name);
        } catch (SQLException e) {
            StringBuffer sb = new StringBuffer();
            sb.append("Can't create a new connection for ");
            sb.append(URL);
            sb.append(" user: ");
            sb.append(user);
            sb.append(" passwd: ");
            sb.append(password);
            Log.err(e, sb.toString());
            return null;
        }

        return con;
    }

}
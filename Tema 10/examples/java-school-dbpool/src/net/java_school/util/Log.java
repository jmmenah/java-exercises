/*
 * Connection Pool
 * http://www.java-school.net/jdbc/Connection-Pool
 */
package net.java_school.util;

import java.io.*;
import java.util.Date;

public class Log {
    public String logFile = "log/connection-pool.log";
    FileWriter fw = null;
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public Log() {
        try {
            fw = new FileWriter(logFile, true);
        } catch (IOException e){}
    }

    public void close() {
        try {
            fw.close();
        } catch (IOException e){}
    }

    public void close(FileWriter fw) {
        try {
            fw.close();
        } catch (IOException e){}
    }

    public void debug(String msg) {
        try {
            fw.write(new java.util.Date()+ " : ");
            fw.write(msg + LINE_SEPARATOR);
            fw.flush();
        } catch (IOException e) {
            System.err.println("IOException.......!!");
        }
    }

    public static void out(String msg) {
        System.out.println(new Date() + ": " + msg);
    }

    public static void err(String msg) {
        System.out.println(new Date() + ": " + msg);
    }

    public static void err(Throwable e, String msg) {
        System.err.println(new Date() + ": " + msg);
        e.printStackTrace(System.out);
    }

}
/*
 * Gson tutorial: http://zetcode.com/java/gson/
 */
package com.zetcode.e08;

public class TimeData {

    private String time;
    private Long milliseconds_since_epoch;
    private String date;

    @Override
    public String toString() {
        return "TimeData{" + "time=" + time + ", milliseconds_since_epoch="
                + milliseconds_since_epoch + ", date=" + date + '}';
    }
}


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.TimeZoneApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class GetTimeZone {

    public static String getString(String city, String country) {
        String address;
        String lat;
        String lng;
        int hour;
        int minute;
        String tZname=null;
        address=city+","+country;
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyCq73j3yxPyOYvCqyYVVRJxgoT6NZsf-Yo")
                .build();
        GeocodingResult[] results = new GeocodingResult[0];
        try {
            results = GeocodingApi.geocode(context,
                    address).language("es").await();
        } catch (ApiException | InterruptedException | IOException e) {
            System.out.println(e.getMessage());
            context.shutdown();
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        lat = gson.toJson(results[0].geometry.location.lat);
        lng = gson.toJson(results[0].geometry.location.lng);
        LatLng latLng = new LatLng(Double.parseDouble(lat),Double.parseDouble(lng));
        TimeZone time = null;
        try {
            time = TimeZoneApi.getTimeZone(context,latLng).await();
            tZname = time.getID();
        } catch (ApiException | InterruptedException | IOException e) {
            System.out.println(e.getMessage());
            context.shutdown();
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeZone(time);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        context.shutdown();
        return String.format("The time zone of \n %s is %s \n and time is %d:%02d",city,tZname,hour,minute);
    }
}

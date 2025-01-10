package com.nust.ai;

import io.ipinfo.api.IPinfo;
import io.ipinfo.api.errors.RateLimitedException;
import io.ipinfo.api.model.IPResponse;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;

import static com.nust.apputils.AppUtils.getUrlContent;

public class OWMForecaster {

    private final String OWMId;
    private final IPResponse response;

    @SuppressWarnings("deprecation")
    public OWMForecaster(String IPInfoId, String OWMId) {
        this.OWMId = OWMId;
        // TODO: Replace with a more reliable method of retrieving the IP address.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL("https://checkip.amazonaws.com/").openStream()))) {
            response = new IPinfo.Builder().setToken(IPInfoId).build().lookupIP(br.readLine());
        } catch (IOException | RateLimitedException e) {
            throw new RuntimeException(e);
        }
    }

   
public String forecast() {
    String forecast = "Hello there! It seems we've encountered a little hiccup in our weather system, and " +
            "unfortunately, we don't have your specific location information at the moment.";
    JSONObject json = new JSONObject(
            getUrlContent(
                    String.format(
                            "https://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&appid=%s&units=%s&lang=%s",
                            response.getLatitude(),
                            response.getLongitude(),
                            OWMId,
                            "metric",
                            "en"
                    )
            )
    );
    if (json.getString("cod").equals("200")) {
        JSONObject infoObj = json.getJSONArray("list").getJSONObject(1);
        JSONObject mainObj = infoObj.getJSONObject("main");
        JSONObject cityObj = json.getJSONObject("city");
        forecast = String.format(
                "In the beautiful town of %s located in %s"+"\nCurrent temperature: %.1f degree Celcius" + "\nMax temperature: %.1f degrees Celcius \n" +"Min temperature: %.1f degrees Celcius "+"\nHumidity: %d%%"+"\nWind speed: %.1f meters per second"+"\nSky: %s",
                cityObj.getString("name"),
                new Locale.Builder().setRegion(cityObj.getString("country")).build().getDisplayCountry(Locale.ENGLISH),
                mainObj.getDouble("temp"),
                mainObj.getDouble("temp_max"),
                mainObj.getDouble("temp_min"),
                mainObj.getInt("humidity"),
                infoObj.getJSONObject("wind").getDouble("speed"),
                infoObj.getJSONArray("weather").getJSONObject(0).getString("description")
        );
    }
    return forecast;
}
}
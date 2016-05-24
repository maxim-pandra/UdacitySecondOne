package ru.alfabank.udacity.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Maxim Turaev on 24.05.2016.
 */
public class WeatherDataParser {
    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {
        // TODO: add parsing code here
        JSONObject jsonObject = new JSONObject(weatherJsonStr);
        JSONArray jsonArray = jsonObject.getJSONArray("list");
        JSONObject exactDay = jsonArray.getJSONObject(dayIndex);
        return Double.parseDouble(exactDay.getString("max"));
    }
}
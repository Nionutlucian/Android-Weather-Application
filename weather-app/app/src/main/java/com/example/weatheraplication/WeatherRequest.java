package com.example.weatheraplication;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpResponse;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.*;

public class WeatherRequest extends AsyncTask {

    private String curentTemp;
    private String curentDescription;
    private String cityName;
    String urlString;
    private JSONObject responseJson;
    private String firstIntervalHour;
    private String secondIntervalHour;
    private String thirdIntervalHour;
    private String firstIntervalTemp;
    private String secondIntervalTemp;
    private String thirdIntervalTemp;
    private String currentIcon;
    private String firstIntervalIcon;
    private String secondtIntervalIcon;
    private String thirdIntervalIcon;
    private String firstIntervalDescription;
    private String secondIntervalDescription;
    private String thirdIntervalDescription;
    private String firstDayDate;
    private String secondDayDate;
    private String thirdDayDate;
    private String day1Icon;
    private String day2Icon;
    private String day3Icon;
    private String day1Description;
    private String day2Description;
    private String day3Description;
    private String tempMaxDay1;
    private String tempMaxDay2;
    private String tempMaxDay3;
    private String tempMinDay1;
    private String tempMinDay2;
    private String tempMinDay3;



    WeatherRequest(String cityName){
       this.cityName = cityName;
       this.urlString = new String("http://api.openweathermap.org/data/2.5/" +
               "forecast?q=" + this.cityName + "&units=metric" +
               "&appid=66a3d14f5e38710797973f4b8d476458");
    }

    public String getTempMinDay1() {
        return tempMinDay1;
    }

    public void setTempMinDay1(String tempMinDay1) {
        this.tempMinDay1 = tempMinDay1;
    }

    public String getTempMinDay2() {
        return tempMinDay2;
    }

    public void setTempMinDay2(String tempMinDay2) {
        this.tempMinDay2 = tempMinDay2;
    }

    public String getTempMinDay3() {
        return tempMinDay3;
    }

    public void setTempMinDay3(String tempMinDay3) {
        this.tempMinDay3 = tempMinDay3;
    }

    public String getTempMaxDay1() {
        return tempMaxDay1;
    }

    public void setTempMaxDay1(String tempMaxDay1) {
        this.tempMaxDay1 = tempMaxDay1;
    }

    public String getTempMaxDay2() {
        return tempMaxDay2;
    }

    public void setTempMaxDay2(String tempMaxDay2) {
        this.tempMaxDay2 = tempMaxDay2;
    }

    public String getTempMaxDay3() {
        return tempMaxDay3;
    }

    public void setTempMaxDay3(String tempMaxDay3) {
        this.tempMaxDay3 = tempMaxDay3;
    }

    public String getDay1Description() {
        return day1Description;
    }

    public void setDay1Description(String day1Description) {
        this.day1Description = day1Description;
    }

    public String getDay2Description() {
        return day2Description;
    }

    public void setDay2Description(String day2Description) {
        this.day2Description = day2Description;
    }

    public String getDay3Description() {
        return day3Description;
    }

    public void setDay3Description(String day3Description) {
        this.day3Description = day3Description;
    }

    public String getDay1Icon() {
        return day1Icon;
    }

    public void setDay1Icon(String day1Icon) {
        this.day1Icon = day1Icon;
    }

    public String getDay2Icon() {
        return day2Icon;
    }

    public void setDay2Icon(String day2Icon) {
        this.day2Icon = day2Icon;
    }

    public String getDay3Icon() {
        return day3Icon;
    }

    public void setDay3Icon(String day3Icon) {
        this.day3Icon = day3Icon;
    }

    public String getFirstDayDate() {
        return firstDayDate;
    }

    public void setFirstDayDate(String firstDayDate) {
        this.firstDayDate = firstDayDate;
    }

    public String getSecondDayDate() {
        return secondDayDate;
    }

    public void setSecondDayDate(String secondDayDate) {
        this.secondDayDate = secondDayDate;
    }

    public String getThirdDayDate() {
        return thirdDayDate;
    }

    public void setThirdDayDate(String thirdDayDate) {
        this.thirdDayDate = thirdDayDate;
    }

    public String getFirstIntervalDescription() {
        return firstIntervalDescription;
    }

    public void setFirstIntervalDescription(String firstIntervalDescription) {
        this.firstIntervalDescription = firstIntervalDescription;
    }

    public String getSecondIntervalDescription() {
        return secondIntervalDescription;
    }

    public void setSecondIntervalDescription(String secondIntervalDescription) {
        this.secondIntervalDescription = secondIntervalDescription;
    }

    public String getThirdIntervalDescription() {
        return thirdIntervalDescription;
    }

    public void setThirdIntervalDescription(String thirdIntervalDescription) {
        this.thirdIntervalDescription = thirdIntervalDescription;
    }

    public String getFirstIntervalIcon() {
        return firstIntervalIcon;
    }

    public void setFirstIntervalIcon(String firstIntervalIcon) {
        this.firstIntervalIcon = firstIntervalIcon;
    }

    public String getSecondtIntervalIcon() {
        return secondtIntervalIcon;
    }

    public void setSecondtIntervalIcon(String secondtIntervalIcon) {
        this.secondtIntervalIcon = secondtIntervalIcon;
    }

    public String getThirdIntervalIcon() {
        return thirdIntervalIcon;
    }

    public void setThirdIntervalIcon(String thirdIntervalIcon) {
        this.thirdIntervalIcon = thirdIntervalIcon;
    }

    public String getCurrentIcon() {
        return currentIcon;
    }

    public void setCurrentIcon(String currentIcon) {
        this.currentIcon = currentIcon;
    }

    public String getFirstIntervalTemp() {
        return firstIntervalTemp;
    }

    public void setFirstIntervalTemp(String firstIntervalTemp) {
        this.firstIntervalTemp = firstIntervalTemp;
    }

    public String getSecondIntervalTemp() {
        return secondIntervalTemp;
    }

    public void setSecondIntervalTemp(String secondIntervalTemp) {
        this.secondIntervalTemp = secondIntervalTemp;
    }

    public String getThirdIntervalTemp() {
        return thirdIntervalTemp;
    }

    public void setThirdIntervalTemp(String thirdIntervalTemp) {
        this.thirdIntervalTemp = thirdIntervalTemp;
    }

    public String getFirstIntervalHour() {
        return firstIntervalHour;
    }

    public void setFirstIntervalHour(String firstIntervalHour) {
        this.firstIntervalHour = firstIntervalHour;
    }

    public String getSecondIntervalHour() {
        return secondIntervalHour;
    }

    public void setSecondIntervalHour(String secondIntervalHour) {
        this.secondIntervalHour = secondIntervalHour;
    }

    public String getThirdIntervalHour() {
        return thirdIntervalHour;
    }

    public void setThirdIntervalHour(String thirdIntervalHour) {
        this.thirdIntervalHour = thirdIntervalHour;
    }

    public String getCurentTemp() {
        return curentTemp;
    }

    public void setCurentTemp(String curentTemp) {
        this.curentTemp = curentTemp;
    }

    public String getCurentDescription() {
        return curentDescription;
    }

    public void setCurentDescription(String curentDescription) {
        this.curentDescription = curentDescription;
    }


    public JSONObject getJSONObjectFromURL() throws IOException, JSONException {
        HttpURLConnection urlConnection = null;
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */ );
        urlConnection.setConnectTimeout(15000 /* milliseconds */ );
        urlConnection.setDoOutput(true);
        urlConnection.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();

        String jsonString = sb.toString();
        System.out.println("JSON: " + jsonString);

        return new JSONObject(jsonString);
    }

    public int getIndexToStart(){

        Calendar cal = Calendar. getInstance();
        Date date=cal. getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH");
        int i = Integer.valueOf(String.valueOf(dateFormat.format(date)));
        if(i>=0 && i<3){
            return 8;
        }
        if(i>=3 && i<6){
            return 7;
        }
        if(i>=6 && i<9){
            return 6;
        }
        if(i>=9 && i<12){
            return 5;
        }
        if(i>=12 && i<15){
            return 4;
        }
        if(i>=15 && i<18){
            return 3;
        }
        if(i>=18 && i<21){
            return 2;
        }
        if(i>=21){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    protected JSONObject doInBackground(Object[] objects) {
        JSONArray temperaturesJsonArray;
        JSONObject jsonArrayIconDescription;
        String temperature;
        String date;
        String icon;
        String description;

        try{
            DecimalFormat value = new DecimalFormat("#");
            responseJson = getJSONObjectFromURL();

            temperaturesJsonArray = (JSONArray) responseJson.get("list");
            for(int i = getIndexToStart(),j = 0;i < 24+getIndexToStart();i++,j++){
                //System.out.println("Object: " + temperaturesJsonArray.get(i));
                if(j==1){
                    date = (String)(temperaturesJsonArray.getJSONObject(i).get("dt_txt"));
                    setFirstDayDate(date.substring(0,date.indexOf(" ")));

                    JSONObject curentTempJson = (JSONObject) temperaturesJsonArray.get(i);
                    JSONObject curentTempJson1 = (JSONObject) curentTempJson.get("main");
                    Double curentTemp = (Double) curentTempJson1.get("temp");
                    setTempMinDay1(value.format(curentTemp));//set curent temp
                }
                if(j==9){
                    date = (String)(temperaturesJsonArray.getJSONObject(i).get("dt_txt"));
                    setSecondDayDate(date.substring(0,date.indexOf(" ")));

                    JSONObject curentTempJson = (JSONObject) temperaturesJsonArray.get(i);
                    JSONObject curentTempJson1 = (JSONObject) curentTempJson.get("main");
                    Double curentTemp = (Double) curentTempJson1.get("temp");
                    setTempMinDay2(value.format(curentTemp));//set curent temp
                }
                if(j==17){
                    date = (String)(temperaturesJsonArray.getJSONObject(i).get("dt_txt"));
                    setThirdDayDate(date.substring(0,date.indexOf(" ")));

                    JSONObject curentTempJson = (JSONObject) temperaturesJsonArray.get(i);
                    JSONObject curentTempJson1 = (JSONObject) curentTempJson.get("main");
                    Double curentTemp = (Double) curentTempJson1.get("temp");
                    setTempMinDay3(value.format(curentTemp));//set curent temp
                }
                if(j==5){
                    JSONObject curentTempJson = (JSONObject) temperaturesJsonArray.get(i);
                    JSONArray weather = (JSONArray) curentTempJson.get("weather");
                    JSONObject weather1 = (JSONObject) weather.get(0);
                    String curentDescJson1 = (String) weather1.get("main");
                    String curentIcon = (String) weather1.get("icon");
                    setDay1Icon(curentIcon);
                    setDay1Description(curentDescJson1);

                    JSONObject curentTempJson1 = (JSONObject) curentTempJson.get("main");
                    Double curentTemp = (Double) curentTempJson1.get("temp");
                    setTempMaxDay1(value.format(curentTemp));//set curent temp

                }
                if(j==13){
                    JSONObject curentTempJson = (JSONObject) temperaturesJsonArray.get(i);
                    JSONArray weather = (JSONArray) curentTempJson.get("weather");
                    JSONObject weather1 = (JSONObject) weather.get(0);
                    String curentDescJson1 = (String) weather1.get("main");
                    String curentIcon = (String) weather1.get("icon");
                    setDay2Icon(curentIcon);
                    setDay2Description(curentDescJson1);

                    JSONObject curentTempJson1 = (JSONObject) curentTempJson.get("main");
                    Double curentTemp = (Double) curentTempJson1.get("temp");
                    setTempMaxDay2(value.format(curentTemp));//set curent temp
                }
                if(j==21){
                    JSONObject curentTempJson = (JSONObject) temperaturesJsonArray.get(i);
                    JSONArray weather = (JSONArray) curentTempJson.get("weather");
                    JSONObject weather1 = (JSONObject) weather.get(0);
                    String curentDescJson1 = (String) weather1.get("main");
                    String curentIcon = (String) weather1.get("icon");
                    setDay3Icon(curentIcon);
                    setDay3Description(curentDescJson1);

                    JSONObject curentTempJson1 = (JSONObject) curentTempJson.get("main");
                    Double curentTemp = (Double) curentTempJson1.get("temp");
                    setTempMaxDay3(value.format(curentTemp));//set curent temp
                }

            }
            //System.out.println("Hour: " + temperaturesDateIconDescription);


            //Curent Weather
            JSONArray list = (JSONArray) responseJson.get("list");
            JSONObject curentTempJson = (JSONObject) list.get(0);
            JSONObject curentTempJson1 = (JSONObject) curentTempJson.get("main");
            Double curentTemp = (Double) curentTempJson1.get("temp");
            setCurentTemp(value.format(curentTemp));//set curent temp

            JSONArray weather = (JSONArray) curentTempJson.get("weather");
            JSONObject weather1 = (JSONObject) weather.get(0);
            String curentDescJson1 = (String) weather1.get("main");
            String curentIcon = (String) weather1.get("icon");
            setCurrentIcon(curentIcon);
            setCurentDescription(curentDescJson1);

            //First Interval
            JSONObject firstInterval = (JSONObject) list.get(1);
            String date_hour = (String) firstInterval.get("dt_txt");
            String hour = date_hour.substring(date_hour.indexOf(" "),date_hour.length()-3);
            setFirstIntervalHour(hour);
            JSONObject firstIntervalTempJson1 = (JSONObject) firstInterval.get("main");
            Double firstIntervalTemp = (Double) firstIntervalTempJson1.get("temp");
            setFirstIntervalTemp(value.format(firstIntervalTemp));

            JSONArray firstIntervalWeather = (JSONArray) firstInterval.get("weather");
            JSONObject firstIntervalWeather1 = (JSONObject) firstIntervalWeather.get(0);
            String firstIntervalIcon = (String) firstIntervalWeather1.get("icon");
            String firstIntervalDescription = (String) firstIntervalWeather1.get("main");
            setFirstIntervalIcon(firstIntervalIcon);
            setFirstIntervalDescription(firstIntervalDescription);

            //Second Interval
            JSONObject secondInterval = (JSONObject) list.get(2);
            date_hour = (String) secondInterval.get("dt_txt");
            hour = date_hour.substring(date_hour.indexOf(" "),date_hour.length()-3);
            setSecondIntervalHour(hour);
            JSONObject secondIntervalTempJson1 = (JSONObject) secondInterval.get("main");
            Double secondIntervalTemp = (Double) secondIntervalTempJson1.get("temp");
            setSecondIntervalTemp(value.format(secondIntervalTemp));

            JSONArray secondIntervalWeather = (JSONArray) secondInterval.get("weather");
            JSONObject secondIntervalWeather1 = (JSONObject) secondIntervalWeather.get(0);
            String secondIntervalIcon = (String) secondIntervalWeather1.get("icon");
            String secondIntervalDescription = (String) secondIntervalWeather1.get("main");
            setSecondtIntervalIcon(secondIntervalIcon);
            setSecondIntervalDescription(secondIntervalDescription);



            //Third Interval
            JSONObject thirdInterval = (JSONObject) list.get(3);
            date_hour = (String) thirdInterval.get("dt_txt");
            hour = date_hour.substring(date_hour.indexOf(" "),date_hour.length()-3);
            setThirdIntervalHour(hour);
            JSONObject thirdIntervalTempJson1 = (JSONObject) thirdInterval.get("main");
            Double thirdIntervalTemp = (Double) thirdIntervalTempJson1.get("temp");
            setThirdIntervalTemp(value.format(thirdIntervalTemp));

            JSONArray thirdIntervalWeather = (JSONArray) thirdInterval.get("weather");
            JSONObject thirdIntervalWeather1 = (JSONObject) thirdIntervalWeather.get(0);
            String thirdIntervalIcon = (String) thirdIntervalWeather1.get("icon");
            String thirdIntervalDescription = (String) thirdIntervalWeather1.get("main");
            setThirdIntervalIcon(thirdIntervalIcon);
            setThirdIntervalDescription(thirdIntervalDescription);


            System.out.println("list: " + getCurentTemp() + " " + getCurentDescription() + " "
                    + getFirstIntervalHour()
                    + " " + getSecondIntervalHour()+
                    " " + getThirdIntervalHour()+
                    " " + getCurrentIcon()
                    + " " + getFirstIntervalIcon() +
                    " " + getSecondtIntervalIcon() +
                    " " + getThirdIntervalIcon());
            return responseJson;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String getUrlString() {
        return urlString;
    }
}

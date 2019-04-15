package model;

import java.util.ArrayList;

public class Information {

    private String cityName;
    private String countryName;
    private ArrayList<String> days;
    private ArrayList<String> outdoorTemperatureByDay;
    private String indoorTemperature;
    private ArrayList<String> temperatureHourly;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ArrayList<String> getDays() {
        return days;
    }

    public void setDays(ArrayList<String> days) {
        this.days = days;
    }

    public ArrayList<String> getOutdoorTemperatureByDay() {
        return outdoorTemperatureByDay;
    }

    public void setOutdoorTemperatureByDay(ArrayList<String> outdoorTemperatureByDay) {
        this.outdoorTemperatureByDay = outdoorTemperatureByDay;
    }

    public String getIndoorTemperature() {
        return indoorTemperature;
    }

    public void setIndoorTemperature(String indoorTemperature) {
        this.indoorTemperature = indoorTemperature;
    }

    public ArrayList<String> getTemperatureHourly() {
        return temperatureHourly;
    }

    public void setTemperatureHourly(ArrayList<String> temperatureHourly) {
        this.temperatureHourly = temperatureHourly;
    }

    @Override
    public String toString() {
        return "Information{" +
                "cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", days=" + days +
                ", outdoorTemperatureByDay=" + outdoorTemperatureByDay +
                ", indoorTemperature='" + indoorTemperature + '\'' +
                ", temperatureHourly=" + temperatureHourly +
                '}';
    }
}

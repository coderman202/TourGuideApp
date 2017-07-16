package com.example.android.tourguideapp.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A custom class to represent the weather.
 */
public class Weather {

    // The day of the week in abbreviated form. For example: 'Mon', 'Tue', 'Wed', etc
    private String day;
    private Date date;
    // The temperature in celsius
    private double temperature;
    // A one word description of the weather, such as 'Sunny', 'Rainy', 'Cloudy', etc...
    private String condition;
    // The current locale which is passed to ensure the correct language is displayed.
    // Set the default to English.
    private Locale locale = Locale.ENGLISH;

    /**
     * Instantiates a new Weather object. No locale is passed so the default is used
     *
     * @param date        the date
     * @param temperature the temperature
     * @param condition   the condition
     */
    public Weather(Date date, double temperature, String condition) {
        this.date = date;
        this.temperature = temperature;
        this.condition = condition;

        // Getting the current day by using the current date and passing the time into a
        // new SimpleDateFormat class.
        this.day = new SimpleDateFormat("EE", this.locale).format(date.getTime());
    }

    /**
     * Instantiates a new Weather object.
     *
     * @param date        the date
     * @param temperature the temperature
     * @param condition   the condition
     * @param locale      the locale
     */
    public Weather(Date date, double temperature, String condition, Locale locale) {
        this.date = date;
        this.temperature = temperature;
        this.condition = condition;
        this.locale = locale;
        this.day = new SimpleDateFormat("EE", this.locale).format(date.getTime());
    }

    /**
     * Gets day.
     *
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * Sets day.
     *
     * @param date A date object which will be converted into a day via the aforementioned process.
     */
    public void setDay(Date date) {
        this.day = new SimpleDateFormat("EE", this.locale).format(date.getTime());
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets temperature.
     *
     * @return the temperature
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Get temperature in celsius in String format.
     *
     * @return the string
     */
    public String getTemperatureCelsius() {
        return this.temperature + "°C";
    }

    /**
     * Get temperature in fahrenheit by converting the celsius temperature.
     *
     * @return the string
     */
    public String getTemperatureFahrenheit() {
        return (((9 / 5) * this.temperature) + 32) + "°F";
    }

    /**
     * Sets temperature.
     *
     * @param temperature the temperature
     */
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Gets condition.
     *
     * @return the condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Sets condition.
     *
     * @param condition the condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}

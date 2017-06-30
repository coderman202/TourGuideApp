package com.example.android.tourguideapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Address;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.example.android.tourguideapp.TourGuideUtilities.stringToDate;

/**
 * My custom class for handling all db queries
 */

public class TourGuideDBHelper extends SQLiteOpenHelper {

    //region DB, Table and column name declarations
    //----------------------------------------------------------------------------------------------
    // DB name, version and log_tag
    private static final String LOG_TAG = "TourGuideDBHelper";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TourGuideDB";

    // Table names in DB
    private static final String TABLE_CITY = "City";
    private static final String TABLE_HOTEL = "Hotel";
    private static final String TABLE_RESTAURANT_BAR = "RestaurantBar";
    private static final String TABLE_AIRPORT = "Airport";
    private static final String TABLE_EVENT = "Event";
    private static final String TABLE_ATTRACTION = "Attraction";
    private static final String TABLE_TOUR = "Tour";
    private static final String TABLE_CUISINE = "Cuisine";
    private static final String TABLE_TRANSPORT = "Transport";

    // Column names for City table
    private static final String CITY_ID = "CityID";
    private static final String CITY_NAME = "Name";
    private static final String CITY_COUNTRY = "Country";
    private static final String CITY_POP = "Population";
    private static final String CITY_DESCRIPTION = "Description";
    private static final String CITY_HISTORY = "History";
    private static final String CITY_LANGUAGE = "Language";
    private static final String CITY_IMAGE = "ImageID";

    // Column names for the Hotel table
    private static final String HOTEL_ID = "HotelID";
    private static final String HOTEL_NAME = "Name";
    private static final String HOTEL_CITY = "CityID";
    private static final String HOTEL_DESCRIPTION = "Description";
    private static final String HOTEL_ADDRESS = "Address";
    private static final String HOTEL_CLASS = "Class";
    private static final String HOTEL_RATING = "Rating";
    private static final String HOTEL_PRICE = "Price";
    private static final String HOTEL_IMAGE = "ImageID";
    private static final String HOTEL_WEBSITE = "WebsiteURL";
    private static final String HOTEL_NEIGHBOURHOOD = "Neighbourhood";
    private static final String HOTEL_PHONE = "Phone";

    // Column names for the RestaurantBar table
    private static final String RESTAURANT_BAR_ID = "RestaurantBarID";
    private static final String RESTAURANT_BAR_NAME = "Name";
    private static final String RESTAURANT_BAR_CITY = "CityID";
    private static final String RESTAURANT_BAR_OPENING_HOURS = "OpeningHours";
    private static final String RESTAURANT_BAR_DINING_HOURS = "DiningHours";
    private static final String RESTAURANT_BAR_DESCRIPTION = "Description";
    private static final String RESTAURANT_BAR_MICHELIN_STARS = "MichelinStars";
    private static final String RESTAURANT_BAR_ADDRESS = "Address";
    private static final String RESTAURANT_BAR_RATING = "Rating";
    private static final String RESTAURANT_BAR_PRICE = "Price";
    private static final String RESTAURANT_BAR_IMAGE = "ImageID";
    private static final String RESTAURANT_BAR_WEBSITE = "WebsiteURL";
    private static final String RESTAURANT_BAR_NEIGHBOURHOOD = "Neighbourhood";
    private static final String RESTAURANT_BAR_PHONE = "Phone";

    // Column names for the Airport table
    private static final String AIRPORT_ID = "AirportID";
    private static final String AIRPORT_NAME = "Name";
    private static final String AIRPORT_CITY = "CityID";
    private static final String AIRPORT_IATA = "IATACode";
    private static final String AIRPORT_ADDRESS = "Address";

    // Column names for the Event table
    private static final String EVENT_ID = "EventID";
    private static final String EVENT_NAME = "Name";
    private static final String EVENT_CITY = "CityID";
    private static final String EVENT_START_DATE = "StartDate";
    private static final String EVENT_END_DATE = "EndDate";
    private static final String EVENT_ADDRESS = "Address";
    private static final String EVENT_DESCRIPTION = "Description";
    private static final String EVENT_WEBSITE = "WebsiteURL";
    private static final String EVENT_THEME = "Theme";
    private static final String EVENT_IMAGE = "ImageID";
    private static final String EVENT_WHEELCHAIR_ACCESS = "WheelchairAccess";

    // Column names for the Attraction table
    private static final String ATTRACTION_ID = "AttractionID";
    private static final String ATTRACTION_NAME = "Name";
    private static final String ATTRACTION_CITY = "CityID";
    private static final String ATTRACTION_OPENING_HOURS = "OpeningHours";
    private static final String ATTRACTION_ADDRESS = "Address";
    private static final String ATTRACTION_DESCRIPTION = "Description";
    private static final String ATTRACTION_RATING = "Rating";
    private static final String ATTRACTION_PRICE = "Price";
    private static final String ATTRACTION_WEBSITE = "WebsiteURL";
    private static final String ATTRACTION_IMAGE = "ImageID";
    private static final String ATTRACTION_WHEELCHAIR_ACCESS = "WheelchairAccess";
    private static final String ATTRACTION_NEIGHBOURHOOD = "Neighbourhood";
    private static final String ATTRACTION_PHONE = "Phone";

    // Column names for the Tour table
    private static final String TOUR_ID = "TourID";
    private static final String TOUR_NAME = "Name";
    private static final String TOUR_CITY = "CityID";
    private static final String TOUR_OPERATING_TIMES = "OperatingTimes";
    private static final String TOUR_START_ADDRESS = "StartAddress";
    private static final String TOUR_END_ADDRESS = "EndAddress";
    private static final String TOUR_DESCRIPTION = "Description";
    private static final String TOUR_WEBSITE = "WebsiteURL";
    private static final String TOUR_COMPANY = "Company";
    private static final String TOUR_IMAGE = "ImageID";
    private static final String TOUR_WHEELCHAIR_ACCESS = "WheelchairAccess";
    private static final String TOUR_PHONE = "Phone";
    private static final String TOUR_PRICE = "Price";
    private static final String TOUR_RATING = "Rating";

    // Column names for the Cuisine table
    private static final String CUISINE_ID = "CusineID";
    private static final String CUISINE_NAME = "Name";
    private static final String CUISINE_RESTAURANT_BAR = "RestuarantBarID";

    // Column names for the Transport table
    private static final String TRANSPORT_ID = "TransportID";
    private static final String TRANSPORT_TYPE = "Type";
    private static final String TRANSPORT_CITY = "CityID";

    //----------------------------------------------------------------------------------------------
    //endregion

    //region Helper Strings for the create and drop table statements
    //----------------------------------------------------------------------------------------------
    private static final String PRIMARY_KEY_CONSTRAINTS = " INTEGER NOT NULL " +
            "PRIMARY KEY AUTOINCREMENT UNIQUE, ";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS ";
    private static final String ON_DELETE = "ON DELETE SET NULL);";
    private static final String FOREIGN_KEY_CITY_ID =
            "FOREIGN KEY (" + TOUR_CITY + ") REFERENCES " + TABLE_CITY +
                    " (" + CITY_ID + ")" + ON_DELETE;
    //----------------------------------------------------------------------------------------------
    //endregion

    //region All the create table statements
    //----------------------------------------------------------------------------------------------
    // The create table statement for City table
    private static final String CREATE_TABLE_CITY = CREATE_TABLE + TABLE_CITY +
            "(" + CITY_ID + PRIMARY_KEY_CONSTRAINTS + CITY_NAME + " TEXT NOT NULL, " +
            CITY_COUNTRY + " TEXT NOT NULL, " + CITY_POP + " INTEGER NOT NULL, " +
            CITY_DESCRIPTION + " TEXT NOT NULL, " + CITY_HISTORY + " TEXT NOT NULL, " +
            CITY_LANGUAGE + " TEXT NOT NULL, " + CITY_IMAGE + " INTEGER NOT NULL);";

    // The create table statement for Hotel table
    private static final String CREATE_TABLE_HOTEL = CREATE_TABLE + TABLE_HOTEL + "(" +
            HOTEL_ID + PRIMARY_KEY_CONSTRAINTS + HOTEL_NAME + " TEXT NOT NULL, " +
            HOTEL_CITY + " INTEGER NOT NULL, " + HOTEL_CLASS + " INTEGER NOT NULL, " +
            HOTEL_RATING + " INTEGER NOT NULL, " + HOTEL_PRICE + " INTEGER NOT NULL, " +
            HOTEL_DESCRIPTION + " TEXT NOT NULL, " + HOTEL_WEBSITE + " TEXT NOT NULL, " +
            HOTEL_NEIGHBOURHOOD + " TEXT, " + HOTEL_PHONE + " TEXT NOT NULL, " +
            HOTEL_IMAGE + " INTEGER NOT NULL, " + HOTEL_ADDRESS + " TEXT, " + FOREIGN_KEY_CITY_ID;

    // The create table statement for RestaurantBar table
    private static final String CREATE_TABLE_RESTAURANT_BAR = CREATE_TABLE + TABLE_RESTAURANT_BAR + "(" +
            RESTAURANT_BAR_ID + PRIMARY_KEY_CONSTRAINTS + RESTAURANT_BAR_NAME + " TEXT NOT NULL, " +
            RESTAURANT_BAR_CITY + " INTEGER NOT NULL, " + RESTAURANT_BAR_MICHELIN_STARS + " INTEGER NOT NULL, " +
            RESTAURANT_BAR_RATING + " INTEGER NOT NULL, " + RESTAURANT_BAR_PRICE + " INTEGER NOT NULL, " +
            RESTAURANT_BAR_DESCRIPTION + " TEXT NOT NULL, " + RESTAURANT_BAR_WEBSITE + " TEXT, " +
            RESTAURANT_BAR_NEIGHBOURHOOD + " TEXT, " + RESTAURANT_BAR_PHONE + " TEXT NOT NULL, " +
            RESTAURANT_BAR_IMAGE + " INTEGER NOT NULL, " + RESTAURANT_BAR_ADDRESS + " TEXT, " +
            RESTAURANT_BAR_OPENING_HOURS + " TEXT NOT NULL, " +
            RESTAURANT_BAR_DINING_HOURS + " TEXT NOT NULL, " + FOREIGN_KEY_CITY_ID;

    // The create table statement for Airport table
    private static final String CREATE_TABLE_AIRPORT = CREATE_TABLE + TABLE_AIRPORT + "(" +
            AIRPORT_ID + PRIMARY_KEY_CONSTRAINTS + AIRPORT_NAME + " TEXT NOT NULL, " +
            AIRPORT_CITY + " INTEGER NOT NULL, " + AIRPORT_IATA + " TEXT NOT NULL, " +
            AIRPORT_ADDRESS + " TEXT, " + FOREIGN_KEY_CITY_ID;

    // The create table statement for Event table
    private static final String CREATE_TABLE_EVENT = CREATE_TABLE + TABLE_EVENT + "(" +
            EVENT_ID + PRIMARY_KEY_CONSTRAINTS + EVENT_NAME + " TEXT NOT NULL, " +
            EVENT_CITY + " INTEGER NOT NULL, " + EVENT_THEME + " TEXT NOT NULL, " +
            EVENT_DESCRIPTION + " TEXT NOT NULL, " + EVENT_WEBSITE + " TEXT, " +
            EVENT_IMAGE + " INTEGER NOT NULL, " + EVENT_ADDRESS + " TEXT, " +
            EVENT_START_DATE + " TEXT NOT NULL, " + EVENT_END_DATE + " TEXT NOT NULL " +
            EVENT_WHEELCHAIR_ACCESS + " INTEGER NOT NULL, " + FOREIGN_KEY_CITY_ID;

    // The create table statement for Attraction table
    private static final String CREATE_TABLE_ATTRACTION = CREATE_TABLE + TABLE_ATTRACTION + "(" +
            ATTRACTION_ID + PRIMARY_KEY_CONSTRAINTS + ATTRACTION_NAME + " TEXT NOT NULL, " +
            ATTRACTION_CITY + " INTEGER NOT NULL, " + ATTRACTION_RATING + " INTEGER NOT NULL, " +
            ATTRACTION_PRICE + " INTEGER NOT NULL, " + ATTRACTION_DESCRIPTION + " TEXT NOT NULL, " +
            ATTRACTION_WEBSITE + " TEXT, " + ATTRACTION_IMAGE + " INTEGER NOT NULL, " +
            ATTRACTION_NEIGHBOURHOOD + " TEXT, " + ATTRACTION_PHONE + " TEXT NOT NULL, " +
            ATTRACTION_ADDRESS + " TEXT, " + ATTRACTION_OPENING_HOURS + " TEXT NOT NULL, " +
            ATTRACTION_WHEELCHAIR_ACCESS + " INTEGER NOT NULL, " + FOREIGN_KEY_CITY_ID;

    // The create table statement for Tour table
    private static final String CREATE_TABLE_TOUR = CREATE_TABLE + TABLE_TOUR + "(" +
            TOUR_ID + PRIMARY_KEY_CONSTRAINTS + TOUR_NAME + " TEXT NOT NULL, " +
            TOUR_CITY + " INTEGER NOT NULL, " + TOUR_COMPANY + " TEXT NOT NULL, " +
            TOUR_DESCRIPTION + " TEXT NOT NULL, " + TOUR_WEBSITE + " TEXT, " +
            TOUR_IMAGE + " INTEGER NOT NULL, " + TOUR_START_ADDRESS + " TEXT, " +
            TOUR_PRICE + " INTEGER NOT NULL, " + TOUR_RATING + " INTEGER NOT NULL, " +
            TOUR_END_ADDRESS + " TEXT, " + TOUR_OPERATING_TIMES + " TEXT NOT NULL, " +
            TOUR_WHEELCHAIR_ACCESS + " INTEGER NOT NULL, " + TOUR_PHONE + " TEXT, " +
            FOREIGN_KEY_CITY_ID;

    // The create table statement for Cuisine table
    private static final String CREATE_TABLE_CUISINE = CREATE_TABLE + TABLE_CUISINE + "(" +
            CUISINE_ID + PRIMARY_KEY_CONSTRAINTS + CUISINE_NAME + " TEXT NOT NULL, " +
            CUISINE_RESTAURANT_BAR + " INTEGER NOT NULL, FOREIGN KEY (" + CUISINE_RESTAURANT_BAR +
            ") REFERENCES " + TABLE_RESTAURANT_BAR + " (" + RESTAURANT_BAR_ID + ")" + ON_DELETE;

    // The create table statement for Transport table
    private static final String CREATE_TABLE_TRANSPORT = CREATE_TABLE + TABLE_TRANSPORT + "(" +
            TRANSPORT_ID + PRIMARY_KEY_CONSTRAINTS + TRANSPORT_TYPE + " TEXT NOT NULL, " +
            TRANSPORT_CITY + " INTEGER NOT NULL, " + FOREIGN_KEY_CITY_ID;
    //----------------------------------------------------------------------------------------------
    //endregion

    //region The default constructor and the basic overridden onCreate and onUpgrade methods.
    //----------------------------------------------------------------------------------------------
    /**
     * Default constructor
     * @param context
     */
    public TourGuideDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CITY);
        db.execSQL(CREATE_TABLE_HOTEL);
        db.execSQL(CREATE_TABLE_RESTAURANT_BAR);
        db.execSQL(CREATE_TABLE_AIRPORT);
        db.execSQL(CREATE_TABLE_EVENT);
        db.execSQL(CREATE_TABLE_ATTRACTION);
        db.execSQL(CREATE_TABLE_TOUR);
        db.execSQL(CREATE_TABLE_CUISINE);
        db.execSQL(CREATE_TABLE_TRANSPORT);
    }

    // On upgrade drop older tables and create new ones calling the onCreate() method.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE + TABLE_CITY);
        db.execSQL(DROP_TABLE + TABLE_HOTEL);
        db.execSQL(DROP_TABLE + TABLE_RESTAURANT_BAR);
        db.execSQL(DROP_TABLE + TABLE_AIRPORT);
        db.execSQL(DROP_TABLE + TABLE_EVENT);
        db.execSQL(DROP_TABLE + TABLE_ATTRACTION);
        db.execSQL(DROP_TABLE + TABLE_TOUR);
        db.execSQL(DROP_TABLE + TABLE_CUISINE);
        db.execSQL(DROP_TABLE + TABLE_TRANSPORT);
        onCreate(db);
    }
    //----------------------------------------------------------------------------------------------
    //endregion

    //region Methods for the inserting data.
    //----------------------------------------------------------------------------------------------
    /**
     * This method will insert a city object into the database and also all the airports, tours,
     * restaurants, bars, events, attractions, and all related items will be inserted also by
     * calling the insert methods for each objects below. I first complete the insertion of the city
     * object, then taking the long return value from the db.insert() method which returns the last
     * row id, in otherwords to auto-incremented primary key, casts it to an int and passes it as a
     * parameter for the further insert methods, as it will be the city id foreign key of all the
     * related places.
     *
     * @param city the city
     */
    public void insertCity(City city){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(CITY_NAME, city.getName());
        val.put(CITY_DESCRIPTION, city.getDescription());
        val.put(CITY_HISTORY, city.getHistory());
        val.put(CITY_LANGUAGE, city.getLanguage());
        val.put(CITY_COUNTRY, city.getCountry());
        val.put(CITY_POP, city.getPopulation());
        val.put(CITY_IMAGE, city.getImageResourceID());

        int cityID = (int) db.insert(TABLE_CITY, null, val);
        db.close();

        List<Airport> airportsList = city.getAirports();
        for (Airport airport: airportsList) {
            insertAirport(airport, cityID);
        }

        List<RestaurantBar> restaurantBarsList = city.getRestaurantBars();
        for (RestaurantBar restaurantBar: restaurantBarsList) {
            insertRestaurantBar(restaurantBar, cityID);
        }

        List<Hotel> hotelsList = city.getHotels();
        for (Hotel hotel: hotelsList) {
            insertHotel(hotel, cityID);
        }

        List<Event> eventsList = city.getEvents();
        for (Event event: eventsList) {
            insertEvent(event, cityID);
        }

        List<Attraction> attractionsList = city.getAttractions();
        for (Attraction attraction: attractionsList) {
            insertAttraction(attraction, cityID);
        }

        List<Tour> toursList = city.getTours();
        for (Tour tour: toursList) {
            insertTour(tour, cityID);
        }

        List<String> transportList = city.getTransport();
        for (String transport: transportList) {
            insertTransport(transport, cityID);
        }
    }

    /**
     * Insert airport.
     *
     * @param airport the airport
     * @param cityID  the city id
     */
    public void insertAirport(Airport airport, int cityID){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(AIRPORT_NAME, airport.getName());
        val.put(AIRPORT_CITY, cityID);
        val.put(AIRPORT_IATA, airport.getIata());
        val.put(AIRPORT_ADDRESS, airport.getAddressToString());

        db.insert(TABLE_AIRPORT, null, val);
        db.close();

    }

    /**
     * Insert restaurant bar. Also uses the same principle as the insertCity() method by passing the
     * restaurantBarID taken as a result of the db.insert() method and passes it as a parameter for
     * the insertCuisine() method.
     *
     * @param restaurantBar the restaurant bar
     * @param cityID        the city id
     */
    public void insertRestaurantBar(RestaurantBar restaurantBar, int cityID){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(RESTAURANT_BAR_NAME, restaurantBar.getName());
        val.put(RESTAURANT_BAR_CITY, cityID);
        val.put(RESTAURANT_BAR_ADDRESS, restaurantBar.getAddress().toString());
        val.put(RESTAURANT_BAR_NEIGHBOURHOOD, restaurantBar.getNeighbourhood());
        val.put(RESTAURANT_BAR_PHONE, restaurantBar.getPhoneNumber());
        val.put(RESTAURANT_BAR_RATING, restaurantBar.getRating());
        val.put(RESTAURANT_BAR_PRICE, restaurantBar.getPrice());
        val.put(RESTAURANT_BAR_MICHELIN_STARS, restaurantBar.getMichelinStars());
        val.put(RESTAURANT_BAR_IMAGE, restaurantBar.getImageResourceID());
        val.put(RESTAURANT_BAR_WEBSITE, restaurantBar.getWebsite().toString());
        val.put(RESTAURANT_BAR_OPENING_HOURS, restaurantBar.getOpeningHours());
        val.put(RESTAURANT_BAR_DINING_HOURS, restaurantBar.getDiningHours());
        val.put(RESTAURANT_BAR_DESCRIPTION, restaurantBar.getDescription());

        int resraurantBarID = (int) db.insert(TABLE_RESTAURANT_BAR, null, val);
        db.close();

        List<String> cuisinesList = restaurantBar.getCuisines();
        for (String cuisine: cuisinesList) {
            insertCuisine(cuisine, resraurantBarID);
        }
    }

    /**
     * Insert cuisine.
     *
     * @param cuisine         the cuisine
     * @param restaurantBarID the restaurant bar id
     */
    public void insertCuisine(String cuisine, int restaurantBarID){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(CUISINE_NAME, cuisine);
        val.put(CUISINE_RESTAURANT_BAR, restaurantBarID);

        db.insert(TABLE_CUISINE, null, val);
        db.close();
    }

    /**
     * Insert event.
     *
     * @param event  the event
     * @param cityID the city id
     */
    public void insertEvent(Event event, int cityID){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(EVENT_NAME, event.getName());
        val.put(EVENT_CITY, cityID);
        val.put(EVENT_ADDRESS, event.getAddress().toString());
        val.put(EVENT_DESCRIPTION, event.getDescription());
        val.put(EVENT_START_DATE, event.getStartDateTime().toString());
        val.put(EVENT_END_DATE, event.getEndDateTime().toString());
        val.put(EVENT_THEME, event.getTheme());
        val.put(EVENT_WHEELCHAIR_ACCESS, event.hasWheelchairAccess());
        val.put(EVENT_IMAGE, event.getImageResourceID());
        val.put(EVENT_WEBSITE, event.getWebsite().toString());

        db.insert(TABLE_EVENT, null, val);
        db.close();
    }

    /**
     * Insert attraction.
     *
     * @param attraction the attraction
     * @param cityID     the city id
     */
    public void insertAttraction(Attraction attraction, int cityID){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(ATTRACTION_NAME, attraction.getName());
        val.put(ATTRACTION_CITY, cityID);
        val.put(ATTRACTION_ADDRESS, attraction.getAddress().toString());
        val.put(ATTRACTION_DESCRIPTION, attraction.getDescription());
        val.put(ATTRACTION_OPENING_HOURS, attraction.getOpeningHours());
        val.put(ATTRACTION_PHONE, attraction.getPhoneNumber());
        val.put(ATTRACTION_PRICE, attraction.getPrice());
        val.put(ATTRACTION_WHEELCHAIR_ACCESS, attraction.hasWheelchairAccess());
        val.put(ATTRACTION_IMAGE, attraction.getImageResourceID());
        val.put(ATTRACTION_WEBSITE, attraction.getWebsite().toString());
        val.put(ATTRACTION_RATING, attraction.getRating());
        val.put(ATTRACTION_NEIGHBOURHOOD, attraction.getNeighbourhood());

        db.insert(TABLE_ATTRACTION, null, val);
        db.close();
    }

    /**
     * Insert hotel.
     *
     * @param hotel  the hotel
     * @param cityID the city id
     */
    public void insertHotel(Hotel hotel, int cityID){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(HOTEL_NAME, hotel.getName());
        val.put(HOTEL_CITY, cityID);
        val.put(HOTEL_ADDRESS, hotel.getAddress().toString());
        val.put(HOTEL_NEIGHBOURHOOD, hotel.getNeighbourhood());
        val.put(HOTEL_PHONE, hotel.getPhoneNumber());
        val.put(HOTEL_RATING, hotel.getRating());
        val.put(HOTEL_PRICE, hotel.getPrice());
        val.put(HOTEL_CLASS, hotel.getHotelClass());
        val.put(HOTEL_IMAGE, hotel.getImageResourceID());
        val.put(HOTEL_WEBSITE, hotel.getWebsite().toString());
        val.put(HOTEL_DESCRIPTION, hotel.getDescription());

        db.insert(TABLE_HOTEL, null, val);
        db.close();
    }

    /**
     * Insert tour.
     *
     * @param tour   the tour
     * @param cityID the city id
     */
    public void insertTour(Tour tour, int cityID){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(TOUR_NAME, tour.getName());
        val.put(TOUR_CITY, cityID);
        val.put(TOUR_START_ADDRESS, tour.getStartLocation().toString());
        val.put(TOUR_END_ADDRESS, tour.getEndLocation().toString());
        val.put(TOUR_PHONE, tour.getPhoneNumber());
        val.put(TOUR_COMPANY, tour.getOperator());
        val.put(TOUR_WHEELCHAIR_ACCESS, tour.hasWheelchairAccess());
        val.put(TOUR_OPERATING_TIMES, tour.getOperatingTimes());
        val.put(TOUR_IMAGE, tour.getImageResourceID());
        val.put(TOUR_WEBSITE, tour.getWebsite().toString());
        val.put(TOUR_DESCRIPTION, tour.getDescription());
        val.put(TOUR_RATING, tour.getPrice());
        val.put(TOUR_PRICE, tour.getRating());

        db.insert(TABLE_TOUR, null, val);
        db.close();
    }

    /**
     * Insert transport.
     *
     * @param transport the transport
     * @param cityID    the city id
     */
    public void insertTransport(String transport, int cityID){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(TRANSPORT_TYPE, transport);
        val.put(TRANSPORT_CITY, cityID);

        db.insert(TABLE_TRANSPORT, null, val);
        db.close();
    }
    //----------------------------------------------------------------------------------------------
    //endregion

    //region Methods for retrieving data.
    //----------------------------------------------------------------------------------------------

    /**
     * Gets all the cities in the db. For each city, it will call all the other get_ByCity()
     * methods to populate the city with lists of hotels, tours, events, etc..
     *
     * @return the list
     */
    public List<City> getAllCities(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<City> cityList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_CITY;
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()){
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                int cityID = c.getInt(c.getColumnIndex(CITY_ID));
                String name = c.getString(c.getColumnIndex(CITY_NAME));
                String country = c.getString(c.getColumnIndex(CITY_COUNTRY));
                String description = c.getString(c.getColumnIndex(CITY_DESCRIPTION));
                String history = c.getString(c.getColumnIndex(CITY_HISTORY));
                int population = c.getInt(c.getColumnIndex(CITY_POP));
                int imageResourceID = c.getInt(c.getColumnIndex(CITY_IMAGE));
                String language = c.getString(c.getColumnIndex(CITY_LANGUAGE));

                Locale locale = new Locale(language, country);
                Address address = new Address(locale);
                address.setLocality(name);

                List<Airport> airportsList = getAllAirportsByCity(cityID, address);
                List<RestaurantBar> restaurantBarList = getAllRestaurantBarsByCity(cityID, address);
                List<Hotel> hotelsList = getAllHotelsByCity(cityID, address);
                List<Tour> toursList = getAllToursByCity(cityID, address);
                List<Event> eventsList = getAllEventsByCity(cityID, address);
                List<Attraction> attractionsList = getAllAttractionsByCity(cityID, address);
                List<String> transportList = getAllTransportByCity(cityID);

                City city = new City(address, airportsList, population, description, history,
                        hotelsList, restaurantBarList, attractionsList, eventsList, toursList,
                        imageResourceID, transportList);

                cityList.add(city);

            }
            c.close();
            return cityList;
        }
        return null;
    }

    /**
     * Get all hotels by city and return in a List.
     *
     * @param cityID  the city id
     * @param address the address
     * @return the list
     */
    public List<Hotel> getAllHotelsByCity(int cityID, Address address){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Hotel> hotelList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_HOTEL + " WHERE " + HOTEL_CITY + " = " + cityID;
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                String name = c.getString(c.getColumnIndex(HOTEL_NAME));
                String add = c.getString(c.getColumnIndex(HOTEL_ADDRESS));
                String description = c.getString(c.getColumnIndex(HOTEL_DESCRIPTION));
                String neighbourhood = c.getString(c.getColumnIndex(HOTEL_NEIGHBOURHOOD));
                int rating = c.getInt(c.getColumnIndex(HOTEL_RATING));
                int price = c.getInt(c.getColumnIndex(HOTEL_PRICE));
                int hotelClass = c.getInt(c.getColumnIndex(HOTEL_CLASS));
                int imageResourceID = c.getInt(c.getColumnIndex(HOTEL_IMAGE));
                URL website;
                try{
                    website = new URL((c.getString(c.getColumnIndex(HOTEL_WEBSITE))));
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                String phone = c.getString(c.getColumnIndex(HOTEL_PHONE));

                // Updating the address object by converting the String to an address
                getFirstThreeAddressLines(add, address);
                address.setSubLocality(neighbourhood);
                address.setPhone(phone);

                hotelList.add(new Hotel(name, address, website, description, imageResourceID, rating, price, hotelClass));
            }
            c.close();
            return hotelList;
        }
        return null;
    }

    /**
     * Get list of all restaurantBars by city.
     *
     * @param cityID  the city id
     * @param address the address
     * @return the list
     */
    public List<RestaurantBar> getAllRestaurantBarsByCity(int cityID, Address address){
        SQLiteDatabase db = this.getReadableDatabase();
        List<RestaurantBar> restaurantBarList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_RESTAURANT_BAR + " WHERE " + HOTEL_CITY + " = " + cityID;
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                int restaurantBarID = c.getInt(c.getColumnIndex(RESTAURANT_BAR_ID));
                String name = c.getString(c.getColumnIndex(RESTAURANT_BAR_NAME));
                String add = c.getString(c.getColumnIndex(RESTAURANT_BAR_ADDRESS));
                String description = c.getString(c.getColumnIndex(RESTAURANT_BAR_DESCRIPTION));
                String neighbourhood = c.getString(c.getColumnIndex(RESTAURANT_BAR_NEIGHBOURHOOD));
                String openingHours = c.getString(c.getColumnIndex(RESTAURANT_BAR_OPENING_HOURS));
                String diningHours = c.getString(c.getColumnIndex(RESTAURANT_BAR_DINING_HOURS));
                int rating = c.getInt(c.getColumnIndex(RESTAURANT_BAR_RATING));
                int price = c.getInt(c.getColumnIndex(RESTAURANT_BAR_RATING));
                int michelinStars = c.getInt(c.getColumnIndex(RESTAURANT_BAR_MICHELIN_STARS));
                int imageResourceID = c.getInt(c.getColumnIndex(RESTAURANT_BAR_IMAGE));
                URL website;
                try{
                    website = new URL((c.getString(c.getColumnIndex(RESTAURANT_BAR_WEBSITE))));
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                String phone = c.getString(c.getColumnIndex(RESTAURANT_BAR_PHONE));

                // Updating the address object by converting the String to an address
                getFirstThreeAddressLines(add, address);
                address.setSubLocality(neighbourhood);
                address.setPhone(phone);

                List<String> cuisines = getAllCuisinesByRestaurantBar(restaurantBarID);

                restaurantBarList.add(new RestaurantBar(name, address, website, description, imageResourceID, rating, price, openingHours, diningHours, michelinStars, cuisines));
            }
            c.close();
            return restaurantBarList;
        }
        return null;
    }

    /**
     * Get all cuisines by restaurant bar in list format.
     *
     * @param restaurantBarID the restaurant bar id
     * @return the list
     */
    public List<String> getAllCuisinesByRestaurantBar(int restaurantBarID){
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> cuisineList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_CUISINE + " WHERE " +
                CUISINE_RESTAURANT_BAR + " = " + restaurantBarID;
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                String name = c.getString(c.getColumnIndex(CUISINE_NAME));
                cuisineList.add(name);
            }
            c.close();
            return cuisineList;
        }
        return null;
    }

    /**
     * Get list of all events by city.
     *
     * @param cityID  the city id
     * @param address the address
     * @return the list
     */
    public List<Event> getAllEventsByCity(int cityID, Address address){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Event> eventList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_EVENT + " WHERE " + EVENT_CITY + " = " + cityID;
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                String name = c.getString(c.getColumnIndex(EVENT_NAME));
                String add = c.getString(c.getColumnIndex(EVENT_ADDRESS));
                String description = c.getString(c.getColumnIndex(EVENT_DESCRIPTION));
                String theme = c.getString(c.getColumnIndex(EVENT_THEME));
                String dateEnd = c.getString(c.getColumnIndex(EVENT_END_DATE));
                String dateStart = c.getString(c.getColumnIndex(EVENT_START_DATE));
                int imageResourceID = c.getInt(c.getColumnIndex(EVENT_IMAGE));
                URL website;
                try{
                    website = new URL((c.getString(c.getColumnIndex(EVENT_WEBSITE))));
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                int access = c.getInt(c.getColumnIndex(EVENT_WHEELCHAIR_ACCESS));
                boolean wheelchairAccess = (access == 1);

                // Updating the address object by converting the String to an address
                getFirstThreeAddressLines(add, address);

                Date startDate = stringToDate(dateStart);
                Date endDate = stringToDate(dateEnd);

                eventList.add(new Event(name, startDate, endDate, address, description, theme,
                        imageResourceID, website, wheelchairAccess));
            }
            c.close();
            return eventList;
        }
        return null;
    }

    /**
     * Get all attractions by city list.
     *
     * @param cityID  the city id
     * @param address the address
     * @return the list
     */
    public List<Attraction> getAllAttractionsByCity(int cityID, Address address){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Attraction> attractionsList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_ATTRACTION + " WHERE " + ATTRACTION_CITY + " = " + cityID;
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                String name = c.getString(c.getColumnIndex(ATTRACTION_NAME));
                String add = c.getString(c.getColumnIndex(ATTRACTION_ADDRESS));
                String description = c.getString(c.getColumnIndex(ATTRACTION_DESCRIPTION));
                String neighbourhood = c.getString(c.getColumnIndex(ATTRACTION_NEIGHBOURHOOD));
                String openingHours = c.getString(c.getColumnIndex(ATTRACTION_OPENING_HOURS));
                String phone = c.getString(c.getColumnIndex(ATTRACTION_PHONE));
                int imageResourceID = c.getInt(c.getColumnIndex(ATTRACTION_IMAGE));
                int rating = c.getInt(c.getColumnIndex(ATTRACTION_RATING));
                int price = c.getInt(c.getColumnIndex(ATTRACTION_PRICE));
                URL website;
                try{
                    website = new URL((c.getString(c.getColumnIndex(ATTRACTION_WEBSITE))));
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                int access = c.getInt(c.getColumnIndex(ATTRACTION_WHEELCHAIR_ACCESS));
                boolean wheelchairAccess = (access == 1);

                // Updating the address object by converting the String to an address and setting
                // the neighbourhood and phone number.
                getFirstThreeAddressLines(add, address);
                address.setSubLocality(neighbourhood);
                address.setPhone(phone);

                attractionsList.add(new Attraction(name, address, website, description,
                        imageResourceID, rating, price, openingHours, wheelchairAccess));
            }
            c.close();
            return attractionsList;
        }
        return null;
    }

    /**
     * Get list of all tours by city.
     *
     * @param cityID  the city id
     * @param address the address
     * @return the list
     */
    public List<Tour> getAllToursByCity(int cityID, Address address){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Tour> toursList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_TOUR+ " WHERE " + TOUR_CITY + " = " + cityID;
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                String name = c.getString(c.getColumnIndex(TOUR_NAME));
                String addressStart = c.getString(c.getColumnIndex(TOUR_START_ADDRESS));
                String addressEnd = c.getString(c.getColumnIndex(TOUR_START_ADDRESS));
                String description = c.getString(c.getColumnIndex(TOUR_DESCRIPTION));
                String operator = c.getString(c.getColumnIndex(TOUR_COMPANY));
                String operatingTimes = c.getString(c.getColumnIndex(TOUR_OPERATING_TIMES));
                String phone = c.getString(c.getColumnIndex(TOUR_PHONE));
                int imageResourceID = c.getInt(c.getColumnIndex(TOUR_IMAGE));
                int rating = c.getInt(c.getColumnIndex(TOUR_RATING));
                int price = c.getInt(c.getColumnIndex(TOUR_PRICE));

                URL website;
                try{
                    website = new URL((c.getString(c.getColumnIndex(TOUR_WEBSITE))));
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
                int access = c.getInt(c.getColumnIndex(TOUR_WHEELCHAIR_ACCESS));
                boolean wheelchairAccess = (access == 1);

                // Creating new address objects and setting them to have the same Locale as the
                // city Address object and then setting the first three lines of the addresses by
                // taking the first three lines of the address strings from the DB.
                Address startLocation = new Address(address.getLocale());
                Address endLocation = new Address(address.getLocale());
                getFirstThreeAddressLines(addressStart, startLocation);
                getFirstThreeAddressLines(addressEnd, endLocation);
                address.setPhone(phone);

                toursList.add(new Tour(name, operator, imageResourceID, rating, price, description,
                        operatingTimes, startLocation, endLocation, wheelchairAccess, website, phone));
            }
            c.close();
            return toursList;
        }
        return null;
    }

    /**
     * Get list of all transport in city with cityID passed as a parameter.
     *
     * @param cityID the city id
     * @return the list
     */
    public List<String> getAllTransportByCity(int cityID){
        SQLiteDatabase db = this.getReadableDatabase();
        List<String> transportList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_TRANSPORT + " WHERE " +
                TRANSPORT_CITY + " = " + cityID;
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                String name = c.getString(c.getColumnIndex(TRANSPORT_TYPE));
                transportList.add(name);
            }
            c.close();
            return transportList;
        }
        return null;
    }

    /**
     * Get all airports by city in list format.
     *
     * @param cityID  the city id
     * @param address the address
     * @return the list
     */
    public List<Airport> getAllAirportsByCity(int cityID, Address address){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Airport> airportsList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_AIRPORT + " WHERE " + AIRPORT_CITY + " = " + cityID;
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                String name = c.getString(c.getColumnIndex(AIRPORT_NAME));
                String add = c.getString(c.getColumnIndex(AIRPORT_ADDRESS));
                String iataCode = c.getString(c.getColumnIndex(AIRPORT_IATA));

                // Updating the address object by converting the String to an address through
                // getting the first three lines of the address.
                getFirstThreeAddressLines(add, address);

                airportsList.add(new Airport(name, iataCode, address));
            }
            c.close();
            return airportsList;
        }
        return null;
    }

    //----------------------------------------------------------------------------------------------
    //endregion

    //region Class utility methods in here
    //----------------------------------------------------------------------------------------------
    /**
     * A quick utility method to take the address string from the DB and put the first 3 lines of
     * the address into the Address object.
     * @param stringAddress The first 3 lines of the address in string form
     * @param address       The Address object.
     */
    private void getFirstThreeAddressLines(String stringAddress, Address address){
        String [] addressLines = stringAddress.split(", ");
        address.setAddressLine(0, addressLines[0]);
        address.setAddressLine(1, addressLines[1]);
        address.setAddressLine(2, addressLines[2]);
    }
    //----------------------------------------------------------------------------------------------
    //endregion
}

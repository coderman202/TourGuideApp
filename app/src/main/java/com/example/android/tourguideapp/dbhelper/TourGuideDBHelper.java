package com.example.android.tourguideapp.dbhelper;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Address;
import android.util.Log;

import com.example.android.tourguideapp.model.Airport;
import com.example.android.tourguideapp.model.Amenity;
import com.example.android.tourguideapp.model.Attraction;
import com.example.android.tourguideapp.model.City;
import com.example.android.tourguideapp.model.Event;
import com.example.android.tourguideapp.model.Hotel;
import com.example.android.tourguideapp.model.RestaurantBar;
import com.example.android.tourguideapp.model.Tour;
import com.example.android.tourguideapp.model.Transport;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.example.android.tourguideapp.utils.TourGuideUtilities.stringToDate;

/**
 * My custom class for handling all db queries
 */
public class TourGuideDBHelper extends SQLiteOpenHelper {

    // Storing the context for later use in passing through to custom class objects via their
    // constructors.
    private Context context;

    // File names of the scripts stored in assets directory
    private static final String CREATE_TABLES = "create_tables.sql";
    private static final String DROP_TABLES = "drop_tables.sql";
    private static final String INSERT_DATA = "insert_data.sql";

    //region DB, Table and column name declarations
    //----------------------------------------------------------------------------------------------
    // DB name, version and log_tag
    private static final String LOG_TAG = "TourGuideDBHelper";
    private static final int DATABASE_VERSION = 14;
    private static final String DATABASE_NAME = "TourGuideDB";

    // Table names in DB
    private static final String TABLE_CITY = "City";
    private static final String TABLE_HOTEL = "Hotel";
    private static final String TABLE_AMENITY = "Amenity";
    private static final String TABLE_HOTEL_AMENITY = "HotelAmenity";
    private static final String TABLE_RESTAURANT_BAR = "RestaurantBar";
    private static final String TABLE_CUISINE = "Cuisine";
    private static final String TABLE_RESTAURANT_BAR_CUISINE = "RestaurantBarCuisine";
    private static final String TABLE_AIRPORT = "Airport";
    private static final String TABLE_EVENT = "Event";
    private static final String TABLE_ATTRACTION = "Attraction";
    private static final String TABLE_TOUR = "Tour";
    private static final String TABLE_TRANSPORT = "Transport";
    private static final String TABLE_TRANSPORT_SYSTEM = "TransportSystem";

    // Column names for City table
    private static final String CITY_ID = "CityID";
    private static final String CITY_NAME = "CityName";
    private static final String CITY_COUNTRY = "CityCountry";
    private static final String CITY_POP = "CityPopulation";
    private static final String CITY_DESCRIPTION = "CityDescription";
    private static final String CITY_HISTORY = "CityHistory";
    private static final String CITY_LANGUAGE = "CityLanguage";
    private static final String CITY_IMAGE = "CityImage";
    private static final String CITY_TIME_ZONE = "CityTimeZone";

    // Column names for the Airport table
    private static final String AIRPORT_ID = "AirportID";
    private static final String AIRPORT_NAME = "AirportName";
    private static final String AIRPORT_CITY = "CityID";
    private static final String AIRPORT_IATA = "AirportIATACode";

    // Column names for the Transport table
    private static final String TRANSPORT_ID = "TransportID";
    private static final String TRANSPORT_TYPE = "TransportType";
    private static final String TRANSPORT_ICON = "TransportIcon";

    // Column names for the TransportSystem table which acts as a lookup table for the many-to-many
    // relationship.
    private static final String TRANSPORT_SYSTEM_ID = "TransportSystemID";
    private static final String TRANSPORT_SYSTEM_TRANSPORT_ID = "TransportID";
    private static final String TRANSPORT_SYSTEM_CITY_ID = "CityID";

    // Column names for the Hotel table
    private static final String HOTEL_ID = "HotelID";
    private static final String HOTEL_NAME = "HotelName";
    private static final String HOTEL_CITY = "CityID";
    private static final String HOTEL_DESCRIPTION = "HotelDescription";
    private static final String HOTEL_ADDRESS = "HotelAddress";
    private static final String HOTEL_CLASS = "HotelClass";
    private static final String HOTEL_RATING = "HotelRating";
    private static final String HOTEL_PRICE = "HotelPrice";
    private static final String HOTEL_WEBSITE = "HotelWebsite";
    private static final String HOTEL_NEIGHBOURHOOD = "HotelNeighbourhood";
    private static final String HOTEL_PHONE = "HotelPhone";

    // Column names for the Amenity table.
    private static final String AMENITY_ID = "AmenityID";
    private static final String AMENITY_NAME = "AmenityName";
    private static final String AMENITY_ICON = "AmenityIcon";

    // Column names for the HotelAmenity lookup table which deals with the many-to-many relationship.
    private static final String HOTEL_AMENITY_ID = "HotelAmenityID";
    private static final String HOTEL_AMENITY_AMENITY_ID = "AmenityID";
    private static final String HOTEL_AMENITY_HOTEL_ID = "HotelID";

    // Column names for the RestaurantBar table
    private static final String RESTAURANT_BAR_ID = "RestaurantBarID";
    private static final String RESTAURANT_BAR_NAME = "RestaurantBarName";
    private static final String RESTAURANT_BAR_CITY = "CityID";
    private static final String RESTAURANT_BAR_OPENING_HOURS = "RestaurantBarOpeningHours";
    private static final String RESTAURANT_BAR_DINING_HOURS = "RestaurantBarDiningHours";
    private static final String RESTAURANT_BAR_DESCRIPTION = "RestaurantBarDescription";
    private static final String RESTAURANT_BAR_MICHELIN_STARS = "RestaurantBarMichelinStars";
    private static final String RESTAURANT_BAR_ADDRESS = "RestaurantBarAddress";
    private static final String RESTAURANT_BAR_RATING = "RestaurantBarRating";
    private static final String RESTAURANT_BAR_PRICE = "RestaurantBarPrice";
    private static final String RESTAURANT_BAR_WEBSITE = "RestaurantBarWebsite";
    private static final String RESTAURANT_BAR_NEIGHBOURHOOD = "RestaurantBarNeighbourhood";
    private static final String RESTAURANT_BAR_PHONE = "RestaurantBarPhone";
    private static final String RESTAURANT_BAR_WHEELCHAIR_ACCESS = "RestaurantBarWheelchairAccess";

    // Column names for the Cuisine table
    private static final String CUISINE_ID = "CuisineID";
    private static final String CUISINE_NAME = "CuisineName";

    // Column names for the RestaurantBarCuisine table which deals with the many-to-many relationship.
    private static final String RESTAURANT_BAR_CUISINE_ID = "RestaurantBarCuisineID";
    private static final String RESTAURANT_BAR_CUISINE_CUISINE_ID = "CuisineID";
    private static final String RESTAURANT_BAR_CUISINE_RESTAURANT_BAR_ID = "RestaurantBarID";

    // Column names for the Event table
    private static final String EVENT_ID = "EventID";
    private static final String EVENT_NAME = "EventName";
    private static final String EVENT_CITY = "CityID";
    private static final String EVENT_START_DATE_TIME = "EventStartDateTime";
    private static final String EVENT_END_DATE_TIME = "EventEndDateTime";
    private static final String EVENT_ADDRESS = "EventAddress";
    private static final String EVENT_DESCRIPTION = "EventDescription";
    private static final String EVENT_WEBSITE = "EventWebsite";
    private static final String EVENT_THEME = "EventTheme";
    private static final String EVENT_WHEELCHAIR_ACCESS = "EventWheelchairAccess";

    // Column names for the Attraction table
    private static final String ATTRACTION_ID = "AttractionID";
    private static final String ATTRACTION_NAME = "AttractionName";
    private static final String ATTRACTION_CITY = "CityID";
    private static final String ATTRACTION_OPENING_HOURS = "AttractionOpeningHours";
    private static final String ATTRACTION_ADDRESS = "AttractionAddress";
    private static final String ATTRACTION_DESCRIPTION = "AttractionDescription";
    private static final String ATTRACTION_RATING = "AttractionRating";
    private static final String ATTRACTION_PRICE = "AttractionPrice";
    private static final String ATTRACTION_WEBSITE = "AttractionWebsite";
    private static final String ATTRACTION_WHEELCHAIR_ACCESS = "AttractionWheelchairAccess";
    private static final String ATTRACTION_NEIGHBOURHOOD = "AttractionNeighbourhood";
    private static final String ATTRACTION_PHONE = "AttractionPhone";

    // Column names for the Tour table
    private static final String TOUR_ID = "TourID";
    private static final String TOUR_NAME = "TourName";
    private static final String TOUR_CITY = "CityID";
    private static final String TOUR_OPERATING_TIMES = "TourOperatingTimes";
    private static final String TOUR_ADDRESS = "TourAddress";
    private static final String TOUR_DESCRIPTION = "TourDescription";
    private static final String TOUR_WEBSITE = "TourWebsite";
    private static final String TOUR_OPERATOR = "TourOperator";
    private static final String TOUR_WHEELCHAIR_ACCESS = "TourWheelchairAccess";
    private static final String TOUR_PHONE = "TourPhone";
    private static final String TOUR_PRICE = "TourPrice";
    private static final String TOUR_RATING = "TourRating";


    //----------------------------------------------------------------------------------------------
    //endregion

    //region The default constructor and the basic overridden onCreate and onUpgrade methods.
    // Also includes a method ro execute sql scripts from the assets folder.
    //----------------------------------------------------------------------------------------------
    /**
     * Default constructor
     * @param context the context
     */
    public TourGuideDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        runSQLScript(this.context, db, CREATE_TABLES);
        runSQLScript(this.context, db, INSERT_DATA);
    }

    // On upgrade drop older tables and create new ones calling the onCreate() method.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        runSQLScript(this.context, db, DROP_TABLES);
        onCreate(db);
    }

    /**
     * A method to execute sql scripts. This can be called to run the create_tables.sql script in
     * the onCreate method, along with the insert_data.sql file. n the onUpgrade method, the
     * drop_tables.sql file can be called along with the create and insert scripts. My resource for
     * this method is found below.
     * @param context   The context
     * @param db        The db that the script is run on
     * @param sqlScript The sql script
     * @see <a href="http://www.drdobbs.com/database/using-sqlite-on-android/232900584">Here</a>
     */
    private void runSQLScript(Context context, SQLiteDatabase db, String sqlScript) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte buf[] = new byte[1024];
        int len;
        AssetManager assetManager = context.getAssets();
        InputStream inputStream;

        try {
            inputStream = assetManager.open(sqlScript);
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();

            String[] script = outputStream.toString().split(";");
            for (String sqlStatement:script) {
                sqlStatement = sqlStatement.trim();
                if (sqlStatement.length() > 0) {
                    db.execSQL(sqlStatement + ";");
                }
            }
        } catch (IOException e) {
            Log.e(e.toString(), sqlScript + "failed to load");
        } catch (SQLException e) {
            Log.e(e.toString(), sqlScript + "failed to execute");
        }
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
                String imageFileName = c.getString(c.getColumnIndex(CITY_IMAGE));
                String language = c.getString(c.getColumnIndex(CITY_LANGUAGE));
                String timeZone = c.getString(c.getColumnIndex(CITY_TIME_ZONE));

                Locale locale = new Locale(language, country);
                Address address = new Address(locale);
                address.setLocality(name);
                address.setCountryName(country);

                List<Airport> airportsList = getAllAirportsByCity(cityID, address);
                List<RestaurantBar> restaurantBarList = getAllRestaurantBarsByCity(cityID, address);
                List<Hotel> hotelsList = getAllHotelsByCity(cityID, address);
                List<Tour> toursList = getAllToursByCity(cityID, address);
                List<Event> eventsList = getAllEventsByCity(cityID, address);
                List<Attraction> attractionsList = getAllAttractionsByCity(cityID, address);
                List<Transport> transportList = getAllTransportByCity(cityID);

                address.setLocality(name);
                address.setCountryName(country);

                City city = new City(context, address, airportsList, population, description, history,
                        timeZone, hotelsList, restaurantBarList, attractionsList, eventsList, toursList,
                        imageFileName, transportList);
                cityList.add(city);
                c.moveToNext();
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
                int hotelID = c.getInt(c.getColumnIndex(HOTEL_ID));
                String name = c.getString(c.getColumnIndex(HOTEL_NAME));
                String add = c.getString(c.getColumnIndex(HOTEL_ADDRESS));
                String description = c.getString(c.getColumnIndex(HOTEL_DESCRIPTION));
                String neighbourhood = c.getString(c.getColumnIndex(HOTEL_NEIGHBOURHOOD));
                float rating = c.getFloat(c.getColumnIndex(HOTEL_RATING));
                float price = c.getFloat(c.getColumnIndex(HOTEL_PRICE));
                int hotelClass = c.getInt(c.getColumnIndex(HOTEL_CLASS));
                String website = c.getString(c.getColumnIndex(HOTEL_WEBSITE));
                String phone = c.getString(c.getColumnIndex(HOTEL_PHONE));

                // Updating the address object by converting the String to an address
                Address hotelAddress = getFirstThreeAddressLines(add, address);
                hotelAddress.setSubLocality(neighbourhood);
                hotelAddress.setPhone(phone);

                Log.d(LOG_TAG, "Hotel name: " + name);

                List<Amenity> amenityList = getAllAmenitiesByHotel(hotelID);

                hotelList.add(new Hotel(context, name, hotelAddress, website, description,
                        rating, price, hotelClass, amenityList));
                c.moveToNext();
            }
            c.close();
            return hotelList;
        }
        return null;
    }

    /**
     * Get all amenities by hotel in list form.
     *
     * @param hotelID the hotel id
     * @return the list
     */
    public List<Amenity> getAllAmenitiesByHotel(int hotelID){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Amenity> amenityList = new ArrayList<>();
        String query = "SELECT " + TABLE_AMENITY + "." + AMENITY_NAME + ", " + TABLE_AMENITY + "." +
                AMENITY_ICON + " FROM " + TABLE_AMENITY + ", " + TABLE_HOTEL_AMENITY + " WHERE " +
                TABLE_HOTEL_AMENITY + "." + HOTEL_AMENITY_HOTEL_ID + " = " + hotelID + " AND " +
                TABLE_HOTEL_AMENITY + "." + HOTEL_AMENITY_AMENITY_ID + " = " + TABLE_AMENITY + "." +
                AMENITY_ID + ";";
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                String name = c.getString(c.getColumnIndex(AMENITY_NAME));
                String iconFileName = c.getString(c.getColumnIndex(AMENITY_ICON));

                amenityList.add(new Amenity(context, name, iconFileName));
                c.moveToNext();
            }
            c.close();
            return amenityList;
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
        String query = "SELECT * FROM " + TABLE_RESTAURANT_BAR + " WHERE " + RESTAURANT_BAR_CITY + " = " + cityID;
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
                float rating = c.getFloat(c.getColumnIndex(RESTAURANT_BAR_RATING));
                float price = c.getFloat(c.getColumnIndex(RESTAURANT_BAR_PRICE));
                int michelinStars = c.getInt(c.getColumnIndex(RESTAURANT_BAR_MICHELIN_STARS));
                String website = c.getString(c.getColumnIndex(RESTAURANT_BAR_WEBSITE));
                String phone = c.getString(c.getColumnIndex(RESTAURANT_BAR_PHONE));
                int access = c.getInt(c.getColumnIndex(RESTAURANT_BAR_WHEELCHAIR_ACCESS));
                boolean wheelchairAccess = (access == 1);

                // Updating the address object by converting the String to an address
                Address restaurantBarAddress = getFirstThreeAddressLines(add, address);
                restaurantBarAddress.setSubLocality(neighbourhood);
                restaurantBarAddress.setPhone(phone);

                List<String> cuisines = getAllCuisinesByRestaurantBar(restaurantBarID);

                restaurantBarList.add(new RestaurantBar(context, name, restaurantBarAddress, website,
                        description, rating, price, openingHours, diningHours, michelinStars,
                        cuisines, wheelchairAccess));
                c.moveToNext();
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
        String query = "SELECT " + TABLE_CUISINE + "." + CUISINE_NAME + " FROM " + TABLE_CUISINE +
                ", " + TABLE_RESTAURANT_BAR_CUISINE + " WHERE " + TABLE_RESTAURANT_BAR_CUISINE +
                "." + RESTAURANT_BAR_CUISINE_RESTAURANT_BAR_ID + " = " + restaurantBarID + " AND " +
                TABLE_RESTAURANT_BAR_CUISINE + "." + RESTAURANT_BAR_CUISINE_CUISINE_ID + " = " +
                TABLE_CUISINE + "." + CUISINE_ID + ";";
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                String name = c.getString(c.getColumnIndex(CUISINE_NAME));
                cuisineList.add(name);
                c.moveToNext();
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
                String dateEnd = c.getString(c.getColumnIndex(EVENT_END_DATE_TIME));
                String dateStart = c.getString(c.getColumnIndex(EVENT_START_DATE_TIME));
                String website = c.getString(c.getColumnIndex(EVENT_WEBSITE));
                int access = c.getInt(c.getColumnIndex(EVENT_WHEELCHAIR_ACCESS));
                boolean wheelchairAccess = (access == 1);

                // Updating the address object by converting the String to an address
                Address eventAddress = getFirstThreeAddressLines(add, address);

                Date startDate = stringToDate(dateStart);
                Date endDate = stringToDate(dateEnd);

                eventList.add(new Event(context, name, startDate, endDate, eventAddress,
                        description, theme, website, wheelchairAccess));
                c.moveToNext();
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
                float rating = c.getFloat(c.getColumnIndex(ATTRACTION_RATING));
                float price = c.getFloat(c.getColumnIndex(ATTRACTION_PRICE));
                String website = c.getString(c.getColumnIndex(ATTRACTION_WEBSITE));
                int access = c.getInt(c.getColumnIndex(ATTRACTION_WHEELCHAIR_ACCESS));
                boolean wheelchairAccess = (access == 1);

                // Updating the address object by converting the String to an address and setting
                // the neighbourhood and phone number.
                Address attractionAddress = getFirstThreeAddressLines(add, address);
                address.setSubLocality(neighbourhood);
                address.setPhone(phone);

                attractionsList.add(new Attraction(context, name, attractionAddress, website,
                        description, rating, price, openingHours, wheelchairAccess));
                c.moveToNext();
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
                String add = c.getString(c.getColumnIndex(TOUR_ADDRESS));
                String description = c.getString(c.getColumnIndex(TOUR_DESCRIPTION));
                String operator = c.getString(c.getColumnIndex(TOUR_OPERATOR));
                String operatingTimes = c.getString(c.getColumnIndex(TOUR_OPERATING_TIMES));
                String phone = c.getString(c.getColumnIndex(TOUR_PHONE));
                float rating = c.getFloat(c.getColumnIndex(TOUR_RATING));
                float price = c.getFloat(c.getColumnIndex(TOUR_PRICE));
                String website = c.getString(c.getColumnIndex(TOUR_WEBSITE));
                int access = c.getInt(c.getColumnIndex(TOUR_WHEELCHAIR_ACCESS));
                boolean wheelchairAccess = (access == 1);

                // Creating new address objects and setting them to have the same Locale as the
                // city Address object and then setting the first three lines of the addresses by
                // taking the first three lines of the address strings from the DB.
                Address tourAddress = getFirstThreeAddressLines(add, address);
                tourAddress.setPhone(phone);

                toursList.add(new Tour(context, name, operator, rating, price, description,
                        operatingTimes, tourAddress, wheelchairAccess, website, phone));
                c.moveToNext();
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
    public List<Transport> getAllTransportByCity(int cityID){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Transport> transportList = new ArrayList<>();
        String query = "SELECT " + TABLE_TRANSPORT + "." + TRANSPORT_TYPE + ", " + TABLE_TRANSPORT + "." +
                TRANSPORT_ICON + " FROM " + TABLE_TRANSPORT + ", " + TABLE_TRANSPORT_SYSTEM + " WHERE " +
                TABLE_TRANSPORT_SYSTEM + "." + TRANSPORT_SYSTEM_CITY_ID + " = " + cityID + " AND " +
                TABLE_TRANSPORT_SYSTEM + "." + TRANSPORT_SYSTEM_TRANSPORT_ID + " = " + TABLE_TRANSPORT + "." +
                TRANSPORT_ID + ";";
        Cursor c = db.rawQuery(query, null);

        if(c != null && c.moveToFirst()) {
            c.moveToFirst();
            for (int i = 0; i < c.getCount(); i++) {
                String name = c.getString(c.getColumnIndex(TRANSPORT_TYPE));
                String iconFileName = c.getString(c.getColumnIndex(TRANSPORT_ICON));
                transportList.add(new Transport(context, name, iconFileName));
                c.moveToNext();
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
                String iataCode = c.getString(c.getColumnIndex(AIRPORT_IATA));

                airportsList.add(new Airport(name, iataCode, address));
                c.moveToNext();
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
    private Address getFirstThreeAddressLines(String stringAddress, Address address){
        String [] addressLines = stringAddress.split(", ");
        Address newAddress = new Address(address.getLocale());
        newAddress.setCountryName(address.getCountryName());
        newAddress.setLocality(address.getLocality());
        newAddress.setAddressLine(0, addressLines[0]);
        newAddress.setAddressLine(1, addressLines[1]);
        newAddress.setAddressLine(2, addressLines[2]);

        return newAddress;
    }
    //----------------------------------------------------------------------------------------------
    //endregion
}

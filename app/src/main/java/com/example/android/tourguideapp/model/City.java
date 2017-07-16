package com.example.android.tourguideapp.model;

import android.content.Context;
import android.location.Address;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * A custom class to represent a city
 */
public class City implements Parcelable {

    //region Attribute variable declarations
    // An Address object to store the location of the city
    private Address address;

    // This attribute will be derived from the Address.getCountry() method to ensure accuracy.
    private String country;

    // This attribute will be derived using the Address.getLocality() method to provide the name of
    // the city.
    private String name;

    // A list of custom Airport objects to represent the number of airports in the city
    private List<Airport> airports;

    // A list of transport objects to represent all the forms of transport in the city
    private List<Transport> transport;

    // The current city population
    private int population;

    // A resource id of an image to represent the city
    private int imageResourceID;

    // The following two attributes will be a short description about the city as in where it is
    // and what is it known for, along with maybe one or two famous attractions it is well known
    // for.
    private String description;
    private String history;

    // An array of languages that are spoken in the city. Often it will just be one. It will be
    // derived from the Locale object that will itself be derived from the Address.getLocale()
    // method.
    private String language;

    // The time zone of the city to allow for the display of the correct time
    private String timeZone;

    // The currency used in the city
    private String currency;

    // A list of all the hotels in the city
    private List<Hotel> hotels;

    // A list of all the restaurants and bars in the city
    private List<RestaurantBar> restaurantBars;

    // A list of all the attractions in the city
    private List<Attraction> attractions;

    // A list of all the events in the city
    private List<Event> events;

    // A list of all the tours in the city
    private List<Tour> tours;

    // The context which will be needed to get the correct resource id of the city image.
    private Context context;
    //endregion

    //region Constructor(s)

    /**
     * Instantiates a new City.
     *
     * @param context        the context
     * @param address        the address
     * @param airports       the airports
     * @param population     the population
     * @param description    the description
     * @param history        the history
     * @param timeZone       the time zone
     * @param hotels         the hotels
     * @param restaurantBars the restaurant bars
     * @param attractions    the attractions
     * @param events         the events
     * @param tours          the tours
     * @param imageFileName  the image file name
     * @param transport      the transport
     */
    public City(Context context, Address address, List<Airport> airports, int population,
                String description, String history, String timeZone, String currency,
                List<Hotel> hotels, List<RestaurantBar> restaurantBars, List<Attraction> attractions,
                List<Event> events, List<Tour> tours, String imageFileName, List<Transport> transport) {
        this.context = context;
        this.address = address;
        this.airports = airports;
        this.population = population;
        this.description = description;
        this.history = history;
        this.hotels = hotels;
        this.timeZone = timeZone;
        this.currency = currency;
        this.restaurantBars = restaurantBars;
        this.attractions = attractions;
        this.events = events;
        this.tours = tours;
        this.imageResourceID = context.getResources().getIdentifier(imageFileName, "drawable", context.getPackageName());
        this.transport = transport;
        this.name = address.getLocality();
        this.country = address.getCountryName();
        String lang = address.getLocale().getLanguage();
        this.language = lang.substring(0,1).toUpperCase() + lang.substring(1);
    }
    //endregion

    //region Getters & Setters & toStrings
    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get airports airport [ ].
     *
     * @return the airport [ ]
     */
    public List<Airport> getAirports() {
        return airports;
    }

    /**
     * Gets population.
     *
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets history.
     *
     * @return the history
     */
    public String getHistory() {
        return history;
    }

    /**
     * Gets language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets time zone.
     *
     * @return the time zone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * Sets time zone.
     *
     * @param timeZone the time zone
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
        this.name = address.getLocality();
        this.country = address.getCountryName();
        this.language = address.getLocale().getLanguage();
    }


    /**
     * Sets airports.
     *
     * @param airports the airports
     */
    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    /**
     * Gets transport.
     *
     * @return the transport
     */
    public List<Transport> getTransport() {
        return transport;
    }

    /**
     * Sets transport.
     *
     * @param transport the transport
     */
    public void setTransport(List<Transport> transport) {
        this.transport = transport;
    }

    /**
     * Sets population.
     *
     * @param population the population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets history.
     *
     * @param history the history
     */
    public void setHistory(String history) {
        this.history = history;
    }

    /**
     * Gets hotels.
     *
     * @return the hotels
     */
    public List<Hotel> getHotels() {
        return hotels;
    }

    /**
     * Sets hotels.
     *
     * @param hotels the hotels
     */
    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    /**
     * Gets restaurant bars.
     *
     * @return the restaurant bars
     */
    public List<RestaurantBar> getRestaurantBars() {
        return restaurantBars;
    }

    /**
     * Sets restaurant bars.
     *
     * @param restaurantBars the restaurant bars
     */
    public void setRestaurantBars(List<RestaurantBar> restaurantBars) {
        this.restaurantBars = restaurantBars;
    }

    /**
     * Gets attractions.
     *
     * @return the attractions
     */
    public List<Attraction> getAttractions() {
        return attractions;
    }

    /**
     * Sets attractions.
     *
     * @param attractions the attractions
     */
    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    /**
     * Gets events.
     *
     * @return the events
     */
    public List<Event> getEvents() {
        return events;
    }

    /**
     * Sets events.
     *
     * @param events the events
     */
    public void setEvents(List<Event> events) {
        this.events = events;
    }

    /**
     * Gets tours.
     *
     * @return the tours
     */
    public List<Tour> getTours() {
        return tours;
    }

    /**
     * Sets tours.
     *
     * @param tours the tours
     */
    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    /**
     * Gets image resource id.
     *
     * @return the image resource id
     */
    public int getImageResourceID() {
        return imageResourceID;
    }

    /**
     * Sets image resource id.
     *
     * @param imageResourceID the image resource id
     */
    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    /**
     * Sets image resource id.
     *
     * @param imageFileName the image file name
     */
    public void setImageResourceID(String imageFileName) {
        this.imageResourceID = context.getResources().getIdentifier(imageFileName, "drawable", context.getPackageName());

    }
    //endregion

    //region Methods to add places to the city
    /**
     * Add hotel.
     *
     * @param hotel the hotel
     */
    public void addHotel(Hotel hotel){
        this.hotels.add(hotel);
    }

    /**
     * Add restaurant bar.
     *
     * @param restaurantBar the restaurant bar
     */
    public void addRestaurantBar(RestaurantBar restaurantBar){
        this.restaurantBars.add(restaurantBar);
    }

    /**
     * Add attraction.
     *
     * @param attraction the attraction
     */
    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }

    /**
     * Add event.
     *
     * @param event the event
     */
    public void addEvent(Event event){
        this.events.add(event);
    }

    /**
     * Add tour.
     *
     * @param tour the tour
     */
    public void addTour(Tour tour){
        this.tours.add(tour);
    }

    /**
     * Add airport.
     *
     * @param airport the airport
     */
    public void addAirport(Airport airport){
        this.airports.add(airport);
    }

    /**
     * Add transport.
     *
     * @param transport the transport
     */
    public void addTransport(Transport transport){
        this.transport.add(transport);
    }

    @Override
    public String toString() {
        return "City{" +
                "address=" + address +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", airports=" + airports.toString() +
                ", transport=" + transport.toString() +
                ", population=" + population +
                ", imageResourceID=" + imageResourceID +
                ", description='" + description + '\'' +
                ", history='" + history + '\'' +
                ", language='" + language + '\'' +
                ", time zone =' " + timeZone + '\'' +
                ", hotels=" + hotels.toString() +
                ", restaurantBars=" + restaurantBars.toString() +
                ", attractions=" + attractions.toString() +
                ", events=" + events.toString() +
                ", tours=" + tours.toString() +
                ", context=" + context +
                '}';
    }
    //endregion

    //region Parcelable methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.address, flags);
        dest.writeString(this.country);
        dest.writeString(this.name);
        dest.writeList(this.airports);
        dest.writeList(this.transport);
        dest.writeInt(this.population);
        dest.writeInt(this.imageResourceID);
        dest.writeString(this.description);
        dest.writeString(this.history);
        dest.writeString(this.language);
        dest.writeString(this.timeZone);
        dest.writeList(this.hotels);
        dest.writeList(this.restaurantBars);
        dest.writeList(this.attractions);
        dest.writeList(this.events);
        dest.writeList(this.tours);
    }

    protected City(Parcel in) {
        this.address = in.readParcelable(Address.class.getClassLoader());
        this.country = in.readString();
        this.name = in.readString();
        this.airports = new ArrayList<>();
        in.readList(this.airports, Airport.class.getClassLoader());
        this.transport = new ArrayList<>();
        in.readList(this.transport, Transport.class.getClassLoader());
        this.population = in.readInt();
        this.imageResourceID = in.readInt();
        this.description = in.readString();
        this.history = in.readString();
        this.language = in.readString();
        this.timeZone = in.readString();
        this.hotels = new ArrayList<>();
        in.readList(this.hotels, Hotel.class.getClassLoader());
        this.restaurantBars = new ArrayList<>();
        in.readList(this.restaurantBars, RestaurantBar.class.getClassLoader());
        this.attractions = new ArrayList<>();
        in.readList(this.attractions, Attraction.class.getClassLoader());
        this.events = new ArrayList<>();
        in.readList(this.events, Event.class.getClassLoader());
        this.tours = new ArrayList<>();
        in.readList(this.tours, Tour.class.getClassLoader());
        this.context = in.readParcelable(Context.class.getClassLoader());
    }

    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
    //endregion
}

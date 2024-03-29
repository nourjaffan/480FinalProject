package Database;
import java.util.Vector;

public class DatabaseSingleton {
    private static DatabaseSingleton onlyInstance;
    private AccessDatabase access;
    private DatabaseSingleton(){
        access = new AccessDatabase("jdbc:mysql://localhost:3306/db", "test", "password");
    }

    public static DatabaseSingleton getOnlyInstance(){
        if(onlyInstance == null){
            onlyInstance = new DatabaseSingleton();
        }
        return onlyInstance;
    }

    public static void setOnlyInstance(DatabaseSingleton onlyInstace){
        DatabaseSingleton.onlyInstance = onlyInstace;
    }
//  All user methods
    public boolean getSpecificUser(String email, String password){
        access.initializeConnection();
        boolean tmp = access.getSpecificUser(email, password);
        access.dbConnectClose();
        return tmp;
    }
    public boolean getSpecificUser(String email){
        access.initializeConnection();
        boolean tmp = access.getSpecificUser(email);
        access.dbConnectClose();
        return tmp;
    }
    public String getSpecificUserString(String email){
        access.initializeConnection();
        String tmp = access.getSpecificUserString(email);
        access.dbConnectClose();
        return tmp;
    }
    public void addNewUser(String name, String address, String cardInfo, String billingName, String billingAddress, String email, String password, String phoneNumber){
        access.initializeConnection();
        access.addNewUser(name, address, cardInfo, billingName, billingAddress, email, password, phoneNumber);
        access.dbConnectClose();
    }
//  All movie methods
    public void addNewMovie(String title, String genre, String length, String releaseTime, int day, int month, int year){
        access.initializeConnection();
        access.addNewMovie(title, genre, length, releaseTime, day, month, year);
        access.dbConnectClose();
    }
    public boolean getSpecificMovie(String movieName){
        access.initializeConnection();
        boolean specificMovie = access.getSpecificMovie(movieName);
        access.dbConnectClose();
        return specificMovie;
    }
    public String getSpecificStringMovie(String movieName){
        access.initializeConnection();
        String tmp = access.getSpecificStringMovie(movieName);
        access.dbConnectClose();
        return tmp;
    }
//  All ticket methods
    public int addNewTicket(int seatNum, String showTime, String title, double cost, int day, int month, int year, String email){
        access.initializeConnection();
        int lastVal = access.addNewTicket(seatNum, showTime, title, cost, day, month, year, email);
        access.dbConnectClose();
        return lastVal;
    }
    public String getSpecificTicket(int unique, String email){
        access.initializeConnection();
        String specificTicket = access.getSpecificTicket(unique, email);
        access.dbConnectClose();
        return specificTicket;
    }
    public void removeSpecificTicket(String unique){
        access.initializeConnection();
        access.removeSpecificTicket(unique);
        access.dbConnectClose();
    }
//  All showtime methods
    public void addNewShowTime(String title, String showTime, int day, int month, int year, int amountOfSeats){
        access.initializeConnection();
        access.addNewShowTime(title, showTime, day, month, year, amountOfSeats);
        access.dbConnectClose();
    }
    public String getSpecificShowTime(String title, String showTime, int day, int month, int year){
        access.initializeConnection();
        String specificShowTime = access.getSpecificShowTime(title, showTime, day, month, year);
        access.dbConnectClose();
        return specificShowTime;
    }
    public String getAllShowTimes(String title){
        access.initializeConnection();
        String allShowTime = access.getAllShowTimes(title);
        access.dbConnectClose();
        return allShowTime;
    }
//  All news methods
    public void addNewNews(String news, int day, int month, int year){
        access.initializeConnection();
        access.addNewNews(news, day, month, year);
        access.dbConnectClose();
    }
    public Vector<String> getAllNews(){
        access.initializeConnection();
        Vector<String> allNews = access.getAllNews();
        access.dbConnectClose();
        return allNews;
    }
    public String getSpecificNews(String title){
        access.initializeConnection();
        String tmp = access.getSpecificNews(title);
        access.dbConnectClose();
        return tmp;
    }
//  All seat methods
    public boolean getSpecificSeat(String title, int seatNumber, String showTime, int day, int month, int year){
        access.initializeConnection();
        boolean available = access.getSpecificSeat(title, seatNumber, showTime, day, month, year);
        access.dbConnectClose();
        return available;
    }
    public void setSpecificSeat(String title, int seatNumber, String showTime, int day, int month, int year, int boolVal){
        access.initializeConnection();
        access.setSpecificSeat(title, seatNumber, showTime, day, month, year, boolVal);
        access.dbConnectClose();
    }
}

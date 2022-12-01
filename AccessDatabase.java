import java.sql.*;

public class AccessDatabase {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;
/*
    private int totalFoodItems;

    public int getTotalFoodItems(){
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM " + "available_food");
            while(results.next()){
                if(results.isLast()){
                    this.totalFoodItems = results.getInt("ItemID");
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        return this.totalFoodItems;
    }
*/
    public String getSpecificFood(int itemID){
        StringBuffer full = new StringBuffer();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "available_food");
            while(results.next()){
                if(results.getInt("ItemID") == itemID){
                    full.append(results.getString("Name") + "/" + results.getString("GrainContent") + "/"
                            + results.getString("FVContent") + "/" + results.getString("ProContent") + "/"
                            + results.getString("Other") + "/" + results.getString("Calories"));
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }

        return full.toString();
    }
    public boolean getSpecificUser(String email, String password){
        boolean isRegistered = false;
        try {

            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "account");
            while(results.next()){
                if(results.getString("Email") == email && results.getString("Password") == password){
                    isRegistered = true;
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        return isRegistered;
    }
    public void addNewUser(String name, String address, int cardInfo, String billingName, String billingAddress, String email, String password, int phoneNumber, int billingPhoneNumber){
        
        try {
            
            Statement myStmt = dbConnect.createStatement();
            String tmp = String.format("INSERT INTO account " + "VALUES (%s, %s, %s, %d, %s, %s, %s, %s, %d, %d)", 
                name, address, cardInfo, billingAddress, email, password, phoneNumber, billingPhoneNumber);
            myStmt.executeUpdate(tmp);
            
            myStmt.close();
        }catch(SQLException e){

        }
        
    }

    public void addNewMovie(String title, String genre, String length, String releaseTime){
        
        try {
            
            Statement myStmt = dbConnect.createStatement();
            
            String tmp = String.format("INSERT INTO movie " + "VALUES ('%s', '%s', '%s', '%s')", 
                title, genre, length, releaseTime);
                
            myStmt.executeUpdate(tmp);
            myStmt.close();
        }catch(SQLException e){

        }
        
    }
    public String getSpecificMovie(String movieName){
        StringBuffer full = new StringBuffer();
        try {
            
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "movie");
            
            while(results.next()){
                if(results.getString("Title").equals(movieName)){
                    
                    full.append(results.getString("Title") + " the genres are " + results.getString("Genre") + ". The length of movie is " + 
                    results.getString("Length") + " and it releases on " + results.getString("ReleaseTime"));
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        return full.toString();
    }
    public void addNewTicket(int seatNum, String showTime, String title, float cost, int day, int month, int year, int unique){
        
        try {
            
            Statement myStmt = dbConnect.createStatement();
            
            String tmp = String.format("INSERT INTO ticket " + "VALUES (%d, '%s', '%s', %f, %d, %d, %d, %d)", 
                seatNum, showTime, title, cost, day, month, year, unique);
            myStmt.executeUpdate(tmp);
            myStmt.close();
        }catch(SQLException e){

        }
        
    }

    public String getSpecificTicket(String title, int unique){
        StringBuffer full = new StringBuffer();
        try {
            
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "ticket");
            
            while(results.next()){
                
                if(results.getString("Title").equals(title) && results.getInt("UniqueTicket") == unique){
                    full.append("The seat sumber is: " + results.getInt("SeatNumber") + " for the movie " + results.getString("Title") + " on " 
                    + results.getInt("Day") + "/" + results.getInt("Month") + "/" + results.getInt("Year") + ".");
                    
                }
            }
            myStmt.close();
            
        }catch(SQLException e){

        }
        return full.toString();
    }

    public void addNewShowTime(String title, String showTime, int day, int month, int year){
        try {
            
            Statement myStmt = dbConnect.createStatement();
            
            String tmp = String.format("INSERT INTO showtimes " + "VALUES ('%s', '%s', %d, %d, %d)", 
                title, showTime, day, month, year);
            myStmt.executeUpdate(tmp);
            myStmt.close();
        }catch(SQLException e){

        }
    }

    public String getSpecificShowTime(String title, String showTime, int day, int month, int year){
        StringBuffer full = new StringBuffer();
        try {
            
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "showtimes");
            
            while(results.next()){
                
                if(results.getString("Title").equals(title) && results.getString("ShowTime").equals(showTime) &&
                    results.getInt("Day") == day && results.getInt("Month") == month && results.getInt("Year") == year){
                    full.append("The show time is: " + results.getInt("Day") + "/" + results.getInt("Month") + "/" + results.getInt("Year")
                    + " at " + results.getString("ShowTime") + " for the movie " + results.getString("Title") + ".");
                    
                }
            }
            myStmt.close();
            
        }catch(SQLException e){

        }
        return full.toString();
    }
    public String getAllShowTimes(String title){
        StringBuffer full = new StringBuffer();
        try {
            
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "showtimes");
            
            while(results.next()){
                
                if(results.getString("Title").equals(title)){
                    full.append("The show time is: " + results.getInt("Day") + "/" + results.getInt("Month") + "/" + results.getInt("Year")
                    + " at " + results.getString("ShowTime") + " for the movie " + results.getString("Title") + ".\n");
                    
                }
            }
            myStmt.close();
            
        }catch(SQLException e){

        }
        
        return full.toString().strip();
    }
    /* 
    public void deleteAvailableFood(String id){
        try {
            String query = "DELETE FROM available_food WHERE ItemID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1,id);
            myStmt.executeUpdate();
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    */
    public void dbConnectClose(){
        try {
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public AccessDatabase(String url, String user, String pw){

        // Database URL
        this.DBURL = url;

        //  Database credentials
        this.USERNAME = user;
        this.PASSWORD = pw;
    }


    //Must create a connection to the database, no arguments, no return value
    public void initializeConnection(){
        try {
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    String getDburl(){
        return this.DBURL;
    }

    String getUsername(){
        return this.USERNAME;
    }

    String getPassword(){
        return this.PASSWORD;
    }

/*
    public String selectAllAvailableFood(){

        StringBuffer full = new StringBuffer();
        try {

            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM " + "available_food");

            while(results.next()){

                full.append(results.getString("ItemID") + ", "  + results.getString("Name"));
                full.append("\n");
            }
            full.deleteCharAt(full.length() - 1);
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return full.toString();
    }
    public String selectAllDailyClientNeeds(){

        StringBuffer full = new StringBuffer();
        try {

            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM " + "daily_client_needs");

            while(results.next()){

                full.append(results.getString("ClientID") + ", "  + results.getString("Client"));
                full.append("\n");
            }
            full.deleteCharAt(full.length() - 1);
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return full.toString();
    }
*/
    public void close() {

        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

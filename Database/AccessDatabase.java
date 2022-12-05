package Database;
import java.sql.*;
import java.time.LocalDate;
import java.util.Vector;


public class AccessDatabase {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;

    public boolean getSpecificUser(String email, String password){
        boolean isRegistered = false;
        try {

            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "account");
            while(results.next()){
                if(results.getString("Email").equals(email) && results.getString("Password").equals(password)){
                    isRegistered = true;
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        return isRegistered;
    }
    public boolean getSpecificUser(String email){
        boolean isRegistered = false;
        try {

            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "account");
            while(results.next()){
                if(results.getString("Email").equals(email)){
                    isRegistered = true;
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        return isRegistered;
    }
    public String getSpecificUserString(String email){
        StringBuffer full = new StringBuffer();
        try {
            
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "account");
            
            while(results.next()){
                
                if(results.getString("email").equals(email)){

                        full.append(results.getString("Name") + "/" + results.getString("Email") + "/" + results.getString("Password"));

                }
            }
            myStmt.close();
            
        }catch(SQLException e){

        }
        return full.toString();
    }
    public void addNewUser(String name, String address, String cardInfo, String billingName, String billingAddress, String email, String password, String phoneNumber){
        
        try {
            
            Statement myStmt = dbConnect.createStatement();
            String tmp = String.format("INSERT INTO account " + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
                name, address, cardInfo, billingName, billingAddress, email, password, phoneNumber);
                
            myStmt.executeUpdate(tmp);
            
            myStmt.close();
        }catch(SQLException e){

        }
        
    }

    public void addNewMovie(String title, String genre, String length, String releaseTime, int day, int month, int year){
        
        try {
            
            Statement myStmt = dbConnect.createStatement();
            
            String tmp = String.format("INSERT INTO movie " + "VALUES ('%s', '%s', '%s', '%s', %d, %d, %d)", 
                title, genre, length, releaseTime, day, month, year);
                
            myStmt.executeUpdate(tmp);
            myStmt.close();
        }catch(SQLException e){

        }
        
    }
    public boolean getSpecificMovie(String movieName){
        boolean isThere = false;
        try {
            
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "movie");
            
            while(results.next()){
                if(results.getString("Title").equals(movieName)){
                    
                    isThere = true;
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        return isThere;
    }
    public String getSpecificStringMovie(String movieName){
        StringBuffer full = new StringBuffer();
        try {
            
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "movie");
            
            while(results.next()){
                if(results.getString("Title").equals(movieName)){
                    
                    full.append(results.getString("Title") + "/" + results.getString("Genre") + "/" + results.getString("Length") + "/" +
                    results.getString("ReleaseTime") + "/" + results.getInt("Day") + "/" + results.getInt("Month") + "/" + results.getInt("Year"));
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        return full.toString();
    }
    public int addNewTicket(int seatNum, String showTime, String title, double cost, int day, int month, int year, String email){
        int lastIDVal = 0;
        try {
            

            String query = "INSERT INTO ticket VALUES (?, ?, ?, ?, ?, ?, ?, ?, NULL)";
            PreparedStatement myStmts = dbConnect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            myStmts.setInt(1,seatNum);
            myStmts.setString(2, showTime);
            myStmts.setString(3, title);
            myStmts.setDouble(4, cost);
            myStmts.setInt(5,day);
            myStmts.setInt(6,month);
            myStmts.setInt(7, year);
            myStmts.setString(8,email);
            myStmts.executeUpdate();

            PreparedStatement ps =  dbConnect.prepareStatement("SELECT last_insert_id() FROM ticket");
            ResultSet rs = ps.executeQuery();
            rs.next();
            lastIDVal = Integer.valueOf(rs.getString(1));
            myStmts.close();
        }catch(SQLException e){

        }
        return lastIDVal;
        
    }

    public String getSpecificTicket(int unique, String email){
        StringBuffer full = new StringBuffer();
        try {
            
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "ticket");
            
            while(results.next()){
                
                if(results.getInt("UniqueTicket") == unique && results.getString("Email").equals(email)){

                        boolean registered = false;
                        full.append(results.getDouble("Cost")+ "/" + results.getInt("SeatNumber") + "/" + results.getString("Title") + "/" 
                        + results.getInt("Day") + "/" + results.getInt("Month") + "/" + results.getInt("Year") + "/" + results.getString("Email") + "/"
                        + results.getInt("UniqueTicket") + "/" + results.getString("ShowTime") + "/");
                        
                        ResultSet checkRegistered = myStmt.executeQuery("SELECT * FROM " + "account");
                        while(checkRegistered.next()){
                            
                            if(checkRegistered.getString("Email").equals(email)){
                                registered = true;
                                break;
                            }
                        }
                        
                        checkRegistered.close();
                        full.append(registered);

                }
            }
            myStmt.close();
            
        }catch(SQLException e){

        }
        return full.toString();
    }

    public void removeSpecificTicket(String unique){
        try {
            String query = "DELETE FROM ticket WHERE UniqueTicket = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1,unique);
            myStmt.executeUpdate();
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewShowTime(String title, String showTime, int day, int month, int year, int amountOfSeats){
        try {
            
            Statement myStmt = dbConnect.createStatement();
            
            String tmp = String.format("INSERT INTO showtimes " + "VALUES ('%s', '%s', %d, %d, %d)", 
                title, showTime, day, month, year);
            for(int i = 1; i <= amountOfSeats; i++){
                addSeats(title, i, showTime, day, month, year);
            }
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
                    full.append(results.getInt("Day") + "/" + results.getInt("Month") + "/" + results.getInt("Year")
                    + "/" + results.getString("ShowTime") + "/" + results.getString("Title"));
                    
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
                int counter = getAllAvailableSeats(results.getString("Title"), results.getString("ShowTime"), results.getInt("Day"),
                results.getInt("Month"), results.getInt("Year"), 40);
                LocalDate theDate = LocalDate.of(results.getInt("Year"), results.getInt("Month"), results.getInt("Day"));
                
                if(counter == 0 || theDate.isBefore(LocalDate.now())){
                   
                    removeSpecificShowtime(results.getString("Title"), results.getString("ShowTime"), results.getInt("Day"),
                                           results.getInt("Month"), results.getInt("Year"));
                    removeSpecificSeats(results.getString("Title"), results.getString("ShowTime"), results.getInt("Day"),
                                        results.getInt("Month"), results.getInt("Year"));
                    
                }else if(results.getString("Title").equals(title)){
                    full.append(results.getInt("Day") + "/" + results.getInt("Month") + "/" + results.getInt("Year")
                    + "/" + results.getString("ShowTime") + "/" + results.getString("Title") + "\n");
                    
                }
            }
            myStmt.close();
            
        }catch(SQLException e){

        }
        
        return full.toString().strip();
    }
    public void removeSpecificShowtime(String title, String showTime, int day, int month, int year){
        try {
            String query = "DELETE FROM showtimes WHERE Title = ? AND ShowTime = ? AND Day = ? AND Month = ? AND Year = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1,title);
            myStmt.setString(2, showTime);
            myStmt.setInt(3, day);
            myStmt.setInt(4, month);
            myStmt.setInt(5, year);
            myStmt.executeUpdate();
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addNewNews(String news, int day, int month, int year){
        try {
            
            Statement myStmt = dbConnect.createStatement();
            
            String tmp = String.format("INSERT INTO news " + "VALUES ('%s', %d, %d, %d)", 
                news, day, month, year);
            myStmt.executeUpdate(tmp);
            myStmt.close();
        }catch(SQLException e){

        }
    }

    public Vector<String> getAllNews(){
        Vector<String> full = new Vector<String>();
        LocalDate theDate = java.time.LocalDate.now();
        try {
            
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "news");
            
            while(results.next()){
                LocalDate tmpDate = LocalDate.of(results.getInt("Year"), results.getInt("Month"), results.getInt("Day"));
                if(tmpDate.isAfter(theDate)){ 
                    full.add(results.getString("Title") + "/" + tmpDate.toString());
                }else{
                    deleteNews(results.getString("Title"), tmpDate);
                }
            }
            myStmt.close();
            
        }catch(SQLException e){
 
        }
        
        return full;
    }

    public void deleteNews(String title, LocalDate date){
        try {
            String query = "DELETE FROM news WHERE Title = ? AND Day = ? AND Month = ? AND Year = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1,title);
            myStmt.setInt(2, date.getDayOfMonth());
            myStmt.setInt(3, date.getMonthValue());
            myStmt.setInt(4, date.getYear());
            myStmt.executeUpdate();
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getSpecificNews(String title){
        StringBuffer full = new StringBuffer();
        try {
            
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "news");
            
            while(results.next()){
                if(results.getString("Title").equals(title)){
                    
                    full.append(results.getString("News") + "/" + results.getInt("Day") + "/" + results.getInt("Month") + "/" + results.getInt("Year"));
                }
            }
            myStmt.close();
            
        }catch(SQLException e){
 
        }
        
        return full.toString();
    }

    public void addSeats(String title, int seatNumber, String showTime, int day, int month, int year){
        try{
            Statement myStmt = dbConnect.createStatement();
                
            String tmp = String.format("INSERT INTO seat " + "VALUES ('%s', 1, %d, '%s', %d, %d, %d)", 
                title, seatNumber, showTime, day, month, year);
            myStmt.executeUpdate(tmp);
            myStmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public boolean getSpecificSeat(String title, int seatNumber, String showTime, int day, int month, int year){
        boolean available = true;
        try {
            
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "seat");
            
            while(results.next()){
                if(results.getString("Title").equals(title) && results.getInt("SeatNumber") == seatNumber 
                && results.getString("ShowTime").equals(showTime) && results.getInt("Day") == day && results.getInt("Month") == month
                && results.getInt("Year") == year){
                    
                    available = results.getBoolean("Vacant");
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        
        return available;
    }
    public int getAllAvailableSeats(String title, String showTime, int day, int month, int year, int seatCount){
        int available = seatCount;
        try {
            
            Statement myStmt = dbConnect.createStatement();
            ResultSet theResult = myStmt.executeQuery("SELECT * FROM " + "seat");
            
            while(theResult.next()){
                if(theResult.getString("Title").equals(title)&& theResult.getString("ShowTime").equals(showTime) && 
                theResult.getInt("Day") == day && theResult.getInt("Month") == month
                && theResult.getInt("Year") == year){
                    if(!theResult.getBoolean("Vacant")){
                        available--;
                    }
                    
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        
        return available;
    }
    public void setSpecificSeat(String title, int seatNumber, String showTime, int day, int month, int year, int boolVal){
        try{
            String query = "UPDATE Seat SET Vacant = ? WHERE Title=? AND SeatNumber=? AND ShowTime=? AND Day=? AND Month=? AND Year=?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, String.valueOf(boolVal));
            myStmt.setString(2,title);
            myStmt.setString(3, String.valueOf(seatNumber));
            myStmt.setString(4,showTime);
            myStmt.setString(5, String.valueOf(day));
            myStmt.setString(6, String.valueOf(month));
            myStmt.setString(7, String.valueOf(year));
            myStmt.executeUpdate();
            myStmt.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void removeSpecificSeats(String title, String showTime, int day, int month, int year){
        try {
            String query = "DELETE FROM seat WHERE Title = ? AND ShowTime = ? AND Day = ? AND Month = ? AND Year = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1,title);
            myStmt.setString(2,showTime);
            myStmt.setInt(3, day);
            myStmt.setInt(4, month);
            myStmt.setInt(5, year);
            myStmt.executeUpdate();
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
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

    public void close() {

        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

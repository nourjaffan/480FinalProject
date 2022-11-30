import java.sql.*;

public class AccessDatabase {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;

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
    public boolean addNewUser(String name, String address, int cardInfo, String billingName, String billingAddress, String email, String password, int phoneNumber, int billingPhoneNumber){
        boolean isRegistered = false;
        try {
            if(getSpecificUser(email, password)){
                return false;
            }
            Statement myStmt = dbConnect.createStatement();
            String tmp = String.format("INSERT INTO account " + "VALUES (%s, %s, %s, %d, %s, %s, %s, %s, %d, %d)", 
                name, address, cardInfo, billingAddress, email, password, phoneNumber, billingPhoneNumber);
            myStmt.executeUpdate(tmp);
            
            myStmt.close();
        }catch(SQLException e){

        }
        return isRegistered;
    }
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

    public void close() {

        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

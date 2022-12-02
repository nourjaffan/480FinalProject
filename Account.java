import java.time.LocalDate;  
import java.util.*;
public class Account
{
    private boolean registered = false;
    private String email;
    private String password;
    private double credit = 0;

    static AccessDatabase access = new AccessDatabase("jdbc:mysql://localhost:3306/db", "test", "password");
    
    
    
    public void Register(String address, String name, String email, String password, String phoneNumber, String cardNumber, String cardName, 
                         String billingName, String billingAddress, String billingPhoneNumber)
    {
        access.initializeConnection();
        this.email = email;
        this.password = password;
      access.addNewUser(name, address, cardNumber, billingName, billingAddress, email, password, phoneNumber, billingPhoneNumber);
      this.registered = true;
      //pay 20 dollar fee
    }
    public void login(String email, String password) throws Exception{
        access.initializeConnection();
        if(access.getSpecificUser(email, password)){
            registered = true;
        }else{
            throw new Exception("The email or the password is wrong");
        }
    }

    public boolean isRegistered(){
        access.initializeConnection();
        if(access.getSpecificUser(email, password) == true){
            access.dbConnectClose();
            return true;
        }else{
            access.dbConnectClose();
            return false;
        }
        
    }

    public void addTicket(Ticket ticket){
        access.initializeConnection();
        access.addNewTicket(ticket.getSeatNum(), ticket.getShowTime(), ticket.getTitle(), ticket.getCost(), ticket.getDay(), ticket.getMonth(), ticket.getYear(),
                            ticket.getUniqueTicket(), email);
        access.dbConnectClose();
    }
    public void addTicket(Ticket ticket, String guestEmail){
        access.initializeConnection();
        access.addNewTicket(ticket.getSeatNum(), ticket.getShowTime(), ticket.getTitle(), ticket.getCost(), ticket.getDay(), ticket.getMonth(), ticket.getYear(),
                            ticket.getUniqueTicket(), guestEmail);
        access.dbConnectClose();
    }
    public void cancelTheTicket(int uniqueTicket, String email){
        access.initializeConnection();
        if(access.getSpecificTicket(uniqueTicket, email) == null){  //If there is no ticket found in database return nothing there
            access.dbConnectClose();
            return;
        }
        LocalDate time = java.time.LocalDate.now();
        Float cost = (float) 0;
        String[] tmp = access.getSpecificTicket(uniqueTicket, email).split("/");
        LocalDate ticket = LocalDate.of(Integer.parseInt(tmp[4]), Integer.parseInt(tmp[3]), Integer.parseInt(tmp[2]));
        String compare = time.until(ticket).toString();
        Integer date = Integer.parseInt(compare.substring(1, compare.length()-1));
        if(date > 3){
            
            cost = Float.parseFloat(tmp[0]);
            access.removeSpecificTicket(Integer.toString(uniqueTicket));    
            
        }else{
            return;
        }
        if(tmp[5].equals("False")){
            //Guest user
            double fee = cost * 0.15;
            credit -= cost - fee;
            //pay fee
        }else{
            //Registered user does not have to pay fee
            credit -= cost;
        }
        access.dbConnectClose();
    }

   

    public void displayMovieNews(){
        if(this.registered == true){
            //display movie news
        }else{
            //display that the user is not registered
        }
    }
    
    public String getPhone()
    {
    
    }
}
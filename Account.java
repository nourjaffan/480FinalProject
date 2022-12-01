import java.time.LocalDate;  
import java.util.*;
public class Account
{
    private boolean registered = false;
    private double credit;
    private String movieNews;

    private String address;
    private String name;
    private String email;
    private String password;
    private int phoneNumber;
    
    private String cardNumber;
    private String cardName;
    
    private String billingName;
    private String billingAddress;
    private int billingPhoneNumber;

    private ArrayList<Ticket> tickets;

    public Account(String address, String name, String email, String password, int phoneNumber){
        this.address = address;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    
    
    public void Register(String cardNumber, String cardName, String billingName, String billingAddress, int billingPhoneNumber)
    {
      this.cardNumber = cardNumber;
      this.cardName = cardName;
      this.billingName = billingName;
      this.billingAddress = billingAddress;
      this.billingPhoneNumber = billingPhoneNumber;
      this.registered = true;
      //pay 20 dollar fee
    }

    public boolean isRegistered(){
        if(this.registered == true){
            return true;
        }else{
            return false;
        }
    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public void cancelTicket(int uniqueTicket){
        LocalDate time = java.time.LocalDate.now();
        int originalSize = this.tickets.size(); 
        double cost = 0;
        for(int i = 0; i < this.tickets.size(); i++){
            if(this.tickets.get(i).getUniqueTicket() == uniqueTicket){
                LocalDate ticket = LocalDate.of(this.tickets.get(i).getYear(), this.tickets.get(i).getMonth(), this.tickets.get(i).getDay());
                String compare = time.until(ticket).toString();
                Integer date = Integer.parseInt(compare.substring(1, compare.length()-1));
                if(date > 3){
                    cost = this.tickets.get(i).getCost();
                    this.tickets.remove(i);
                }else{
                    //display ticket cannot be cancelled as movie is within 3 days
                    return;
                }
            }
        }
        if(originalSize == this.tickets.size()){
            //Display Ticket Not found to GUI
        }else{
            //Display Ticket found
            if(this.registered == false){
                double fee = cost * 0.15;
                // pay fee
            }
            this.credit = cost;
        }
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

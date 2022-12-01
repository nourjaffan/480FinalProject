import java.util.*;
public class Account
{
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
    
    
    public Account(String address, String name, String email, String password, int phoneNumber, String cardNumber, String cardName, String billingName, String billingAddress, int billingPhoneNumber)
    {
      this.address = address;
      this.name = name;
      this.email = email;
      this.password = password;
      this.phoneNumber = phoneNumber;
      this.cardNumber = cardNumber;
      this.cardName = cardName;
      this.billingName = billingName;
      this.billingAddress = billingAddress;
      this.billingPhoneNumber = billingPhoneNumber;
    }
    
    
    //getters need some work
    
    public String getUser()
    {
    return address;
    return name;
    //return phoneNumber;
    }
    
    public String getPhone()
    {
    
    }
}

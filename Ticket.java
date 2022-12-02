public class Ticket{

    private int seatNum;
    private string showTime;
    private string title;
    private double cost;
    private int day;
    private int month;
    private int year;
    private int uniqueTicket;

    public Ticket(int seatNum, string showTime, string title, 
                    double cost, int day, int month, int year, int uniqueTicket){
        
        this.seatNum = seatNum;
        this.showTime = showTime;
        this.title = title;
        this.cost = cost;
        this.day = day;
        this.month = month;
        this.year = year;
        this.uniqueTicket = uniqueTicket;
    }

    public int getSeatNum(){
        return this.seatNum;
    }
    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }
    public string getShowTime(){
        return this.showTime;
    }
    public string getTitle(){
        return this.title;
    }
    public float getCost(){
        return this.cost;
    }
    public int getUniqueTicket(){
        return this.uniqueTicket;
    }
}

public class ticketReciept
{
  private int uniqueNumber;
  
  public ticketReciept(int number)
  {
    uniqueNumber = number;
  }
  
  public int getTicketReciept()
  {
    return uniqueNumber;
  }
}

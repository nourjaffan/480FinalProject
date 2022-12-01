public class Ticket{

    private int seatNum;
    private String showTime;
    private String title;
    private float cost;
    private String date;
    private int uniqueTicket;

    public Ticket(int seatNum, String showTime, String title, 
                    float cost, String date, int uniqueTicket){
        
        this.seatNum = seatNum;
        this.showTime = showTime;
        this.title = title;
        this.cost = cost;
        this.date = date;
        this.uniqueTicket = uniqueTicket;
    }

    public int getSeatNum(){
        return this.seatNum;
    }
    public String getShowTime(){
        return this.showTime;
    }
    public String getTitle(){
        return this.title;
    }
    public float getCost(){
        return this.cost;
    }
    public String getDate(){
        return this.date;
    }
    public int getUniqueTicket(){
        return this.uniqueTicket;
    }
}

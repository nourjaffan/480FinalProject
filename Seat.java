public class Seat
{
  private String title;
  private boolean vacant;
  private int seatNumber;
  private String showTime;
  
  private DatabaseSingleton access = DatabaseSingleton.getOnlyInstance();
  
  public Seat(String title, bool vacant, int seatNumber, String showTime)
  {
    this.title = title;
    this.vacant = vacant;
    this.seatNumber = seatNumber;
    this.showTime = showTime;
  }
  
  public int getSeatNumber()
  {
    return seatNumber;
  }
  
  public String getShowTime()
  {
    return showTime;
  }
  
  public String getTitle()
  {
    return title;
  }
  
  public boolean getVacant()
  {
    return vacant;
  }
  
  public void isSeatAvailable(Seat seat)
  {
    access.getSpecificSeat(seat.getTitle(), seat.getSeatNumber(), seat.getShowTime());
  }
  
}

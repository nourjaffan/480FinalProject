import java.util.ArrayList;

public class Select{

    private String title;

    private String showTime;
    private int day;
    private int month;
    private int year;

    private int seatNum;

    private Account account;

    private boolean regMovieFlag;

    private static int uniqueTicket = 0;

    private AccessDatabase access = new AccessDatabase("jdbc:mysql://localhost:3306/db", "test", "password");
    public Select(Account account){
        access.initializeConnection();
        this.account = account;
        this.title = selectTitle();
        this.showTime = selectShowTime();
        this.seatNum = selectSeatNum();

        uniqueTicket++;

        Ticket ticket = new Ticket(this.seatNum, this.showTime, this.title, 15.0, this.day, this.month, this.year, uniqueTicket);
        // BookTicket(ticket); simulate paying
        access.addNewTicket(seatNum, title, seatNum, uniqueTicket);
        account.addTicket(ticket);
        // sendReciept(ticket.getTicketReciept());
        access.dbConnectClose();
    }

    private String selectTitle(){
        if(this.account.isRegistered()){
            /*
            Display Movies playing at selected theater as well as movies not announced
            take user input
            check if movie is playing there
            if(movie has been announced){
                this.regMovieFlag = true;
            }
            return movie name
            */
        }else{
        /*
        Display Movies playing at selected theater
        take user input
        check if movie is playing there
        return movie name
        */ 
        }
    }

    private String selectShowTime(){
        /*
        Display selected Movies showtimes at selected theater
        take user input
        check if Showtime is available
        this.day = showtime.day
        this.month = showtime.month
        this.year = showtime.year
        return showtime
        */ 
    }

    private int selectSeatNum(){
        if(this.regMovieFlag == true){
            if(/*(taken seats / total seats) < 0.1 */){
                /*
                Display seats at show time of selected movie at selected theater
                take user input
                check if seat is available
                return seat number
                */
            }else{
                //no seats availabile until public announcment
            }
        }else{
            /*
            Display seats at show time of selected movie at selected theater
            take user input
            check if seat is available
            return seat number
            */
        } 
    }

}

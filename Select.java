import java.util.ArrayList;

public class Select{

    private String theater;

    private String title;

    private String showTime;

    private int seatNum;

    private Account account;

    private boolean regMovieFlag;

    private static int uniqueTicket = 0;

    private AccessDatabase access = new AccessDatabase("jdbc:mysql://localhost:3306/db", "test", "password");
    public Select(Account account){
        access.initializeConnection();
        this.account = account;
        this.theater = selectTheater();
        this.title = selectTitle();
        this.showTime = selectShowTime();
        this.seatNum = selectSeatNum();

        uniqueTicket++;

        Ticket ticket = new Ticket(this.seatNum, this.showTime, this.title, this.seatNum, this.theater, uniqueTicket);
        // BookTicket(ticket); simulate paying
        access.addNewTicket(seatNum, title, seatNum, theater, uniqueTicket);
        account.addTicket(ticket);
        // sendReciept(ticket.getTicketReciept());
        access.dbConnectClose();
    }

    private String selectTheater(){
        /*
        display theaters
        take user input
        check if theater is in the database
        return theater name
        */
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

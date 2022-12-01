import java.util.ArrayList;

public class Select{
    private ArrayList<Ticket> allTickets;

    private String theater;

    private String title;

    private String showTime;

    private int seatNum;

    private static int uniqueTicket = 0;
    private AccessDatabase access = new AccessDatabase("jdbc:mysql://localhost:3306/db", "test", "password");
    public Select(){
        access.initializeConnection();
        this.theater = selectTheater();
        this.title = selectTitle();
        this.showTime = selectShowTime();
        this.seatNum = selectSeatNum();

        uniqueTicket++;

        Ticket ticket = new Ticket(this.seatNum, this.showTime, this.title, this.seatNum, this.theater, uniqueTicket);
        this.allTickets.add(ticket);
        access.addNewTicket(seatNum, title, seatNum, theater, uniqueTicket);
        // BookTicket(ticket);

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
        /*
        Display Movies playing at selected theater
        take user input
        check if movie is playing there
        return movie name
        */ 
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
        /*
        Display seats at show time of selected movie at selected theater
        take user input
        check if seat is available
        return seat number
        */ 
    }

    public ArrayList<Ticket> getAllTickets(){
        return this.allTickets;
    }

    public void updateAllTickets(ArrayList<Ticket> updatedTickets){
        this.allTickets = updatedTickets;
    }
}

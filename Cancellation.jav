
import java.util.ArrayList;

public class Cancellation{

    public Cancellation(int uniqueTicket){
        ArrayList<Ticket> allTickets = Select.getAllTickets();
        int originalSize = allTickets.size(); 
        for(int i = 0; i < allTickets.size(); i++){
            if(allTickets.get(i).getUniqueTicket() == uniqueTicket){
                allTickets.remove(i);
            }
        }
        if(originalSize == allTickets.size()){
            //Display Ticket Not found
        }else{
            //need to implement credit
        }

        Select.updateAllTickets(allTickets);
    }
}

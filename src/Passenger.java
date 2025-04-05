import utils.Utilities;

import java.util.Random;

public class Passenger extends Thread{
    protected String passengerName;
    protected Printer printer;
    protected String ticketName;
    protected ThreadGroup threadGroup;

    public Passenger(String name, ThreadGroup threadGroup, Printer printer) {
        super(threadGroup, name);
        this.printer = printer;
        this.passengerName=name;
        this.threadGroup=threadGroup;
    }

    @Override
    public void run() {
        for(int i=1 ; i<6 ;i++){
            ticketName = "tick_id_" + i ;

            Ticket ticket= new Ticket(this.passengerName,ticketName,generateRandomPrintCount());
            Utilities.printLogs(Utilities.ProcessLogger.PASSENGER, this.getName() + " generated Ticket to" +
                    " print: " + ticket, Utilities.ProcessLogger.INFO);

            Utilities.printLogs(Utilities.ProcessLogger.PASSENGER,"[" + this.getName() + "] has requested to" +
                    " print the ticket: " + ticket, Utilities.ProcessLogger.INFO);

            if(ticket.getNumberOfPrints()!=0)
                printer.printerTicket(ticket);
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {

                Utilities.printLogs(Utilities.ProcessLogger.PASSENGER,e.toString(),Utilities.ProcessLogger.ERROR);
            }
        }

    }

    /**
     * Generates a random print count between 1 to 20
     * @return Random page count
     */
    private int generateRandomPrintCount() {
        return new Random().nextInt(19) + 1;
    }
}


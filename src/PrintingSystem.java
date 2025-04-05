import utils.Utilities;

import utils.Utilities;

import static utils.Utilities.ProcessLogger.*;

/**
 * Represents the composite printing system, that cotains concurrent printer(resource), passengers, and technicians threads
 */
public class PrintingSystem {

    public static void main(String[] args) {

        //create Thread Groups
        Utilities.printLogs(PRINTING_SYSTEM, "Creating Thread Groups ", Utilities.ProcessLogger.INFO);
        ThreadGroup passengerGroup = new ThreadGroup("Passenger");
        Utilities.printLogs(PRINTING_SYSTEM, " Passenger Thread Group Created", Utilities.ProcessLogger.INFO);
        ThreadGroup technicianGroup = new ThreadGroup("Technician");
        Utilities.printLogs(PRINTING_SYSTEM, " Technician Thread Group Created", Utilities.ProcessLogger.INFO);

        //create PrinterMachine Resource
        PrinterTicketMachine printer = new PrinterTicketMachine("PrinterMachine 1120J", passengerGroup);
        Utilities.printLogs(PRINTING_SYSTEM, "Initialised PRINTER Resource", Utilities.ProcessLogger.INFO);

        //create 4 passenger Threads
        Passenger passenger1 = new Passenger("Tharindu", passengerGroup, printer);
        Utilities.printLogs(PRINTING_SYSTEM, "Initialised PASSENGER" + passenger1.getName(),
                Utilities.ProcessLogger.INFO);
        Passenger passenger2 = new Passenger("Sudesh", passengerGroup, printer);
        Utilities.printLogs(PRINTING_SYSTEM, "Initialised PASSENGER" + passenger2.getName(),
                Utilities.ProcessLogger.INFO);
        Passenger passenger3 = new Passenger("Pasan", passengerGroup, printer);
        Utilities.printLogs(PRINTING_SYSTEM, "Initialised PASSENGER" + passenger3.getName(),
                Utilities.ProcessLogger.INFO);
        Passenger passenger4 = new Passenger("Adithya", passengerGroup, printer);
        Utilities.printLogs(PRINTING_SYSTEM, "Initialised PASSENGER" + passenger4.getName(),
                Utilities.ProcessLogger.INFO);

        //create technician threads
        Technician paperTechnician = new PaperTechnician("Malith", technicianGroup, printer);
        Utilities.printLogs(PRINTING_SYSTEM, "Initialised " +
                PAPER_TECHNICIAN.toString().replace("_", ""), Utilities.ProcessLogger.INFO);
        Technician tonerTechnician = new TonerTechnician("Adeesha", technicianGroup, printer);
        Utilities.printLogs(PRINTING_SYSTEM, "Initialised " +
                TONER_TECHNICIAN.toString().replace("_", ""), Utilities.ProcessLogger.INFO);

        // Start all the threads
        Utilities.printLogs(PRINTING_SYSTEM, "Starting all initalised Threads", Utilities.ProcessLogger.INFO);

        passenger1.start();
        Utilities.printLogs(PRINTING_SYSTEM, "Started " + passenger1.getName() + " PASSENGER Thread",
                Utilities.ProcessLogger.INFO);

        passenger2.start();
        Utilities.printLogs(PRINTING_SYSTEM, "Started " + passenger2.getName() + " PASSENGER Thread",
                Utilities.ProcessLogger.INFO);

        passenger3.start();
        Utilities.printLogs(PRINTING_SYSTEM, "Started " + passenger3.getName() + " PASSENGER Thread",
                Utilities.ProcessLogger.INFO);

        passenger4.start();
        Utilities.printLogs(PRINTING_SYSTEM, "Started " + passenger4.getName() + " PASSENGER Thread",
                Utilities.ProcessLogger.INFO);

        paperTechnician.start();
        Utilities.printLogs(PRINTING_SYSTEM, "Started PAPER TECHNICIAN Thread", Utilities.ProcessLogger.INFO);

        Utilities.printLogs(PRINTING_SYSTEM, "Started TONER TECHNICIAN Thread", Utilities.ProcessLogger.INFO);
        tonerTechnician.start();

        try {

            passenger1.join();
            Utilities.printLogs(PRINTING_SYSTEM, "EXECUTION completed by : " + passenger1.getName(),
                    Utilities.ProcessLogger.INFO);
            passenger2.join();
            Utilities.printLogs(PRINTING_SYSTEM, "EXECUTION completed by : " + passenger2.getName(),
                    Utilities.ProcessLogger.INFO);
            passenger3.join();
            Utilities.printLogs(PRINTING_SYSTEM, "EXECUTION completed by : " + passenger3.getName(),
                    Utilities.ProcessLogger.INFO);
            passenger4.join();
            Utilities.printLogs(PRINTING_SYSTEM, "EXECUTION completed by : " + passenger4.getName(),
                    Utilities.ProcessLogger.INFO);
            paperTechnician.join();
            Utilities.printLogs(PRINTING_SYSTEM, "EXECUTION completed by : Paper Technician " +
                    paperTechnician.getTechName(), Utilities.ProcessLogger.INFO);
            tonerTechnician.join();
            Utilities.printLogs(PRINTING_SYSTEM, "EXECUTION completed by : Toner Technician " +
                    tonerTechnician.getTechName(), Utilities.ProcessLogger.INFO);

            Utilities.printLogs(PRINTING_SYSTEM, "All Tasks successfully Completed ,Total Number" +
                            " of print printed : "+ printer.getPrintedPages()+", Final Status of " + printer.toString(),
                    Utilities.ProcessLogger.INFO);

        } catch (InterruptedException e) {
            Utilities.printLogs(Utilities.ProcessLogger.PRINTER, e.toString(), Utilities.ProcessLogger.ERROR);
        }

    }

}



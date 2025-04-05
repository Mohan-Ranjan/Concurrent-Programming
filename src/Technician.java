public class Technician extends Thread {

    private String techName;
    private PrinterTicketMachine printer;
    private ThreadGroup threadGroupUser;


    public Technician(String name, ThreadGroup threadGroup, Printer printer) {
        super(threadGroup,name);
        this.threadGroupUser = threadGroup;
        this.techName = name;
        this.printer = (PrinterTicketMachine) printer;
    }

    public String getTechName() {
        return techName;
    }

    public PrinterTicketMachine getPrinter() {
        return this.printer;
    }

    public ThreadGroup getThreadGroupUser() {
        return threadGroupUser;
    }

}

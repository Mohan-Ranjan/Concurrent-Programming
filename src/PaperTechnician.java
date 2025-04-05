import utils.Utilities;

public class PaperTechnician extends Technician  {

    public PaperTechnician(String name, ThreadGroup threadGroup, Printer printer) {
        super(name, threadGroup,printer);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Utilities.printLogs(Utilities.ProcessLogger.PAPER_TECHNICIAN,"[PAPER TECHNICIAN] has requested to use" +
                    " the printer" , Utilities.ProcessLogger.INFO);

            this.getPrinter().refillPaper();

            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Utilities.printLogs(Utilities.ProcessLogger.PAPER_TECHNICIAN,e.toString(),Utilities.ProcessLogger.ERROR);
            }

        }
    }
}
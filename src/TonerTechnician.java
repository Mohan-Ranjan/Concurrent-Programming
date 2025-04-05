import utils.Utilities;

public class TonerTechnician extends Technician {

    public TonerTechnician(String name, ThreadGroup threadGroup, Printer printer) {
        super(name, threadGroup, printer);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            Utilities.printLogs(Utilities.ProcessLogger.TONER_TECHNICIAN, "[TONER TECHNICIAN] has requested to " +
                    "use the printer", Utilities.ProcessLogger.INFO);

            this.getPrinter().replaceTonerCartridge();

            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Utilities.printLogs(Utilities.ProcessLogger.TONER_TECHNICIAN, e.toString(), Utilities.ProcessLogger.ERROR);
            }

        }
    }
}

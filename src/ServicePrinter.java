public interface ServicePrinter extends Printer
{

    // from PrinterMachine:
    //    public void printTicket( Ticket ticket ) ;

    // PrinterMachine constants

    public final int Full_Paper_Tray  = 250 ;
    public final int SheetsPerPack    = 50  ;

    public final int Full_Toner_Level        = 500 ;
    public final int Minimum_Toner_Level     = 10  ;
    public final int PrintsPerTonerCartridge  = 500 ;

    // Technician methods

    public void replaceTonerCartridge( ) ;

    public void refillPaper( ) ;


} // ServicePrinter



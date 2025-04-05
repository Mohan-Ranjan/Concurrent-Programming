class Ticket
{
    private final String userID ;
    private final String ticketName ;
    private final int    numberOfPrints ;


    public Ticket( String UID, String name, int length )
    {
        this.userID        = UID ;
        this.ticketName  = name ;
        this.numberOfPrints = length ;
    }


    public String getUserID( ) {
        return userID ;
    }

    public String getTicketName( )  {
        return ticketName ;
    }

    public int    getNumberOfPrints( ) {
        return numberOfPrints ;
    }


    public String toString( )
    {
        return new String( "Ticket[ "  +
                "UserID: " + userID        + ", " +
                "Name: "   + ticketName  + ", " +
                "Prints: "  + numberOfPrints +
                "]"  ) ;
    }

} // Ticket



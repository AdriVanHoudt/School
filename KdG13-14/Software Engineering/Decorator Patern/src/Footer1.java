/**
 * User: Adri
 * Date: 14/10/13
 * Time: 19:42
 */
public class Footer1 extends TicketDecorator {
    public Footer1(Component myComponent) {
        super(myComponent);
    }

    @Override
    public void prtTicket() {
        super.callTrailer();
        System.out.println("FOOTER1");
    }
}

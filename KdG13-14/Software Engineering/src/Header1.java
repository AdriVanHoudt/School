/**
 * User: Adri
 * Date: 14/10/13
 * Time: 19:45
 */
public class Header1 extends TicketDecorator {
    public Header1(Component myComponent) {
        super(myComponent);
    }

    @Override
    public void prtTicket() {
        System.out.println("HEADER1");
        super.callTraler();
    }
}

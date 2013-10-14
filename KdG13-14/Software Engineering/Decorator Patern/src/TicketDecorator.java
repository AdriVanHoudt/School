/**
 * User: Adri
 * Date: 14/10/13
 * Time: 19:42
 */
abstract public class TicketDecorator extends Component{
    private Component myTrailer;

    protected TicketDecorator(Component myComponent) {
        this.myTrailer = myComponent;
    }

    public void callTrailer() {
        if(myTrailer != null) myTrailer.prtTicket();
    }
}

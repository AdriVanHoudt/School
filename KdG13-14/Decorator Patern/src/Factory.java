/**
 * User: Adri
 * Date: 14/10/13
 * Time: 19:37
 */
public class Factory {
    public Component getComponent(){
        Component myComponent;
        myComponent = new SalesTicket();
        myComponent = new Footer1(myComponent);
        myComponent = new Header1(myComponent);
        return myComponent;
    }
}

/**
 * User: Adri
 * Date: 14/10/13
 * Time: 19:34
 */
public class Client {
    public static void main(String[] args) {
        Factory myFactory;
        myFactory = new Factory();
        Component myComponent = myFactory.getComponent();
        myComponent.prtTicket();
    }
}


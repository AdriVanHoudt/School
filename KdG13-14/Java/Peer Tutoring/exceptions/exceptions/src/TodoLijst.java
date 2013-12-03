import java.util.Arrays;

public class TodoLijst {
    private static final int MAX_AANTAL = 10;
    private TodoItem[] items;
    private int aantal = 0;

    public TodoLijst() {
        items = new TodoItem[MAX_AANTAL];
    }

    public void add(String text, Datum deadline) throws TodoException, IllegalArgumentException {
        if (aantal == MAX_AANTAL) {
            throw new TodoException("Array zit vol");
        } else {
            items[aantal] = new TodoItem(text, deadline);
            aantal++;
            if(aantal > 1) try {
                Arrays.sort(items);
            } catch (Exception ignored) {

            }
        }
    }

    public void zetOpAfgewerkt(int index) throws TodoException {
        if (index < 0 || index > aantal || aantal == 0) {
            throw new TodoException("ni proberen");
        } else {
            items[index].setAfgewerkt(true);
            redoArray();
        }
    }

    public void printAll() {
        for (TodoItem i : items) {
            if (i == null) {
                return;
            }
            System.out.println(i.toString());
        }
    }

    public void printNietAfgewerkt() {
        int count = 0;
        for (TodoItem i : items) {
            if (i == null) {
                return;
            }
            if (!i.isAfgewerkt()) {
                System.out.println(count + ") " + i.toString());
                count++;
            }
        }
    }

    public void verwijderAfgewekteItems() {
        for (int i = 0; i <= aantal; i++) {
            if (items == null) {
                return;
            }
            if (items[i].isAfgewerkt()) {
                items[i] = null;
            }
        }
        redoArray();
    }

    public void redoArray(){
        for (int i = 0; i <= aantal; i++) {
            if (items[i] == null) {
                items[i] = items[i + 1];
                items[i + 1] = null;
                aantal--;
            }
        }
    }

}

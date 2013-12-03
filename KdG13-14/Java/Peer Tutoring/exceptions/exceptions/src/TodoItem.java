public class TodoItem implements Comparable<TodoItem> {
    private String titel;
    private Datum deadline;
    private boolean afgewerkt;

    public TodoItem(String titel, Datum deadline) throws IllegalArgumentException {
        if (titel.isEmpty() || titel.equals("") || deadline.compareTo(Datum.vandaag()) == -1) {
            throw new IllegalArgumentException("Geef een datum na vandaag in of nen titel");
        } else {
            this.titel = titel;
            setDeadline(deadline);
        }
    }

    public void setDeadline(Datum deadline) throws IllegalArgumentException {
        if (deadline.compareTo(Datum.vandaag()) == -1) {
            throw new IllegalArgumentException("Geef een datum na vandaag in");
        }
        this.deadline = deadline;
    }

    public void setAfgewerkt(boolean afgewerkt) {
        this.afgewerkt = afgewerkt;
    }

    public boolean isAfgewerkt() {
        return afgewerkt;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "titel='" + titel + '\'' +
                ", deadline=" + deadline +
                ", afgewerkt=" + afgewerkt +
                '}';
    }

    @Override
    public int compareTo(TodoItem o) {
        int temp = deadline.compareTo(o.deadline);
        return temp;
    }
}

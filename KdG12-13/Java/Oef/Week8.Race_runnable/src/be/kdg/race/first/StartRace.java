package be.kdg.race.first;

public class StartRace {
    public static void main(String[] args) {
        Thread racerEen = new Thread(new Racer(), "Peter");
        Thread racerTwee = new Thread(new Racer(), "Nasrien");

        racerEen.start();
        racerTwee.start();
    }
}

/*
Nasrien START
Peter START
Nasrien ronde 1
Peter ronde 1
Peter ronde 2
Nasrien ronde 2
Peter ronde 3
Peter ronde 4
Nasrien ronde 3
Peter ronde 5
Peter ronde 6
Nasrien ronde 4
Peter ronde 7
Peter ronde 8
Peter ronde 9
Nasrien ronde 5
Nasrien ronde 6
Nasrien ronde 7
Peter ronde 10
Peter AANGEKOMEN
Nasrien ronde 8
Nasrien ronde 9
Nasrien ronde 10
Nasrien AANGEKOMEN
*/
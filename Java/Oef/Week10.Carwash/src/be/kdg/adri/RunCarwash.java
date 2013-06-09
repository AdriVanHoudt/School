package be.kdg.adri;

public class RunCarwash {
    public static void main(String[] args) {
        Carwash carwash = new Carwash();
        Car[] cars = {
                new Car(1, 0, carwash),
                new Car(2, 1, carwash),
                new Car(3, 3, carwash),
                new Car(4, 7, carwash),
                new Car(5, 8, carwash),
                new Car(6, 9, carwash)
        };
        
        for (Car car : cars) {
            new Thread(car).start();
        }
    }
}
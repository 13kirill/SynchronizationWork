public class Main {
    public static void main(String[] args) throws InterruptedException {
        final CarShowroom carShowroom = new CarShowroom();

        ThreadGroup buyers = new ThreadGroup("Покупатели");

        for (int i = 1; i <= 3 ; i++) {
            new Thread(buyers, carShowroom::buyCar, "Покупатель " + i).start();

        }

        new Thread(null, carShowroom::acceptCar, "Продавец").start();
    }
}
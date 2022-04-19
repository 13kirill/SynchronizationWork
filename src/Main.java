public class Main {
    public static void main(String[] args) throws InterruptedException {

        Seller seller = new Seller();

        CarFactory carFactory = new CarFactory(null, "АвтоВаз", seller);

        ThreadGroup buyers = new ThreadGroup("Покупатели");



        for (int i = 1; i <= 5 ; i++) {
            new Thread(buyers, seller::buyCar, "Покупатель " + i).start();
        }

        carFactory.start();

        while (buyers.activeCount() != 0) {
            Thread.sleep(500);
        }

           while (!carFactory.isInterrupted()) {
              carFactory.interrupt();
          }

    }
}
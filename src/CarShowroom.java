import java.util.ArrayList;
import java.util.List;

class CarShowroom {

    Seller seller = new Seller(this);
    List<Car> cars = new ArrayList<>(10);

    public Car buyCar() {
        return seller.buyCar();
    }

    public void acceptCar() {
        seller.acceptCar();
    }

    List<Car> getCar() { return cars;
    }

//    public void buyCar() {
//
//        synchronized (carSeller) {
//            System.out.println(Thread.currentThread().getName() + " покупает");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " пошел домой");
//        }
//    }
}
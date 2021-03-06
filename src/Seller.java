import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Seller {

    final int CAR_DELIVERY = 1000;
    final int CAR_ACCEPT = 500;
    List<Car> cars = new ArrayList<>(10);

    Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();

    public void buyCar() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " заходит в автосалон ВАЗ");
            while (cars.size() == 0) {
                System.out.println("Похоже что у вас в наличии нет автомобилей! Сколько мне ждать?");
                condition.await();
            }
            Thread.sleep(CAR_DELIVERY);
            System.out.println(Thread.currentThread().getName() + " уехал на новенькой VESTE за 2,5 млн. руб.");
            cars.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void acceptCar(Car car) {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ": скоро должен приехать автовоз.");
            cars.add(car);
            Thread.sleep(CAR_ACCEPT);
            System.out.println(Thread.currentThread().getName() + ": Ура! Приехала новая VESTA!");
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
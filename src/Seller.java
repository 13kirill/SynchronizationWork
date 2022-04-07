public class Seller {

    private CarShowroom carShowroom;
    final int CAR_DELIVERY = 3000;
    final int CAR_ACCEPT = 2000;

    public Seller(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }

    public synchronized Car buyCar() {
        try {

            System.out.println(Thread.currentThread().getName() + " заходит в автосалон ВАЗ");
            while (carShowroom.getCar().size() == 0) {
                System.out.println("Похоже что у вас в наличии нет автомобилей! Сколько мне ждать?");

                wait();
            }
            Thread.sleep(CAR_DELIVERY);
            System.out.println(Thread.currentThread().getName() + " уехал на новенькой VESTE за 2,5 млн. руб.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carShowroom.getCar().remove(0);
    }


    public synchronized void acceptCar() {
        try {
            System.out.println(Thread.currentThread().getName() + ": скоро должен приехать автовоз.");
            Thread.sleep(CAR_ACCEPT);
            carShowroom.getCar().add(new Car());
            System.out.println(Thread.currentThread().getName() + ": Ура! Приехали новые VESTA!");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

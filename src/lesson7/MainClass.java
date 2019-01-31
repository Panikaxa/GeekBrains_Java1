package lesson7;

public class MainClass {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] catArray = new Cat[4];
        catArray[0] = new Cat("Barsik", 10);
        catArray[1] = new Cat("Murzik", 20);
        catArray[2] = new Cat("Pushok", 30);
        catArray[3] = new Cat("Dymok", 60);

        System.out.println("Еды в тарелке - " + plate.getFood());

        for (Cat cat: catArray) {
            cat.eat(plate);
            if (!cat.getFull()) {
                plate.fillPlate(cat.getAppetite() - plate.getFood());
                cat.eat(plate);
            }
            System.out.println("Еды в тарелке осталось - " + plate.getFood());
        }
        System.out.println("----------------------");
        for (Cat cat: catArray) {
            if (cat.getFull()) System.out.println(cat.getName() + " сыт!");
            else System.out.println(cat.getName() + " голоден!");
        }
    }
}

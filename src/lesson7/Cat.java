package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean full = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            full = true;
            System.out.println(name + " покушал!");
        } else {
            System.out.println(name + " не смог покушать! " +
                    "В тарелке слишком мало еды!");
        }
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean getFull() {
        return full;
    }

    public String getName() {
        return name;
    }
}

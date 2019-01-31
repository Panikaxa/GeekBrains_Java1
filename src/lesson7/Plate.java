package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food >= n){
            food -= n;
            return true;
        } else {
            return false;
        }
    }

    public void fillPlate(int food) {
        System.out.println("Наполняем тарелку...");
        this.food += food;
    }

    public int getFood() {
        return food;
    }
}


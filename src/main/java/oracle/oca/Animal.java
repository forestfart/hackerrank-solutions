package oracle.oca;

interface Walk {
    default int getSpeed() {
        return 5;
    }
}

interface Run {
    default int getSpeed() {
        return 10;
    }
}

class Animal implements Run, Walk {

    public int getSpeed() {
        return 6;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal.getSpeed()); // <-6!
    }
}

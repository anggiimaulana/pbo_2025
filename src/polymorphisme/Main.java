package polymorphisme;

class Hewan {
    void bersuara() {
        System.out.print("Hewan bersuara");
    }
}

class Kucing extends Hewan {
    @Override
    void bersuara() {
        System.out.println("Meoonggg... Meooonggg");
    }
}

class Harimau extends Hewan {
    @Override
    void bersuara() {
        System.out.println("Raawwrrrr");
    }
}

public class Main {
    public static void main(String[] args) {
        Hewan hewan1 = new Kucing();
        Hewan hewan2 = new Harimau();

        hewan1.bersuara();
        hewan2.bersuara();
    }
}

package ex1;

public class Main {

    public static void main(String[] args) {

        OutTask first = new OutTask("mesaj din constructor");
        first.execute();

        RandomOutTask second = new RandomOutTask();
        second.execute();

        CounterOutTask third = new CounterOutTask();
        third.execute();
        third.execute();
        third.execute();
        third.execute();

    }
}

package ex1;

public class CounterOutTask implements Task {

    static int contor = 0;

    public void execute() {

        ++contor;

        System.out.println(contor);

    }

}

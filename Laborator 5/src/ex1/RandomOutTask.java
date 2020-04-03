package ex1;

public class RandomOutTask implements Task {

    double RandomNumber;

    RandomOutTask() {

        RandomNumber = Math.random() * 100;

    }

    public void execute() {

        System.out.println(RandomNumber);

    }

}

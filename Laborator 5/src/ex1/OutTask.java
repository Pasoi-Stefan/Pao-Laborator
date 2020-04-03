package ex1;

public class OutTask implements Task {

    String mesaj;

    OutTask(String mesaj) {

        this.mesaj = mesaj;

    }

    public void execute(){

        System.out.println(mesaj);

    }

}

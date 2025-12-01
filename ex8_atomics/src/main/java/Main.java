public class Main {

    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            counter = counter + 1;
        }).start();


        new Thread(() -> {
            counter = counter + 1;
        }).start();


    }


}

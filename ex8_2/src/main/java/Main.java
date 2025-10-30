public class Main {

    public static void main(String[] args) throws InterruptedException {

        Runnable logic = () -> {
//            while (true) {
//                System.out.println("Hello from thread");
//                try {
//                    Thread.sleep(300);
//                } catch (InterruptedException e) {
//                    return;
//                }
//            }
            for (int i = 0; i < 30; i++) {
                System.out.println("Hello from thread");
            }

        };

        Thread thread = new Thread(logic);
        thread.start();

//        while (true) {
//            System.out.println("Hello from main");
//            Thread.sleep(300);
//        }
        for (int i = 0; i < 30; i++) {
            System.out.println("Hello from main");
        }


    }


}

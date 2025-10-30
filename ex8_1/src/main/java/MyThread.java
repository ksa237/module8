public class MyThread extends  Thread{

    @Override
    public void run(){

        while (true) {
            if(isInterrupted()) {
                return;
            }
        }
    }


}

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static AtomicInteger count3 = new AtomicInteger(0);
    public static AtomicInteger count4 = new AtomicInteger(0);
    public static AtomicInteger count5 = new AtomicInteger(0);

    public static void main(String[] args) {

        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }

        //считаем красивые имена только длиной 3
        new Thread(() -> {
            for (String nick3 : texts) {

                if (nick3.length() != 3) {
                    continue;
                }

                //условие 1
                boolean isPalindrome = false;
                String reversed = new StringBuilder(nick3).reverse().toString();
                isPalindrome = nick3.equals(reversed);


                //условие 2
                boolean isAllSame = true;
                char firstChar = nick3.charAt(0);

                for (int i = 1; i < nick3.length(); i++) {
                    if (nick3.charAt(i) != firstChar) {
                        isAllSame = false;
                    }
                }

                //условие 3
                boolean isAscending = true;
                for (int i = 1; i < nick3.length(); i++) {
                    if (nick3.charAt(i) < nick3.charAt(i - 1)) {
                        isAscending = false;
                    }
                }

                if (isPalindrome || isAllSame || isAscending) {
                    count3.incrementAndGet();
                }


            }

            System.out.println("Красивых слов с длиной 3 : " + count3.get());

        }).start();

        //считаем красивые имена только длиной 4
        new Thread(() -> {
            for (String nick4 : texts) {

                if (nick4.length() != 4) {
                    continue;
                }

                //условие 1
                boolean isPalindrome = false;
                String reversed = new StringBuilder(nick4).reverse().toString();
                isPalindrome = nick4.equals(reversed);

                //условие 2
                boolean isAllSame = true;
                char firstChar = nick4.charAt(0);

                for (int i = 1; i < nick4.length(); i++) {
                    if (nick4.charAt(i) != firstChar) {
                        isAllSame = false;
                    }
                }


                //условие 3
                boolean isAscending = true;
                for (int i = 1; i < nick4.length(); i++) {
                    if (nick4.charAt(i) < nick4.charAt(i - 1)) {
                        isAscending = false;
                    }
                }

                if (isPalindrome || isAllSame || isAscending) {
                    count4.incrementAndGet();
                }

            }

            System.out.println("Красивых слов с длиной 4 : " + count4.get());

        }).start();

        //считаем красивые имена только длиной 5
        new Thread(() -> {
            for (String nick5 : texts) {

                if (nick5.length() != 5) {
                    continue;
                }

                //условие 1
                boolean isPalindrome = false;
                String reversed = new StringBuilder(nick5).reverse().toString();
                isPalindrome = nick5.equals(reversed);

                //условие 2
                boolean isAllSame = true;
                char firstChar = nick5.charAt(0);

                for (int i = 1; i < nick5.length(); i++) {
                    if (nick5.charAt(i) != firstChar) {
                        isAllSame = false;
                    }
                }

                //условие 3
                boolean isAscending = true;
                for (int i = 1; i < nick5.length(); i++) {
                    if (nick5.charAt(i) < nick5.charAt(i - 1)) {
                        isAscending = false;
                    }
                }

                if (isPalindrome || isAllSame || isAscending) {
                    count5.incrementAndGet();
                }

            }

            System.out.println("Красивых слов с длиной 5 : " + count5.get());

        }).start();


    }


    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }


}

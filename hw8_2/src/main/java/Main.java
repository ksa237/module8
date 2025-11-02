import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static final Map<Integer, Integer> sizeToFreq = new HashMap<>();
    public static final int NUMBER_OF_THREADS = 1000;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Callable<Void>> tasks = new ArrayList<>();

        for (int threadnum = 0; threadnum < NUMBER_OF_THREADS; threadnum++) {

            tasks.add(() -> {

                String currentRoute = generateRoute("RLRFR", 100);

                int countR = 0; // частота повторения R

                for (int i = 0; i < currentRoute.length(); i++) {
                    if (currentRoute.charAt(i) == 'R') {
                        countR++;
                    }
                }

                synchronized (sizeToFreq) {
                    sizeToFreq.put(countR, sizeToFreq.getOrDefault(countR, 0) + 1);
                }

                System.out.println("Поток '" + Thread.currentThread().getName() + "' завершил работу с результатом: " + countR);
                return null;

            });
        }

        try {
            executor.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();


        //теперь найдем Самое частое количество повторений
        // maxValueMap - самое частое значение
        Optional<Integer> opMaxValueMap = sizeToFreq.values()
                .stream()
                .max(Integer::compareTo);

        Integer maxValueMap = opMaxValueMap.get();

        List<Integer> keys = sizeToFreq.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxValueMap))
                .map(Map.Entry::getKey)
                .toList();
        int keyFromMaxValue = keys.get(0);

        System.out.println();
        System.out.println("Самое частое кол-во повторений "+keyFromMaxValue+ " встретилось " + maxValueMap + " раз.");

        System.out.println();
        System.out.println("Другие размеры:");

        for (Map.Entry<Integer, Integer> entry : sizeToFreq.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value.equals(maxValueMap)) {
                continue;
            }
            System.out.println("- " + key + " (" + value + " раз)");
        }


    }

    public static String generateRoute(String letters, int length) {
        Random random = new Random();
        StringBuilder route = new StringBuilder();
        for (int i = 0; i < length; i++) {
            route.append(letters.charAt(random.nextInt(letters.length())));
        }
        return route.toString();
    }
}

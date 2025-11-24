import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Log {

    private static Log INSTANCE = null;

    private Map<String, Integer> freqs = new HashMap<>();

    private Log() {}

    public static Log getInstance() {
        if (INSTANCE == null){
            INSTANCE = new Log();
        }
        return INSTANCE;
    }

    public void log(String level, String msg) {

        freqs.put(level, freqs.getOrDefault(level, 0)+1);

        System.out.println("[" + level +"#" +freqs.get(level) +"]" +
                LocalDateTime.now() + " === " + msg);

    }

}

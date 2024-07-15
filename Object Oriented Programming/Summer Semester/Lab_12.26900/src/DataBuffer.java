import java.util.HashMap;
import java.util.Map;

public class DataBuffer {
    private final int capacity;
    private final Map<Integer, Integer> buffer;

    public DataBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new HashMap<>();
    }

    public synchronized void addProcessedData(int number, int result) throws InterruptedException {
        while (buffer.size() >= capacity) {
            wait();
        }
        buffer.put(number, result);
        notifyAll();
    }

    public synchronized Map<Integer, Integer> getProcessedData() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        Map<Integer, Integer> data = new HashMap<>(buffer);
        buffer.clear();
        notifyAll();
        return data;
    }
}
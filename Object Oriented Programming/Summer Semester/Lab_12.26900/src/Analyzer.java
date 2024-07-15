import java.util.Map;
import java.util.HashMap;

public class Analyzer extends Thread {
    private final DataBuffer dataBuffer;
    private final String analysisType;
    private final Map<Integer, Integer> intermediateData;

    public Analyzer(DataBuffer dataBuffer, String analysisType) {
        this.dataBuffer = dataBuffer;
        this.analysisType = analysisType;
        this.intermediateData = new HashMap<>();
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Map<Integer, Integer> processedData = dataBuffer.getProcessedData();
                if (processedData.isEmpty()) {
                    break;
                }
                analyzeData(processedData);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private void analyzeData(Map<Integer, Integer> processedData) {
        synchronized (intermediateData) {
            for (Map.Entry<Integer, Integer> entry : processedData.entrySet()) {
                int number = entry.getKey();
                int result = entry.getValue();
                System.out.println("Number is= " + number + ", It's square is= " + (number * number) + ", It's cube is= " + (number * number * number) + "\n");
                int analysisResult;
                if (analysisType.equals("sum")) {
                    analysisResult = number + result;
                } else if (analysisType.equals("prod")) {
                    analysisResult = number * result;
                } else {
                    System.out.println("Invalid Analysis Type");
                    return;
                }
                intermediateData.put(number, analysisResult);
            }
        }
    }

    public Map<Integer, Integer> getIntermediateData() {
        synchronized (intermediateData) {
            return new HashMap<>(intermediateData);
        }
    }
}
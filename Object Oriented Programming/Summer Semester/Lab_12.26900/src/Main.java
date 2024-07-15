import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] dataset = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        DataBuffer dataBuffer = new DataBuffer(5);
        Processor processor1 = new Processor(dataBuffer, dataset, 0, 5);
        processor1.start();
        Processor processor2 = new Processor(dataBuffer, dataset, 5, 9);
        processor2.start();
        Analyzer analyzer1 = new Analyzer(dataBuffer, "sum");
        analyzer1.start();
        Analyzer analyzer2 = new Analyzer(dataBuffer, "prod");
        analyzer2.start();
        try {
            processor1.join();
            processor2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        analyzer1.interrupt();
        analyzer2.interrupt();
        Map<Integer, Integer> intermediateData1 = analyzer1.getIntermediateData();
        Map<Integer, Integer> intermediateData2 = analyzer2.getIntermediateData();
        System.out.println("Intermediate Data (Sum of square and cube (The number= The Answer)): " + intermediateData1);
        System.out.println("Intermediate Data (Product of square and cube (The number= The Answer): " + intermediateData2);
    }
}

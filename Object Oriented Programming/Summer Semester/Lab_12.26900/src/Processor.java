public class Processor extends Thread {
    private final DataBuffer dataBuffer;
    private final int[] dataset;
    private final int start;
    private final int end;

    public Processor(ataBuffer dataBuffer, int[] dataset, int start, int end) {
        this.dataBuffer = dataBuffer;
        this.dataset = dataset;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            int number = dataset[i];
            int square = number * number;
            int cube = number * number * number;
            try {
                dataBuffer.addProcessedData(number, square + cube);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
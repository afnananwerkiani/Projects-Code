package Q1;

public class FibonacciThread extends Thread {
    private int[] sequence;
    private int num;
    private String name;


    public FibonacciThread(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public void getSequence() {
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println(" ");
    }

    public void run() {
        sequence = new int[num];
        if (num == 1) {
            sequence[0] = 0;
        } else if (num == 2) {
            sequence[0] = 0;
            sequence[1] = 1;
        } else if (num > 2) {
            sequence[0] = 0;
            sequence[1] = 1;
            for (int i = 2; i < num; i++) {
                sequence[i] = sequence[i - 1] + sequence[i - 2];
            }
        }
    }
}
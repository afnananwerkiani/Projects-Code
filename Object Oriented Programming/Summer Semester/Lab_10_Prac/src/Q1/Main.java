package Q1;

public class Main {
    public static void main(String[] args) {
        try {
            Thread thread1 = new FibonacciThread(8, "Fibonacci Thread");
            long stime1 = System.nanoTime();
            thread1.start();
            long etime1 = System.nanoTime();

            thread1.join();

            System.out.println("Name: " + thread1.getName());
            System.out.println("Time Elapsed: " + timeelapsed(stime1, etime1));
            ((FibonacciThread) thread1).getSequence();
            System.out.println(" ");

        } catch (InterruptedException e) {
        }
    }

    public static long timeelapsed(long a, long b) {
        long c = b - a;
        return c;
    }
}
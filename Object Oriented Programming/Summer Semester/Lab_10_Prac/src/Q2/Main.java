package Q2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PowerThread powerThread=new PowerThread(2, 6);
        long stime = System.nanoTime();
        powerThread.start();
        long etime = System.nanoTime();

        powerThread.join();

        System.out.println("Name: " + powerThread.getName());
        System.out.println("Time Elapsed: " + timeElapsed(stime, etime));
        System.out.println(" ");
    }

    public static long timeElapsed(long a, long b){
        long c = b - a;
        return c;
    }
}

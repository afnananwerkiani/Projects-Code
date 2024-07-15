package Q3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SumThread sumThread=new SumThread(new int[]{10, 20, 30, 40, 50, 100});
        long stime= System.nanoTime();
        sumThread.run();
        long etime=System.nanoTime();

        sumThread.join();

        System.out.println("Name: " + sumThread.getName());
        timeElapsed(stime, etime);
    }

    public static void timeElapsed(long a, long b){
        long c= b - a;
        System.out.println("Time Elapsed: " + c);
    }
}

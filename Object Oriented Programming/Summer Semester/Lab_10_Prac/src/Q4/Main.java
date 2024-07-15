package Q4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MinThread minThread=new MinThread(new int[]{9,5,14,7,4,1});
        long stime=System.nanoTime();
        System.out.println(" ");
        minThread.run();
        long etime=System.nanoTime();

        minThread.join();

        System.out.println("Name: " + minThread.getName());
        timeElapsed(stime, etime);
    }

    public static void timeElapsed(long a, long b){
        long c= b - a;
        System.out.println("Time Elapsed: "+ c);
    }
}

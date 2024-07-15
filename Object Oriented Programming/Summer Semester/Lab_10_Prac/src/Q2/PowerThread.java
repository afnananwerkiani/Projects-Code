package Q2;

public class PowerThread extends Thread {
    private int base;
    private int exponent;

    public PowerThread(int base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public void run() {
        int sum = base;
        for(int i= 1; i<exponent; i++){
            sum =sum * base;
        }
        System.out.println(base + "^" + exponent + "=" + sum);
    }
}

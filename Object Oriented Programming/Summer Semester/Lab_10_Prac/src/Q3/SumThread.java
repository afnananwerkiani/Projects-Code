package Q3;

public class SumThread extends Thread {
    private int sum;
    private int[] array;

    public SumThread( int[] array) {
        this.array = array;
    }

    public void run(){
        sum = 0;
        for (int i= 0; i< array.length; i++){
            sum =sum + array[i];
        }
        System.out.println("Sum of Array is: " + sum);
    }
}

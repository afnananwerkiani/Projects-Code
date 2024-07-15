package Q4;

public class MinThread extends Thread{
    private int[] array;
    private int min;

    public MinThread(int[] array) {
        this.array = array;
    }

    public void run(){
        int min = array[0];
        for (int i=0; i< array.length; i++){
            if(min>array[i]){
                min=array[i];
            }
        }
        System.out.println("Minimum Number:" + min);
    }
}

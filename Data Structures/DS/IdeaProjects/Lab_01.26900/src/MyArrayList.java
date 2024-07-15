public class MyArrayList<T extends Comparable<T>> {
    T[] arr;
    int currIndex;

    MyArrayList() {
        arr = (T[]) new Comparable[10];
        currIndex = -1;
    }

    MyArrayList(int size) {
        arr = (T[]) new Comparable[size];
        currIndex = -1;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < arr.length; i++)
            str = str + arr[i] + "\n";
        return str;
    }

    public void add(T data) {
        currIndex++;
        if (arr.length == currIndex) {
            T[] arr2 = (T[]) new Comparable[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
            }
            arr = arr2;
        }
        arr[currIndex] = data;
    }

    public int find(T value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println("The Value of Array at " + value + " is at index " + i + ".");
                return i;
            }
        }
        return 0;
    }

    public void clear() {
        currIndex = -1;
    }

    public T get(int index) {
        return (T) ("Value of Array at " + index + "th is= " + arr[index] + ".");
    }

    public void update(int index, T value) {
        arr[index] = value;
        System.out.println("Value of " + index + " has been Updated to= " + arr[index] + ".");
    }

    public void remove(T value) {
        int count = find(value);
        if (count != -1) {
            arr[count] = null;
            for (int a = count; a < currIndex--; a++) {
                arr[a] = arr[a + 1];
            }
        }
    }
}
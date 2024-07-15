public class SortingAlgoTest {
    public static void main(String[] args) {
        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }
        sortingAlgorithm.QuickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < 100; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}

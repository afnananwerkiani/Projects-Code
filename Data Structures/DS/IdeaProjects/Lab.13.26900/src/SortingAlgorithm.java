import java.util.Arrays;

public class SortingAlgorithm {
    public void MergeSort(int[] A, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort(A, left, mid);
            MergeSort(A, mid + 1, right);
            Merge(A, left, mid, right);
        }
    }

    public void QuickSort(int[] arr, int L, int U) {
        if (L < U) {
            int m = Partition(arr, L, U);
            if (m - 1 > L) {
                QuickSort(arr, L, m - 1);
            }
            if (m + 1 < U) {
                QuickSort(arr, m + 1, U);
            }
        }
    }

    public int Partition(int[] arr, int L, int U) {
        int pivot = arr[L];
        int i = L + 1;
        int j = U;
        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        int temp = arr[L];
        arr[L] = arr[j];
        arr[j] = temp;
        return j;
    }

    public void Merge(int[] A, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = Arrays.copyOfRange(A, left, left + n1);
        int[] R = Arrays.copyOfRange(A, mid + 1, mid + 1 + n2);
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
}

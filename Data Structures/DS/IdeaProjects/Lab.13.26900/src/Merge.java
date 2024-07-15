import java.util.Arrays;

public class Merge {
    public void MergeSort(int[] A, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort(A, left, mid);
            MergeSort(A, mid + 1, right);
            Merge(A, left, mid, right);
        }
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

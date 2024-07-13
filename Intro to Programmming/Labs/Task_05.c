#include <stdio.h>
void SortFunction(int *arr, int size, int order) {
    int i, j, temp;
    if (order == 1) {
        for (i = 0; i < size - 1; i++) {
            for (j = i + 1; j < size; j++) {
                if (*(arr + j) < *(arr + i)) {
                    temp = *(arr + i);
                    *(arr + i) = *(arr + j);
                    *(arr + j) = temp;
                }
            }
        }
    }
    else if (order == 2) {
        for (i = 0; i < size - 1; i++) {
            for (j = i + 1; j < size; j++) {
                if (*(arr + j) > *(arr + i)) {
                    temp = *(arr + i);
                    *(arr + i) = *(arr + j);
                    *(arr + j) = temp;
                }
            }
        }
    }
}
int main() {
	int i;
    int arr[100], size, order;
    printf("Enter the size of the array: ");
    scanf("%d", &size);
    printf("Enter the elements of the array: ");
    for (i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }
    printf("Enter the order to sort (1 for ascending, 2 for descending): ");
    scanf("%d", &order);
    printf("Original array: ");
    for (i = 0; i < size; i++) {
        printf("%d ", *(arr + i));
    }
    printf("\n");
    SortFunction(arr, size, order);
    if (order == 1) {
        printf("Array sorted in ascending order: ");
    }
    else if (order == 2) {
        printf("Array sorted in descending order: ");
    }
    for (i = 0; i < size; i++) {
        printf("%d ", *(arr + i));
    }
    printf("\n");
}

#include <stdio.h>
int main() {
    int size = 6;
    int array[size];
    int i, j;
    int symmetric = 1;
    printf("Enter %d integers:\n", size);
    for (i = 0; i < size; i++) {
        scanf("%d", &array[i]);
    }
    for (i = 0, j = size - 1; i < j; i++, j--) {
        if (array[i] != array[j]) {
            symmetric = 0;
            break;
        }
    }
    if (symmetric) {
        printf("The array is symmetric.\n");
    } else {
        printf("The array is not symmetric.\n");
    }
}


#include <stdio.h>
int main() {
    float numbers[5];
    int i, j;
    float temp;
    numbers[0] = 3.14;
    numbers[1] = 3.24;
    numbers[2] = 3.34;
    numbers[3] = 3.44;
    numbers[4] = 3.54;
    printf("The stored numbers are: ");
    for (i = 0; i < 5; i++) {
        printf("%.2f ", numbers[i]);
    }
    for (i = 0; i < 5; i++) {
        for (j = i + 1; j < 6; j++) {
            if (numbers[i] < numbers[j]) {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
    }
    printf("\nThe sorted numbers in descending order are: ");
    for (i = 0; i < 5; i++) {
        printf("%.2f ", numbers[i]);
    }
}


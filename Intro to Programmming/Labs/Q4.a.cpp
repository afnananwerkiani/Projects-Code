#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main() {
    int size = 6;
    float array[size];
    int i;
    float sum = 0.0, average;
    srand(time(NULL));
    for (i = 0; i < size; i++) {
        array[i] = (float)rand() / RAND_MAX;
    }
    printf("The elements of the array are:\n");
    for (i = 0; i < size; i++) {
        printf("%.2f ", array[i]);
    }
    printf("\n");
    for (i = 0; i < size; i++) {
        sum += array[i];
    }
    average = sum / size;
    printf("The sum of the array elements is %.2f\n", sum);
    printf("The average of the array elements is %.2f\n", average);
}


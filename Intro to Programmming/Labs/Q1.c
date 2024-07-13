#include <stdio.h>
int main() {
    int size, i;
    float sum = 0, count = 0;
    printf("Enter the size of the array: ");
    scanf("%d", &size);
    float arr[size];
    printf("Enter %d numbers: ", size);
    for(i = 0; i < size; i++) {
        scanf("%f", &arr[i]);
    }
    for(i = 0; i < size; i++) {
        if(arr[i] > 0) {
            sum += arr[i];
            count++;
        }
    }
    printf("Sum of all positive numbers: %.2f\n", sum);
    printf("Average of positive numbers: %.2f", sum / count);
}


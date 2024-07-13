#include <stdio.h>
int main() {
    int a, b;
    int c=1;
    printf("Enter number of elements that need to be added= ");
    scanf("%d", &a);
    int arr[a];
    for (b = 0; b < a; b++) {
        printf("Enter Element no.%d = ", c);
        scanf("%d", &arr[b]);
        c++;
    }
    int *ptr = arr;
    int sum = 0;
    int i;
    for (i = 0; i < a; i++) {
        sum += *(ptr + i);
    }
    printf("The sum of the array elements is %d", sum);
}

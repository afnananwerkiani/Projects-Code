#include <stdio.h>
int main() {
	int i;
    float arr[20];
    float *p, *q;
    printf("Enter 20 float numbers:\n");
    for (i = 0; i < 20; i++) {
        scanf("%f", &arr[i]);
    }
    p = arr;
    q = p + 1;
    if (*p < *q) {
        float *temp = p;
        p = q;
        q = temp;
    }
    for (i = 2; i < 20; i++) {
        if (*(arr + i) > *p) {
            q = p;
            p = arr + i;
        } else if (*(arr + i) > *q) {
            q = arr + i;
        }
    }
    printf("The second highest number in the array is: %.2f\n", *q);
}

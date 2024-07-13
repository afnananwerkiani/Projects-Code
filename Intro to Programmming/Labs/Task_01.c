#include <stdio.h>
void swaped(int *aPtr, int *bPtr, int *cPtr) {
    int temp = *bPtr;
    *bPtr = *aPtr;
    *aPtr = *cPtr;
    *aPtr = temp;
}
int main() {
    int a,b,c;
    printf("Enter the value of a= ");
    scanf("%d", &a);
    printf("Enter the value of b= ");
    scanf("%d", &b);
    printf("Enter the value of c= ");
    scanf("%d", &c);
    printf("Before swapping: a = %d, b = %d, c = %d\n", a, b, c);
    swaped(&a, &b, &c);
    printf("After swapping:  a = %d, b = %d, c = %d\n", a, b, c);
}

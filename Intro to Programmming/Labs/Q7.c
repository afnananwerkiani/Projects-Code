#include <stdio.h>
int main() {
    int num, i, j;
    printf("Enter a number between 3 and 10: ");
    scanf("%d", &num);
    if (num < 3 || num > 10 || num % 2 == 0) {
        printf("Invalid input. Please enter an odd number between 3 and 10.\n");
        return 1;
    }
    printf("Multiplication table for %d:\n", num);
    for (i = 1; i <= 10; i++) {
        printf("%d x %d = %d\n", num, i, num*i);
    }    
}


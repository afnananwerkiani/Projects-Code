#include <stdio.h>
#include <string.h>
int main() {
    char num[20];
    int total;
    int i, j;
    
    do {
        printf("Enter a number greater than or equal to four digits: ");
        scanf("%s", num);
    } while (strlen(num) < 4);
    
    while (strlen(num) > 1) {
        total = 0;
        for (i = 0; i < strlen(num); i++) {
            total += num[i] - '0'; 
        }
        sprintf(num, "%d", total); 
    }
    
    printf("The final sum is: %s", num);
    
    return 0;
}


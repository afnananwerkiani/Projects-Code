#include <stdio.h>
int main() {
    int marks1[5], marks2[5];
    int i, j;
    printf("Enter the marks of the first 5 students:\n");
    for (i = 0; i < 5; i++) {
        printf("Enter the mark for student %d: ", i+1);
        scanf("%d", &marks1[i]);
    }
    printf("\nEnter the marks of the remaining 5 students:\n");
    for (i = 0; i < 5; i++) {
        printf("Enter the mark for student %d: ", i+6);
        scanf("%d", &marks2[i]);
    }
    printf("\nCommon numbers in both arrays: ");
    for (i = 0; i < 5; i++) {
        for (j = 0; j < 5; j++) {
            if (marks1[i] == marks2[j]) {
                printf("%d\n ", marks1[i]);
            }
        }
    }
}


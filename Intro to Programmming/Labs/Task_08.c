#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main() {
    int N;
    char *fullname, *student_id;
    printf("Enter the total number of characters in your full name: ");
    scanf("%d", &N);
    fullname = (char *) malloc((N + 1) * sizeof(char));
    printf("Enter your first name: ");
    scanf("%s", fullname);
    printf("Enter your last name: ");
    scanf("%s", fullname + strlen(fullname));
    printf("Enter your student ID: ");
    student_id = (char *) malloc(5 * sizeof(char));
    scanf("%s", student_id);
    fullname = (char *) realloc(fullname, (N + 6) * sizeof(char));
    strcat(fullname, " ");
    strcat(fullname, student_id);
    printf("Dynamic array: %s\n", fullname);
    free(fullname);
    free(student_id);
}

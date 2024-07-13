#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main() {
    int N;
    char *fullname;
    printf("Enter the total number of characters in your full name: ");
    scanf("%d", &N);
    fullname = (char *) malloc((N + 1) * sizeof(char));
    printf("Enter your first name: ");
    scanf("%s", fullname);
    printf("Enter your last name: ");
    scanf("%s", fullname + strlen(fullname));
    printf("Dynamic array: %s\n", fullname);
    free(fullname);
    return 0;
}

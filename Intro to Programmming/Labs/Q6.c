#include <stdio.h>
#include <string.h>
int main() {
    char first_name[50];
    char last_name[50];
    char full_name[100];
    printf("Enter your first name: ");
    scanf("%s", first_name);
    printf("Enter your last name: ");
    scanf("%s", last_name);
    strcpy(full_name, first_name);
    strcat(full_name, " ");
    strcat(full_name, last_name);
    printf("Full name: %s\n", full_name);
    printf("Character count: %d\n", strlen(full_name));
}


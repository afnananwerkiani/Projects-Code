#include <stdio.h>
#include <ctype.h>
int WordCount(char *Text, int *size) {
    int count = 0;
    int i = 0;
    while (*(Text + i) != '\0') {
        while (isspace(*(Text + i))) {
            i++;
        }
        if (*(Text + i) != '\0') {
            count++;
        }
        while (*(Text + i) != '\0' && !isspace(*(Text + i))) {
            i++;
        }
    }
    *size = i;
    return count;
}
int main() {
    char text[100];
    int size;
    printf("Enter a string: ");
    scanf("%99[^\n]", text);
    int word_count = WordCount(text, &size);
    printf("The string \"%s\" contains %d words.\n", text, word_count);
    printf("The length of the string is %d.\n", size);
}

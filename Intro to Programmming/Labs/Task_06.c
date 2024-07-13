#include <stdio.h>
#include <ctype.h>
void SentenceCase(char *Text, int size) {
	int i;
    if (size > 0 && isalpha(*(Text))) {
        *(Text) = toupper(*(Text));
    }
    for (i = 1; i < size; i++) {
        if (*(Text + i - 1) == '.' && isalpha(*(Text + i))) {
            *(Text + i) = toupper(*(Text + i));
        }
    }
}
int main() {
    char Text[100];
    int size;
    printf("Enter the string: ");
    fgets(Text, 100, stdin);
    size = 0;
    while (*(Text + size) != '\0') {
        size++;
    }
    SentenceCase(Text, size);
    printf("Sentence case corrected string: %s\n", Text);
}

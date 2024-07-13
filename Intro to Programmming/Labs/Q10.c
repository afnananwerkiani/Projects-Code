#include <stdio.h>
int main() {
    float length[8], width[8], area[8], largest;
    int i, index;
    printf("Enter the dimensions of each land piece (in meters):\n");
    for (i = 0; i < 8; i++) {
        printf("Land %d: Length = ", i + 1);
        scanf("%f", &length[i]);
        printf("       Width  = ");
        scanf("%f", &width[i]);
        area[i] = length[i] * width[i];
    }
    largest = area[0];
    index = 0;
    for (i = 1; i < 8; i++) {
        if (area[i] > largest) {
            largest = area[i];
            index = i;
        }
    }
    printf("\nArea of each land piece:\n");
    for (i = 0; i < 8; i++) {
        printf("Land %d: %.2f square meters\n", i + 1, area[i]);
    }
    printf("\nLand %d is the largest with an area of %.2f square meters.\n", index + 1, largest);
}

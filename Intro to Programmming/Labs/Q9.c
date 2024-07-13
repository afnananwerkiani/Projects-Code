#include <stdio.h>
int main() {
    float A, p, Iq_Score;
    printf("A\t p\t Iq_Score\n");
    for (A = 1; A <= 7; A++) {
        for (p = 4.5; p <= 13.5; p += 0.6) {
            Iq_Score = 2 + (A + 0.5 * p);
            printf("%.1f\t %.1f\t %.2f\n", A, p, Iq_Score);
        }
    }
}


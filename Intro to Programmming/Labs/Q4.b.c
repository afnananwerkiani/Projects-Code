#include <stdio.h>
#define MAX_STUDENTS 10
int main() {
	int i;
    int pass_marks[MAX_STUDENTS], fail_marks[MAX_STUDENTS];
    int pass_count = 0, fail_count = 0;
    int input_mark;
    while (pass_count < MAX_STUDENTS && fail_count < MAX_STUDENTS) {
        printf("Enter quiz mark (enter -1 to exit):\n");
        scanf("%d", &input_mark);       
        if (input_mark == -1) {
            break;
        }
        else if (input_mark >= 5 && input_mark <= 10) {
            pass_marks[pass_count] = input_mark;
            pass_count++;
        }
        else if (input_mark >= 0 && input_mark < 5) {
            fail_marks[fail_count] = input_mark;
            fail_count++;
        }
        else {
            printf("Invalid input! Please enter a mark between 0-10.\n");
        }
    }
    printf("Pass marks:\n");
    int pass_total = 0;
    for (i = 0; i < pass_count; i++) {
        printf("%d ", pass_marks[i]);
        pass_total += pass_marks[i];
    }
    float pass_average = (float) pass_total / pass_count;
    printf("\nAverage pass mark: %.2f\n", pass_average);
    printf("Failed marks:\n");
    int fail_total = 0;
    for (i = 0; i < fail_count; i++) {
        printf("%d ", fail_marks[i]);
        fail_total += fail_marks[i];
    }
    float fail_average = (float) fail_total / fail_count;
    printf("\nAverage failed mark: %.2f\n", fail_average);
}


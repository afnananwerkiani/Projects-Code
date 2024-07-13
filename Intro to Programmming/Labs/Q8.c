#include <stdio.h>

#define NUM_STUDENTS 5
#define NUM_COURSES 5

int main() {
	int i, j;
    int marks[NUM_STUDENTS][9];
    for (i = 0; i < NUM_STUDENTS; i++) {
        marks[i][0] = i + 1; 
        for (j = 1; j <= NUM_COURSES; j++) {
            marks[i][j] = -1;
        }
        marks[i][6] = 0; 
        marks[i][7] = 0; 
        marks[i][8] = 0; 
    }
    for (i = 0; i < NUM_STUDENTS; i++) {
        printf("Enter marks for student %d:\n", i + 1);
        for (j = 1; j <= NUM_COURSES; j++) {
            printf("Enter marks for course %d: ", j);
            scanf("%d", &marks[i][j]);
        }
    }
    for (i = 0; i < NUM_STUDENTS; i++) {
        int total_marks = 0;
        int obtained_marks = 0;
        for (j = 1; j <= NUM_COURSES; j++) {
            total_marks += 100; // each course is of 100 marks
            obtained_marks += marks[i][j];
        }
        marks[i][6] = total_marks;
        marks[i][7] = obtained_marks;
        marks[i][8] = (float)obtained_marks / total_marks * 100;
    }
    printf("\nStudentID\tCourse1\tCourse2\tCourse3\tCourse4\tCourse5\tTotalMarks\tObtainedMarks\tPercentage\n");
    for (i = 0; i < NUM_STUDENTS; i++) {
        for (j = 0; j < 9; j++) {
            printf("%d\t\t", marks[i][j]);
        }
        printf("\n");
    }
}

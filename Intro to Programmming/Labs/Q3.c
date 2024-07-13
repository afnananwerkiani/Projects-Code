#include <stdio.h>
int main() {
    int rows, cols, i, j;
    printf("Enter the number of rows and columns of the matrix: ");
    scanf("%d %d", &rows, &cols);
    int matrix[rows][cols];
    int max = matrix[0][0];
    printf("Enter the elements of the matrix:\n");
    for(i=0; i<rows; i++) {
        for(j=0; j<cols; j++) {
            scanf("%d", &matrix[i][j]);
            if(matrix[i][j] > max) {
                max = matrix[i][j];
            }
        }
    }
    printf("Entered matrix:\n");
    for(i=0; i<rows; i++) {
        for(j=0; j<cols; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
    printf("Maximum element of the matrix is: %d\n", max);
}

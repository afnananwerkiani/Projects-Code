#include <stdio.h>
#define MAX_SIZE 100
int main() {
    int matrix[MAX_SIZE][MAX_SIZE];
    int transpose[MAX_SIZE][MAX_SIZE];
    int row, col, i, j, flag = 1;
    printf("Enter the number of rows and columns of the matrix: ");
    scanf("%d %d", &row, &col);
    printf("Enter the elements of the matrix:\n");
    for(i=0; i<row; i++) {
        for(j=0; j<col; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }
        for(i=0; i<row; i++) {
        for(j=0; j<col; j++) {
            transpose[j][i] = matrix[i][j];
        }
    }
        for(i=0; i<row; i++) {
        for(j=0; j<col; j++) {
            if(matrix[i][j] != transpose[i][j]) {
                flag = 0;
                break;
            }
        }
        if(flag == 0) {
            break;
        }
    	}
        if(flag == 1) {
        printf("Matrix is symmetric\n");
        for(i=0; i<row; i++) {
            for(j=0; j<col; j++) {
                printf("%d ", matrix[i][j]);
            }
            printf("\n");
        }
    }
    else {
        printf("Matrix is asymmetric\n");
    }
}


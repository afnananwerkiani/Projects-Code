#include <stdio.h>
int main() {
    int m, n, i, j, count = 0;
    printf("Enter the number of rows and columns of the matrix:\n");
    scanf("%d %d", &m, &n);
    int matrix[m][n];
    printf("Enter the elements of the matrix:\n");
    for(i = 0; i < m; i++) {
        for(j = 0; j < n; j++) {
            scanf("%d", &matrix[i][j]);
            if(matrix[i][j] == 0) {
                count++;
            }
        }
    }
    if(count >= ((m * n) / 2)) {
        printf("The matrix is a sparse matrix.\n");
    } else {
        printf("The matrix is not a sparse matrix.\n");
    }
}

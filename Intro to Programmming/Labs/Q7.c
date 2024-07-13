#include <stdio.h>
int main() {
	int i;
	int j;
    float sales[4][6] = {0};
    float total_sales[6] = {0};
    float total_sales_emp[4] = {0};
    int emp_id, prod_id;
    float total_amount;
    FILE *fp = fopen("sales_report.txt", "r");
    while (fscanf(fp, "%d %d %f", &emp_id, &prod_id, &total_amount) != EOF) {
        sales[emp_id-1][prod_id-1] += total_amount;
    }
    fclose(fp);
    printf("%-15s", "Product");
    for (i = 1; i <= 4; i++) {
        printf("%10s", "Emp ");
        printf("%d", i);
    }
    printf("%10s\n", "Total");
    printf("----------------------------------------------------------\n");
    for (j = 0; j < 6; j++) {
        float product_sales = 0;
        printf("%-15s", "Product ");
        printf("%d", j+1);
        for (i = 0; i < 4; i++) {
            float sales_amount = sales[i][j];
            printf("%10.2f", sales_amount);
            product_sales += sales_amount;
            total_sales_emp[i] += sales_amount;
            total_sales[j] += sales_amount;
        }
        printf("%10.2f\n", product_sales);
    }
    printf("----------------------------------------------------------\n");
    printf("%-15s", "Total Sales");
    for (j = 0; j < 6; j++) {
        printf("%10.2f", total_sales[j]);
    }
    printf("\n");
    for (i = 0; i < 4; i++) {
        float total_sales_amount = total_sales_emp[i];
        printf("Total sales by Emp %d: %.2f\n", i+1, total_sales_amount);
    }
}

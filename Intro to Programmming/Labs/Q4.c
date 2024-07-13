#include <stdio.h>
#define N 5
int main() {
  int i;
  int std1_marks[] = {60, 75, 85, 95, 49};
  int std2_marks[] = {59, 70, 65, 45, 39};
  float std1_mean = 0, std2_mean = 0;
  for (i = 0; i < N; i++) {
    std1_mean += std1_marks[i];
    std2_mean += std2_marks[i];
  }
  std1_mean /= N;
  std2_mean /= N;
  float cov = 0;
  for (i = 0; i < N; i++) {
    cov += (std1_marks[i] - std1_mean) * (std2_marks[i] - std2_mean);
  }
  cov /= (N - 1);
  printf("Covariance between student 1 and student 2 marks: %.2f", cov);
}

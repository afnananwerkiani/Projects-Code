#include<stdio.h>

/*Salesflow is one of leading software house they are starting their recruitment process for three different
following positions:
1. Associate Developer
2. Assistant Developer
3. Trainee Engineer

Write a function that will take a test marks from user and ask for experience (if its entered marks x >=60).
After that, function will show the assigned position.*/
void position(int, int);
int main()
{
	int marks, experience;
	printf("Enter the marks: ");
	scanf("%d", &marks);
	if (marks >= 60)
	{
		printf("Enter the experience: ");
		scanf("%d", &experience);
	}
	position(marks, experience);
	return 0;
}
void position(int marks, int experience)
{
	if (marks >= 60 && experience >= 2)
	{
		printf("You are assigned to the position of Assistant Developer");
	}
	else if (marks >= 60 && experience < 2)
	{
		printf("You are assigned to the position of Associate Developer");
	}
	else if (marks < 60)
	{
		printf("You are assigned to the position of Trainee Engineer");
	}
}

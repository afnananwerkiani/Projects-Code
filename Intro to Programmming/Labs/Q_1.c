#include<stdio.h>
#include<string.h>

/*As a programmer, you are required to create a program that takes the first and last name from a user.
The program then combines both the inputs taken and prints the string backwards.*/
void reverse(char[], int);
int main()
{
	char string[100];
	int i, count = 0;
	printf("Enter the string: ");
	gets(string);
	for (i = 0; string[i] != '\0'; i++)
	{
		count++;
	}
	reverse(string, count);
	return 0;
}
void reverse(char string[], int count)
{
	int i;
	for (i = count - 1; i >= 0; i--)
	{
		printf("%c", string[i]);
	}
}




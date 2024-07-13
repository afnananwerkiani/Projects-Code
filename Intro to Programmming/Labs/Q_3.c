#include<stdio.h>
#include<string.h>

/*Students are grouped in two to complete a lab task. Each student is required to enter a string of their
own choice as an input to the program. The program will then display as a result whether both the
strings are equal. If the strings are not equal, the program will display which of the string is greater*/
void compare(char[], char[]);
int main()
{
	char string1[100], string2[100];
	printf("Enter the string 1: ");
	gets(string1);
	printf("Enter the string 2: ");
	gets(string2);
	compare(string1, string2);
	return 0;
}
void compare(char string1[], char string2[])
{
	int i, j, count1 = 0, count2 = 0;
	for (i = 0; string1[i] != '\0'; i++)
	{
		count1++;
	}
	for (j = 0; string2[j] != '\0'; j++)
	{
		count2++;
	}
	if (count1 == count2)
	{
		printf("Both the strings are equal");
	}
	else if (count1 > count2)
	{
		printf("String 1 is greater than string 2");
	}
	else if (count1 < count2)
	{
		printf("String 2 is greater than string 1");
	}
}

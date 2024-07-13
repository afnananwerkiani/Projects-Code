#include<stdio.h>
#include<string.h>
#include<ctype.h>

/*Each student is required to find out the maximum frequency of characters occurring in their name and
the courses offered in Fall 2021. To find it, the student enters their name, courses offered and the
program finds the maximum occurrences of a character in the name and course.
Course names should be used like Programming Fundamentals, Applied Physics, Pakistan Studies and so on.*/
void maxFrequency(char[], int);
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
	maxFrequency(string, count);
	return 0;
}
void maxFrequency(char string[], int count)
{
	int i, j, count1 = 0, max = 0;
	char ch;
	for (i = 0; i < count; i++)
	{
		count1 = 0;
		for (j = i + 1; j < count; j++)
		{
			if (string[i] == string[j])
			{
				count1++;
			}
		}
		if (count1 > max)
		{
			max = count1;
			ch = string[i];
		}
	}
	printf("The maximum frequency of character is: %c", ch);
}

	
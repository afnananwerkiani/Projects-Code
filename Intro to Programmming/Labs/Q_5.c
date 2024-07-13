#include<stdio.h>
#include<stdlib.h>

/*Write a function that prints all the unique values from a array and the number of times each value occurs.
Below is an output sample. The main function takes a size of array as input and genrate a random integer
array with name “array1”. The ‘main’ function call a function with the named as “CountFrequency ()”. 
that will find the occurrence of each value in array.*/
void CountFrequency(int array1[], int size);
int main()
{
	int size, i;
	printf("Enter the size of array: ");
	scanf("%d", &size);
	int array1[size];
	for (i = 0; i < size; i++)
	{
		array1[i] = rand() % 10;
	}
	CountFrequency(array1, size);
	return 0;
}
void CountFrequency(int array1[], int size)
{
	int i, j, count;
	for (i = 0; i < size; i++)
	{
		count = 1;
		for (j = i + 1; j < size; j++)
		{
			if (array1[i] == array1[j])
			{
				count++;
				array1[j] = -1;
			}
		}
		if (array1[i] != -1)
		{
			printf("%d occurs %d times\n", array1[i], count);
		}
	}
}




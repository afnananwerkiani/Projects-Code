#include<stdio.h>

/*Write the program that calculates the volume of a square based pyramid. create two separate functions: 

1. One function that will take two input from user for
the variable of “h” and “a”.
2. Second function will calculate the volume and function must be called by first
function. Only first function call from the main function.*/
void getData();
void volumeCalu(int, int);
void getData()
{
	int h, a;
	printf("Enter the value of h: ");
	scanf("%d", &h);
	printf("Enter the value of a: ");
	scanf("%d", &a);
	volumeCalu(h, a);
}
void volumeCalu(int h, int a)
{
	int volume;
	volume = (h * a * a) / 3;
	printf("The volume of the square based pyramid is: %d", volume);
}
int main()
{
	getData();
	return 0;
}

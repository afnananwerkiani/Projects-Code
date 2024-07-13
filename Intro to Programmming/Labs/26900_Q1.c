#include<stdio.h>
int main(){
	int counter, a, i, b, c;
	int list [10];
	for(i=0; i<=9;i++){
		printf("Enter value of Element list[%d] =",i );
		scanf("%d", &list[i]);
	}
	printf("Enter a number to search= ");
	scanf("%d", &b);
	for(c=0; c<=9; c++){
		if(list [c]==b){
			counter++;
		}
	}
	if(counter==0){
		printf("number not found.");
	}else{
		printf("The number appeared %d times.", counter);
	}
}

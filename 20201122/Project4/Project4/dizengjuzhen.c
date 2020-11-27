#include<stdio.h>
#include<windows.h>
int findnum(int a[][3], int x, int y, int find) 
{
	int i = 0, j = y - 1; 

	while (j >= 0 && i < x)
	{
		if (a[i][j] < find) 
		{
			i++;
		}
		else if (a[i][j] > find)
		{
			j--;
		}
		else
		{
			return 1;
		}
	}
	return 0;
}

int main()
{
	int a[][3] = { { 1,2,3 },
	{ 4,5,6 },
	{ 7,8,9 } };

	if (findnum(a, 3, 3, 2))
	{
		printf("It has been found!\n");
	}
	else
	{
		printf("It hasn't been found!\n");
	}
	system("pause");
	return 0;
}

#include<stdio.h>
#include<Windows.h>
int main()
{
	int arr[] = { 1, 2, 3, 4, 5 };
	int len = sizeof(arr) / sizeof(arr[0]);
	int *p = arr;
	for (int i = 0; i < len; i++)
	{
		printf("%d ", *p);
		p++;
	}
	system("pause");
	return 0;
}
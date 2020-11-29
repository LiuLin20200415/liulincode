#include<stdio.h>
#include<Windows.h>
void Bub(int *arr, int len)
{
	int i = 0;
	int j = 0;
	for (i = 0; i <len; i++)
	{
		for (j = 0; j <len-i-1; j++)
		{
			if (arr[j+1] > arr[j])
			{
				int tmp = arr[j+1];
				arr[j+1] = arr[j];
				arr[j] = tmp;
			}
		}
	}
}
int main()
{
	int arr[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
	int len = sizeof(arr) / sizeof(arr[0]);
	Bub(arr, len);
	for (int a = 0; a < len ; a++)
	{
		
		printf("%d ", arr[a]);
	}
	system("pause");
	return 0;
}

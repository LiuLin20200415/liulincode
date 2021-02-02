#include<stdio.h>
#include<Windows.h>
#include<assert.h>
int main()
{
	char arr[] = "aasdsa";
	int len = sizeof(arr) / sizeof(arr[0]) - 1;
	char *p = arr;
	for (int i = len-1; i >= 0; i--)
	{
		*p = arr[i];
		assert(p != NULL);
		printf("%c", *p);
	}
	system("pause");
	return 0;

}
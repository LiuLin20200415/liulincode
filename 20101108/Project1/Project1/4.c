#include<stdio.h>
#include<math.h>
#include<Windows.h>
int main()
{
	int i = 0;
	for (i = 0; i < 100000; i++)
	{
		int count = 1;
		int sum = 0;
		int tmp = i;
		while (tmp / 10)
		{
			count++;
			tmp = tmp / 10;
		}
		tmp = i;
		while (tmp)
		{
			sum = sum + pow(tmp % 10, count);
			tmp = tmp / 10;
		}
		if (i == sum)
		{
			printf("%d ", i);
		}
	}
	system("pause");
	return 0;
}
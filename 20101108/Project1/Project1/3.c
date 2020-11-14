#include<stdio.h>
#include<math.h>
#include<Windows.h>
void SumPrint(int n)
{
	int sum=n;
	int a = 0;
	for (int i = 0; i < 5; i++)
	{
		a = a + n *pow(10,i);
		sum = sum + a;
		printf("%d ", a);
	}
	printf("%d\n", sum);
}
int main()
{
	int n = 2;
	SumPrint(n);
	system("pause");
	return 0;
}
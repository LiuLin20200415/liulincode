#include<stdio.h>
#include<Windows.h>
void yangHuiTriangle(int n)
{
	int data[30] = { 1 };

	int i, j;
	printf("1\n"); 
	for (i = 1; i < n; i++)
	{
		for (j = i; j > 0; j--) //�Ӻ���ǰ�������һ�е�������ʹ��ǰ�ͱ�����
		{
			data[j] += data[j - 1]; //��ʽͬ�ϣ����ڱ����һά����ʽҲ����ˡ�
		}

		for (j = 0; j <= i; j++) //��һ�������ֱ�Ӵ�ӡ�ˡ�
		{
			printf("%d ", data[j]);
		}
		putchar('\n');
	}
}
int main()
{
	int n = 5;
	yangHuiTriangle(n);
	system("pause");
	return 0;

}
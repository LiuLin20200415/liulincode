#include<stdio.h>
#include<Windows.h>
#include<string.h>
void LeftRight(char c[], int len, int k)
{
	k = k%len;//����5���ַ����ַ������������κ�����8�εĽ��һ��
	int j = 0;
	for (j = 0; j < k; j++)
	{
		int i = 0;
		char tmp = c[0];
		for (i = 0; i < len - 1; i++)
		{
			c[i] = c[i + 1];
		}
		c[i] = tmp;
	}
}
int main()
{
	char c[] = "abcde";
	int len = strlen(c);
	int k = 0;
	printf("����ת���ַ�������");
	scanf("%d", &k);
	LeftRight(c, len, k);
	printf("������%s\n", c);
	system("pause");
	return 0;
}
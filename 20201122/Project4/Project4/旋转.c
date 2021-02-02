#include<stdio.h>
#include<Windows.h>
#include<string.h>
int main()
{
	char *s1 = "abcd";
	char *s2 = "bcda";
	int len1 = strlen(s1);
	int len2 = strlen(s2);
	if (len1 != len2)
	{
		printf("0\n");
	}
	else
	{
		char *tmp = (char*)malloc(2 * len1 + 1);
		strcpy(tmp, s1);
		strcat(tmp, s1);
		if (strstr(tmp, s2) != NULL)
		{
			printf("1\n");
		}
		else
		{
			printf("0\n");
		}
		free(tmp);
	}
	system("pause");
	return 0;
}
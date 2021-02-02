#include "contact.h"
void InitContact(Contact *pCon)
{
	assert(pCon != NULL);
	pCon->useSize = 0;
	memset(pCon->per, 0, sizeof(pCon->per));
}
void AddContact(Contact *pCon)
{
	if (pCon->useSize == MAX_NUMPERSON)
	{
		printf("不好意思，没地了\n");
		return;
	}
	printf("请输入名字：");
	scanf("%s", pCon->per[pCon->useSize].name);
	printf("请输入性别：");
	scanf("%s", pCon->per[pCon->useSize].sex);
	printf("请输入年龄：");
	scanf("%d", &(pCon->per[pCon->useSize].age));
	printf("请输入电话：");
	scanf("%s", pCon->per[pCon->useSize].tel);
	printf("请输入地址：");
	scanf("%s", pCon->per[pCon->useSize].add);
	pCon->useSize++;
	printf("添加成功！\n");
}
int SearchContact(Contact *pCon)
{
	int i = 0;
	char name[20];
	if (pCon->useSize == 0)
	{
		printf("通讯录为空\n");
		return -1;
	}
	printf("请输入名字:");
	scanf("%s", name);
	for (i = 0; i < pCon->useSize; i++)
	{
		if (strcmp(pCon->per[i].name, name))
		{
			return i;
		}
	}
	return -1;
}
void DelContact(Contact *pCon)
{
	int index = SearchContact(pCon);
	int i = 0;
	if (index == -1)
	{
		printf("查无此人\n");
		return;
	}
	for (i = index; i < pCon->useSize - 1; i++)
	{
		pCon->per[i] = pCon->per[i + 1];
	}
	pCon->useSize--;
}
void ShowContact(Contact *pCon)
{
	int i = 0;
	printf("%-20s %-10s %-10s %-11s %-15s", "姓名", "性别", "年龄", "电话", "地址");
	for (i = 0; i < pCon->useSize; i++)
	{
		printf("%-20s %-10s %-10s %-11s %-15s", pCon->per[i].name, pCon->per[i].sex, pCon->per[i].age, pCon->per[i].tel, pCon->per[i].add);
	}
}
void ClearContact(Contact *pCon)
{
	pCon->useSize = 0;
}

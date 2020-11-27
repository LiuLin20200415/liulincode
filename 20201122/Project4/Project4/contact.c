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
		printf("������˼��û����\n");
		return;
	}
	printf("���������֣�");
	scanf("%s", pCon->per[pCon->useSize].name);
	printf("�������Ա�");
	scanf("%s", pCon->per[pCon->useSize].sex);
	printf("���������䣺");
	scanf("%d", &(pCon->per[pCon->useSize].age));
	printf("������绰��");
	scanf("%s", pCon->per[pCon->useSize].tel);
	printf("�������ַ��");
	scanf("%s", pCon->per[pCon->useSize].add);
	pCon->useSize++;
	printf("��ӳɹ���\n");
}
int SearchContact(Contact *pCon)
{
	int i = 0;
	char name[20];
	if (pCon->useSize == 0)
	{
		printf("ͨѶ¼Ϊ��\n");
		return -1;
	}
	printf("����������:");
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
		printf("���޴���\n");
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
	printf("%-20s %-10s %-10s %-11s %-15s", "����", "�Ա�", "����", "�绰", "��ַ");
	for (i = 0; i < pCon->useSize; i++)
	{
		printf("%-20s %-10s %-10s %-11s %-15s", pCon->per[i].name, pCon->per[i].sex, pCon->per[i].age, pCon->per[i].tel, pCon->per[i].add);
	}
}
void ClearContact(Contact *pCon)
{
	pCon->useSize = 0;
}

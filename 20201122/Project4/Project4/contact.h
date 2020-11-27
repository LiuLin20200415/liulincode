#include<stdio.h>
#include<Windows.h>
#include<assert.h>
#define MAX_NUMPERSON 10
typedef struct PersonInformation
{
	char name[20];
	char sex[20];
	int age;
	char tel[20];
	char add[20];
}PersonInformation;
typedef struct Contact
{
	int useSize;
	PersonInformation per[MAX_NUMPERSON];
}Contact;
void InitContact(Contact *pCon);
void AddContact(Contact *pCon);
int SearchContact(Contact *pCon);
void DelContact(Contact *pCon);
void ShowContact(Contact *pCon);
void ClearContact(Contact *pCon);
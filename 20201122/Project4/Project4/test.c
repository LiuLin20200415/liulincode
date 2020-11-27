#include "contact.h"
void memu()
{
	printf("*******1.add********2.search**********\n");
	printf("*******3.del********4.show**********\n");
	printf("*******5.clear********0.exit**********\n");
}
void start()
{
	int input = 0;
	Contact con;
	InitContact(&con);
	do
	{
		memu();
		printf("ÇëÊäÈëÄãµÄ²Ù×÷:");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			AddContact(&con);
			break;
		case 2:
		    SearchContact(&con);
			break;
		case 3:
			DelContact(&con);
			break;
		case 4:
			ShowContact(&con);
			break;
		case 5:
			ClearContact(&con);
			break;
		default:
			break;

		}
	} while(input);
}
int main()
{
	start();
	return 0;
}
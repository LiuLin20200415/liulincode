
#include "��ͷ.h"
void menu()
{
	printf("**************************\n");
	printf("*********0.exit***********\n");
	printf("*********1.play***********\n");
	printf("**************************\n");
}
void game()
{
	char board[ROW][COL] = { 0 };
	InitBoard(board, ROW, COL);
	ShowBoard(board, ROW, COL);
	int ret = 0;
	while (1)
	{
		PlayerMove(board, ROW, COL);
		ShowBoard(board, ROW, COL);
		ret = IsWin(board, ROW, COL);
		if (ret != ' ')
		{
			break;
		}
		ComputerMove(board, ROW, COL);
		ShowBoard(board, ROW, COL);
		ret = IsWin(board, ROW, COL);
		if (ret != ' ')
		{
			break;
		}

	}
	if (ret == ' Q')
	{
		printf("ƽ��\n");
		return;
	}
	if (ret == 'X')
	{
		printf("���Ӯ\n");
		return;
	}
	if (ret =='O')
	{
		printf("����Ӯ\n");
		return;
	}
}
int main()
{
	srand((unsigned)time(NULL));
	int input = 0;
	printf("��������Ĳ�����\n");
	do
	{
		menu();
		scanf("%d", &input);
		switch (input)
		{
		case 0:
			printf("�˳���Ϸ\n");
			break;
		case 1:
			game();
			break;
		default:
			break;
		}

	} while (input);
	system("pause");
	return 0;
}








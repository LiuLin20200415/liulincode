
#include "标头.h"
void InitBoard(char board[][COL], int row, int col)
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			board[i][j] = ' ';
		}
		
	}

}
void ShowBoard(char board[][COL], int row, int col)
{
	printf("**************************\n");
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			printf(" %c ", board[i][j]);
			if (j < col-1)
			{
				printf("|");
			}
			
		}
		printf("\n");
		if (i < row - 1)
		{
			for (int j = 0; j < col; j++)
			{
				printf("---");
				if (j < col-1 )
				{
					printf("|");
				}
			}
			printf("\n");
		}
	}
	printf("**************************\n");
}
void PlayerMove(char board[][COL], int row, int col)
{
	int x = 0; 
	int y = 0;
	while (1)
	{
		printf("请输入你的坐标：\n");
		scanf("%d%d", &x, &y);
		if (x >= 1 && x <= 3 && y >= 1 && y <= 3)
		{
			if (board[x - 1][y - 1] == ' ')
			{
				board[x - 1][y - 1] ='X';
				break;
			}
		}
		else
		{
			printf("坐标不合法，请重新输入：\n");
		}
	}
}
void ComputerMove(char board[][COL], int row, int col)
{
	int x = 0;
	int y = 0;
	while (1)
	{
		int x = rand() % ROW;
		int y = rand() % COL;
		if (board[x][y] == ' ')
		{
			board[x][y] = 'O';
			break;

		}
	}
}

char IsWin(char board[][COL], int row, int col)
{
	for (int i = 0; i < row; i++)
	{
		if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
		{
			return board[i][0];
		}
		if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')
		{
			return board[0][i];
		}
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
		{
			return board[0][0];
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')
		{
			return board[0][2];
		}
		if (IsFull(board, row, col) == 1)
		{
			return 'Q';
		}
	}
	return ' ';

	}
static int IsFull(char board[][COL], int row, int col)
{
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			if (board[i][j] == ' ')
			{
				return 0;
			}
		}
	}
	return 1;
}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int find_front(int front, int n, int* card)
{
	while (front <= n)
	{
		if (front == n)
			front = 1;
		if (card[++front] == 1)
			break;
	}
	return (front);
}

int main(void)
{
	int n;
	int* card;
	int front = 1, back;

	scanf("%d", &n);
	card = (int*)malloc(sizeof(int) * (n + 1));
	for (int i = 0; i < n + 1; i++)
		card[i] = 1; // 배열 초기화
	back = n;
	while (n != 1)
	{
		card[front] = 0;
		front = find_front(front, n, card);
		if (front == back)
			break;
		back = front;
		front = find_front(front, n, card);
	}
	printf("%d", front);
	return (0);
}
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

#define MIN(a, b) (((a) < (b)) ? (a) : (b));

int memo[1000001] = { 0, };

int make_one(int x)
{
	if (x == 1)
		return (0);
	else if (memo[x] != 0)
		return (memo[x]);
	else
	{
		memo[x] = make_one(x - 1) + 1;
		if (!(x % 3))
			memo[x] = MIN(memo[x], (make_one(x / 3) + 1));
		if (!(x % 2))
			memo[x] = MIN(memo[x], (make_one(x / 2) + 1));
	}
	return (memo[x]);
}

int main(void)
{
	int x = 0;

	memo[1] = 0;
	memo[2] = 1;
	memo[3] = 1;
	scanf("%d", &x);
	printf("%d", make_one(x));
}
#include<stdio.h>
#include<math.h>
#pragma warning(disable:4996)


int main(void)
{
	int x1, x2, x3, y1, y2, y3;
	scanf("%d %d", &x1, &y1);
	scanf("%d %d", &x2, &y2);
	scanf("%d %d", &x3, &y3);
	int a, b;
	if (x1 == x2)
		a = x3;
	else if (x1 == x3)
		a = x2;
	else if (x2 == x3)
		a = x1;
	if (y1 == y2)
		b = y3;
	else if (y1 == y3)
		b = y2;
	else if (y2 == y3)
		b = y1;
	printf("%d %d", a, b);
}
	
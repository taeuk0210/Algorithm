#include<stdio.h>
#include<stdlib.h>
#pragma warning(disable:4996)

int seq(int n)
{
	if (n == 1)
		return 1;
	else
		return seq(n - 1) + n;
}
int main(void)
{
	int n;
	scanf("%d", &n);
	int i=1;
	int t, b;
	while (seq(i) < n)
		i++;
	if (i == 1)	
		printf("1/1");	
	else if (i % 2 == 0)
	{
		t = 1;
		b = i;
		for (int j = seq(i - 1) + 1; j < n; j++)
		{
			t += 1;
			b -= 1;
		}
		printf("%d/%d", t, b);
	}
	else
	{
		t = i;
		b = 1;
		for (int j = seq(i - 1) + 1; j < n; j++)
		{
			t -= 1;
			b += 1;
		}
		printf("%d/%d", t, b);
	}
	
	return 0;
}
	
#include<stdio.h>
#include<math.h>
#pragma warning(disable:4996)

int prime(int n)
{
	if (n == 1)
		return 2;
	else if (n == 2)
		return 3;
	else
	{
		int num = 2;
		int p = 5;
		while (num != n)
		{
			int check = 0;
			for (int i = 2; i <= sqrt(p); i++)
			{
				if (p % i == 0)
				{
					check = 0;
					break;
				}
				else
				{
					check = 1;
					continue;
				}
			}
			if (check == 1)
			{
				num++;
				if (num == n)
					break;
				p++;
			}
			else
				p++;
		}
		return p;
	}
}
int primetest(int n) //prime 1 not 0
{
	if (n == 1)
		return 0;
	else
	{
		int check = 1;
		for (int i = 2; i <= sqrt(n); i++)
		{
			if (n % i == 0)
			{
				check = 0;
				break;
			}
			else
				continue;
		}
		return check;
	}
}

int main(void)
{
	int p[1230] = { 0 };
	for (int i = 1; i <= 1229; i++)
		p[i] = prime(i);
	
	int n;
	scanf("%d", &n);
	for (int q = 0; q < n; q++)
	{
		int m;
		scanf("%d", &m);
		int i = 1;
		while (p[i] <= m / 2)
			i++;
		for (int j = i-1;; j--)
		{
			if (primetest(m - p[j]) == 1)
			{
				printf("%d %d\n", p[j], m - p[j]);
				break;
			}
			else
				continue;
		}

		
	}
	return 0;
}

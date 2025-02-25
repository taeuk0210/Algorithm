#include<stdio.h>
#include<math.h>
#pragma warning(disable:4996)


int main(void)
{
	int n, m,min=300000;
	scanf("%d %d", &n, &m);
	int arr[100];
	for (int i = 0; i < n; i++)
		scanf("%d", &arr[i]);
	for(int i=0;i<n;i++)
		for(int j=0;j<n;j++)
			for (int k = 0; k < n; k++)
			{
				if (i != j && j != k && k != i&&(arr[i]+arr[j]+arr[k])<=m)
				{
					//printf("%d %d %d\n", arr[i], arr[j], arr[k]);
					if (min >= m - (arr[i] + arr[j] + arr[k]))
						min = m - (arr[i] + arr[j] + arr[k]);
				}
			}
	printf("%d",m-min);
	return 0;
}
# 2644

def printGraph(A):
    for line in A:
        print(line)
    print()
    return

n = int(input())
s, e = map(int, input().split())
m = int(input())

A = [[0 for _ in range(n)] for _ in range(n)]
for _ in range(m):
    i, j = map(int, input().split())
    A[i-1][j-1] = 1
    A[j-1][i-1] = 1

fA = A
for d in range(1, n):
    if fA[s-1][e-1] > 0:
        print(d)
        break
    nA = [[0 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        for j in range(n):
             nA[i][j] = sum([fA[i][k]*A[k][j] for k in range(n)])
    fA = nA
else:
    print(-1)


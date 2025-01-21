N = int(input())
data = set(map(int, input().split()))
M = input()
for i in map(int, input().split()):
    print(int(i in data))
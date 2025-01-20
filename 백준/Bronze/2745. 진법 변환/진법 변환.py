string, n = input().split()
n = int(n)
alp = "abcdefghijklmnopqrstuvwxyz".upper()
answer = 0
for i, s in enumerate(string[::-1]):
    answer += n ** i * (alp.index(s)+10) if s in alp else n ** i * int(s)
print(answer)
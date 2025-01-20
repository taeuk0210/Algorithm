T = int(input())

for _ in range(T):
    n = int(input())
    f0 = [1, 0]
    f1 = [0, 1]
    for i in range(n):
        f1, f0 = [f1[0]+f0[0], f1[1]+f0[1]], f1
    
    print(f"{f0[0]} {f0[1]}")
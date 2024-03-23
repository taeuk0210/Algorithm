def solution(n):
    d = []
    for i in range(1,n+1):
        if n%i==0:
            d.append(i)
    return sum(d) 
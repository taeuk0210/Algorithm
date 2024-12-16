def solution(topping):
    answer = 0
    a,b = {},{}
    for t in topping:
        if t not in b:
            b[t] = 1
        else:
            b[t] += 1
    
    for t in topping:
        if t not in a:
            a[t] = 1
        else:
            a[t] += 1
        
        if b[t] == 1:
            del b[t]
        else:
            b[t] -= 1
        
        if len(a.keys()) == len(b.keys()):
            answer += 1
            

        
    return answer
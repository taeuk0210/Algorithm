def solution(n, m, section):
    end = 0
    answer = 0
    for s in section:
        if end == 0:
            end = s + m - 1
            answer += 1
        elif s <= end:
            continue
        elif n >= s > end:
            end = s + m - 1
            answer += 1
            
            
            
            
            
    return answer
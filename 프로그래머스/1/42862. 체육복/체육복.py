def solution(n, lost, reserve):
    lost, reserve = [l for l in lost if l not in reserve], [r for r in reserve if r not in lost]
    
    for r in sorted(reserve):
        if r-1 in lost:
            lost.remove(r-1)
            continue
        elif r+1 in lost:
            lost.remove(r+1)
            continue
            
    answer = n - len(lost)
    return answer
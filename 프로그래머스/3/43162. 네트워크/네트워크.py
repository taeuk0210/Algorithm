def solution(n, computers):
    from collections import deque
    
    com = [0 for _ in range(n)]
    idx = 1
    while any([c==0 for c in com]):
        
        s = 0
        for i in range(n):
            if com[i] == 0:
                s = i
                break
                
        q = deque([s])
        com[s] = idx
        while q:
            i = q.popleft()
            for j in range(n):
                if j != i and computers[i][j] == 1 and com[j] == 0:
                    q.append(j)
                    com[j] = idx
        idx += 1
    

    return max(com)
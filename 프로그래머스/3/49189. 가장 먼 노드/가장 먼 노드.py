def solution(n, edge):
    from collections import deque
    distance = [100000] * (n+1)
    distance[1] = 0
    q = deque([1])
    
    tree = [[] for _ in range(n+1)]
    for i,j in edge:
        tree[i].append(j)
        tree[j].append(i)
        
    while q:
        i = q.popleft()
        for j in tree[i]:
            if distance[j] > distance[i] + 1:
                distance[j] = distance[i] + 1
                q.append(j)
                
    distance.sort(reverse=True)
    answer = 1
    for d in distance[2:]:
        if d == distance[1]:
            answer += 1
        else:
            break
    return answer
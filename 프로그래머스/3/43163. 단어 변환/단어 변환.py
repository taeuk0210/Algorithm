def solution(begin, target, words):
    '''
    v1  v2  v3  v4
    1   0   0   0
    '''
    from collections import deque

    if target not in words:
        return 0
    
    n = len(begin) - 1
    distance = {w:1000 for w in words}
    for w in words:
        if sum([a==b for a,b in zip(begin, w)]) == n:
            distance[w] = 1

    for i in words:
        for j in words:
            if sum([a==b for a,b in zip(i,j)]) == n:
                distance[j] = min(distance[j], distance[i]+1)
    answer = 0 if distance[target] == 1000 else distance[target]
    return answer
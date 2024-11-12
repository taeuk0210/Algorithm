def solution(friends, gifts):
    answer = 0
    n = len(friends)
    table = [[0 for _ in range(n)] for _ in range(n)]
    index = {f:0 for f in friends}
    result = {f:0 for f in friends}
    
    for gift in gifts:
        give, receive = gift.split(" ")
        index[give] += 1
        index[receive] -= 1
        table[friends.index(give)][friends.index(receive)] += 1
        
    for i in range(n):
        for j in range(i+1, n):
            if table[i][j] > table[j][i]:
                result[friends[i]] += 1
            elif table[i][j] < table[j][i]:
                result[friends[j]] += 1
            else:
                if index[friends[i]] > index[friends[j]]:
                    result[friends[i]] += 1
                elif index[friends[i]] < index[friends[j]]:
                    result[friends[j]] += 1
                    
    return max(result.values())
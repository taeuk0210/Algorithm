def solution(s):
    position = {}
    answer = []
    for i in range(len(s)):
        if position.get(s[i]):
            answer.append(i - position[s[i]][-1])
            position[s[i]].append(i)
            
        else:
            answer.append(-1)
            position[s[i]] = [i]
    return answer
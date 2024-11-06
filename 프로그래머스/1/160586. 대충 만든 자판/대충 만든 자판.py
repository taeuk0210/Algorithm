def solution(keymap, targets):
    answer = []
    dic = {}
    
    for key in keymap:
        cnt = 1
        for k in key:
            if k in dic:
                dic[k] = min(cnt, dic[k])
            else:
                dic[k] = cnt
            cnt += 1
            
    for target in targets:
        num = 0
        for t in target:
            if t in dic:
                num += dic[t]
            else:
                num = -1
                break
        answer.append(num)
    return answer
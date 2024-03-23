def solution(gems):
    k = len(set(gems))
    answer = [0, len(gems)-1]
    s, e = 0, 0
    gem_dict = {gems[0]:1}
    while s < len(gems) and e < len(gems):
        if len(gem_dict) == k:
            if e-s < answer[1]-answer[0]:    # 최소 크기 확인
                answer = [s, e]       
            else:
                gem_dict[gems[s]] -= 1
                if gem_dict[gems[s]] == 0:
                    del gem_dict[gems[s]]    # count가 0이 되면 key가 없어야하므로 반드시 del
                s += 1
                
        else:
            e += 1
            if e == len(gems):
                break
                
            if gems[e] in gem_dict: 
                gem_dict[gems[e]] += 1
            else:
                gem_dict[gems[e]] = 1
    
    return [answer[0]+1, answer[1]+1]

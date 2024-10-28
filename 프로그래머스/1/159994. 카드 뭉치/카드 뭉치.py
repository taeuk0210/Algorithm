def solution(cards1, cards2, goal):
    answer = "Yes"
    for g in goal:
        if cards1 and cards1[0] == g:
            cards1.pop(0)
            continue
        if cards2 and cards2[0] == g:
            cards2.pop(0)
            continue
        answer = "No"
        break
    return answer
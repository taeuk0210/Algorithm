def solution(mats, park):
    h, w = len(park), len(park[0])
    answer = -1
    for m in mats:
        isAvailable = False
        for i in range(h - m + 1):
            for j in range(w - m + 1):
                if not isAvailable and park[i][j] == "-1":
                    check = True
                    for dy in range(m):
                        for dx in range(m):
                            if park[i+dx][j+dy] != "-1":
                                check = False
                    if check:
                        isAvailable = True
                        answer = max(m, answer)
    
    return answer
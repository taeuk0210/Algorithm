def solution(keyinput, board):
    direc = {
        "up":[0, 1],
        "down":[0, -1],
        "left":[-1, 0],
        "right":[1, 0]
    }
    r = (board[0] - 1) // 2
    c = (board[1] - 1) // 2
    answer = [0, 0]
    for key in keyinput:
        d = direc[key]
        if -r<=answer[0]+d[0]<=r and -c<=answer[1]+d[1]<=c:
            answer[0] += d[0]
            answer[1] += d[1]
    
    return answer
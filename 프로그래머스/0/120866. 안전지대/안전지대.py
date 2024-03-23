def solution(board):
    n = len(board)
    answer = 0
    for i in range(n):
        for j in range(n):
            if check(i,j,board):
                answer += 1
    return answer

def check(i,j, board):
    n = len(board)
    for x in range(i-1, i+2):
        for y in range(j-1, j+2):
            if 0<=x<n and 0<=y<n and board[x][y]==1:
                return False
    else:
        return True
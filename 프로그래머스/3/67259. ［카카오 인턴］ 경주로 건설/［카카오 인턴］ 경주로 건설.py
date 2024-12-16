def solution(board):
    n = len(board)
    cost = [[[900000]*4 for _ in range(n)] for _ in range(n)]
    
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]
    
    queue = []
    for i in range(4):
        cost[0][0][i] = 0
        queue.append([0,0,i,0])
    
    while queue:
        y, x, direc, price = queue.pop(0)
        for i in range(4):
            y_, x_ = y + dy[i], x + dx[i]
            if 0<=x_<n and 0<=y_<n and board[y_][x_]==0:
                newPrice = price + 100
                if direc != i:
                    newPrice += 500
                if newPrice < cost[y_][x_][i]:
                    cost[y_][x_][i] = newPrice
                    queue.append([y_, x_, i, newPrice])

    return min(cost[n-1][n-1])
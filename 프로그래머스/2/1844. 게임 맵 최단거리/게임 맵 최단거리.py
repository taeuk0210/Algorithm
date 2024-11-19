def solution(maps):
    answer = 0
    n, m = len(maps), len(maps[0])
    q = [[0,0]]
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    while q:
        y, x = q.pop(0)
        for i in range(4):
            _x = x + dx[i]
            _y = y + dy[i]
            if 0 <= _x < m and 0 <= _y < n:
                if maps[_y][_x] == 1 and (_y, _x) != (0, 0):
                    q.append([_y, _x])
                    maps[_y][_x] = maps[y][x] + 1
    answer = -1 if maps[n-1][m-1] == 1 else maps[n-1][m-1]
    return answer
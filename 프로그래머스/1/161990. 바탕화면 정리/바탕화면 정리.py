def solution(wallpaper):
    lux, luy, rdx, rdy = len(wallpaper[0]), len(wallpaper), 0, 0
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[0])):
            if wallpaper[i][j] == "#":
                lux = min(lux, j)
                luy = min(luy, i)
                rdx = max(rdx, j+1)
                rdy = max(rdy, i+1)
    answer = [luy, lux, rdy, rdx]
    return answer
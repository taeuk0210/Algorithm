def solution(dots):
    answer = (max(dots[0][0], dots[1][0], dots[2][0])-\
              min(dots[0][0], dots[1][0], dots[2][0])) *\
             (max(dots[0][1], dots[1][1], dots[2][1])-\
              min(dots[0][1], dots[1][1], dots[2][1]))
    return answer
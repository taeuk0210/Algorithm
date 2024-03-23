def solution(s):
    
    answer = str(min(map(int, s.split(" "))))+' '+str(max(map(int, s.split(" "))))
    return answer
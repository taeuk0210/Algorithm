def solution(A,B):
    answer = sum([a*b for a,b in zip(sorted(A), sorted(B, reverse=True))])
    

    return answer
def solution(picture, k):
    answer = []
    for pic in picture:
        row = "".join([p*k for p in pic])
        for _ in range(k):
            answer.append(row)
    return answer
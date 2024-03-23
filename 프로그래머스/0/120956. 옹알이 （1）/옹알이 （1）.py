def solution(babbling):
    import re
    r = re.compile("aya|ye|woo|ma")
    answer = 0
    for b in babbling:
        if not r.sub("", b):
            answer += 1
    return answer
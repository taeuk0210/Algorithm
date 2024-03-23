def solution(operations):
    queue = []
    for op in operations:
        op = op.split(" ")
        if op[0] == "I":
            queue.append(int(op[1]))
            queue.sort()
        else:
            if op[1] == "-1" and queue:
                queue.pop(0)
            elif op[1] == "1" and queue:
                queue.pop()
    answer = [0,0] if not queue else [queue[-1], queue[0]]
    return answer
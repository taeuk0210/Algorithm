def solution(X, Y):
    dic = {i:min(X.count(str(i)),Y.count(str(i))) for i in range(9,-1,-1)}
    dic = {k:v for k,v in dic.items() if v > 0}
    
    if not dic:
        return "-1"
    if len(dic) == 1 and 0 in dic:
        return "0"
    return "".join([str(k)*dic[k] for k in dic.keys()])
# def solution(X, Y):
#     dic = {str(i):[0,0] for i in range(10)}
#     for x in X:
#         dic[x][0] += 1
#     for y in Y:
#         dic[y][1] += 1
#     answer = ''
#     for k in sorted(dic.keys(), reverse=True):
#         if dic[k][0] > 0 and dic[k][1] > 0:
#             answer += k * min(dic[k][0], dic[k][1])
#     if answer == '':
#         return "-1"
#     return str(int(answer))
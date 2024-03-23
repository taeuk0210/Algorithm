import re

def solution(dartResult):
    bon = {'S':1,'D':2,"T":3}
    opt = {'':1,'*':2,"#":-1}
    r = re.compile('(\d+)([SDT])([*#]?)')
    dart = r.findall(dartResult)
    for i in range(len(dart)):
        if dart[i][2] == '*' and i > 0:
            dart[i-1] *= 2
        dart[i] = int(dart[i][0]) ** bon[dart[i][1]] * opt[dart[i][2]]

    return sum(dart)
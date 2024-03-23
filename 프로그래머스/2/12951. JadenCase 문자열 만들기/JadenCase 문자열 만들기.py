def solution(s):
    s = s.title()
    for i in range(len(s)):
        if 48 <= ord(s[i]) <= 57:
            s = s[:i+1]+s[i+1].lower()+s[i+2:]
    return s
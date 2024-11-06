def solution(s, skip, index):
    answer = ''
    skip_num = [ord(c) - 97 for c in skip]
    
    for c in s:
        i = ord(c) - 97
        step = 0
        while step < index:
            i = (i + 1) % 26
            if i not in skip_num:
                step += 1
            
        answer += chr(i + 97)
    
    
    return answer
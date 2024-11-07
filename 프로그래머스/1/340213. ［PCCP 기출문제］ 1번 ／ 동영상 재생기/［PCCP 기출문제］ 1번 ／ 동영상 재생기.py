def solution(video_len, pos, op_start, op_end, commands):
    def time2second(time):
        time = time.split(":")
        return 60*int(time[0]) + int(time[1])
    video = time2second(video_len)
    pos = time2second(pos)
    op_start = time2second(op_start)
    op_end = time2second(op_end)
    if op_start <= pos <= op_end:
            pos = op_end
    for command in commands:
        
        if command=="prev":
            pos = max(0, pos - 10)
           
        else:
            pos = min(video, pos + 10)
        if op_start <= pos <= op_end:
            pos = op_end
        
    answer = f"{pos//60:02}:{pos%60:02}"
    return answer
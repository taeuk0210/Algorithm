def solution(dirs):
    xy = [0,0]
    d2v = {
        'L':[-1,0],
        'R':[1, 0],
        'U':[0, 1],
        'D':[0,-1]
    }
    
    m = set()
    for d in dirs:
        if (-5<= d2v[d][0] + xy[0] <=5 and -5<= d2v[d][1] + xy[1] <=5):
            m.add(tuple(xy + d2v[d]))
            m.add(tuple([xy[0]+d2v[d][0], xy[1]+d2v[d][1], -d2v[d][0], -d2v[d][1]]))
            xy[0] += d2v[d][0]
            xy[1] += d2v[d][1]
            
    return len(m)//2;

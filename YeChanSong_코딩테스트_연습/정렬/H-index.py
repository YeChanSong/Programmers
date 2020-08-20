def solution(init):
    answer = 0
    srtd = sorted(init)
    n = len(srtd)
    h = 0
    for i in range(len(srtd)):
        while 1:
            if h > srtd[i]:
                break
            if h <= srtd[i] and len(srtd) - i >= h:    
                answer = h
            h +=1
    return answer

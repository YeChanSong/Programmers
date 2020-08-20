def solution(init):
    answer = 0
    srtd = sorted(init)
    n = len(srtd)
    h = 0
    for i in range(n):
        while 1:
            if h > srtd[i]:
                break
            if h <= srtd[i] and n - i >= h:    
                answer = h
            h +=1
    return answer

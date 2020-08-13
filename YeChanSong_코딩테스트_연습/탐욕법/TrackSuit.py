def solution(n, lost, reserve):
    answer = 0
    stdnt = list(0 for i in range(1,n+1))
    for i in range(len(reserve)):
        stdnt[reserve[i]-1] += 1
    for i in range(len(lost)):
        stdnt[lost[i]-1] -=1
    
    for i in range(len(stdnt)):
        if stdnt[i] == 0:
            continue
        if stdnt[i] == -1:
            if i == 0:
                if stdnt[i+1] == 1:
                    stdnt[i+1] -=1
                    stdnt[i] +=1
                    continue
            if i != 0 and i != len(stdnt)-1:
                if stdnt[i-1] == 1:
                    stdnt[i-1] -=1
                    stdnt[i] +=1
                    continue
                if stdnt[i+1] == 1:
                    stdnt[i+1] -=1
                    stdnt[i] +=1
                    continue
            if i == len(stdnt)-1:
                if stdnt[i-1] == 1:
                    stdnt[i-1] -=1
                    stdnt[i] +=1
                    continue
    print(stdnt)
    answer = stdnt.count(0) + stdnt.count(1)
    
    return answer

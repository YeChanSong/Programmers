from collections import Counter

def solution(clothes):
    answer = 0
    dc = Counter()
    for i in clothes:
        dc[i[1]]+=1
    
    tmp = 1
    for i in dc.keys():
        dc[i] +=1
        tmp *= dc[i]
    
    tmp -=1
    
    answer = tmp
    
    return answer

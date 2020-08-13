from collections import Counter
from itertools import combinations

def solution(clothes):
    answer = 0
    dc = Counter()
    for i in clothes:
        dc[i[1]]+=1
    
    for i in range(len(dc)-1):
        if i == 0:
            li = []
            for k in dc.keys():
                temp = [k]
                li.append(temp)
            #print(li)
        else:
            li = combinations(dc.keys(),i+1)
            #print(li)
        for k in li:
            tmp2 = 1
            for t in k:
                tmp2 *= dc[t]
            answer += tmp2
    
    tmp = 1
    for i,v in dc.items():
        
        tmp *= v
    answer += tmp
    
    return answer

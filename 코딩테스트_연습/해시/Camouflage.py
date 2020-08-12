from collections import Counter
from itertools import combinations

def solution(clothes):
    answer = 0
    dc = Counter()
    for i in clothes:
        dc[i[1]]+=1
    
    for i in range(len(dc)):
        li = list(map(list,combinations(dc.keys(),i+1)))
        
        for k in li:
            tmp2 = 1
            for t in k:
                tmp2 *= dc[t]
            answer += tmp2
    
    return answer

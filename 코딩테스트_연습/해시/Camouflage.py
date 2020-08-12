from collections import Counter

def solution(clothes):
    answer = 0
    dc = Counter()
    for i in clothes:
        dc[i[1]]+=1
    
    # 옷의 종류가 4종류가 아니어도 4종류로 채워준다.
    for k in 'abc':
        if len(dc) < 4:
            dc[k] = 0
            
    # 4종류 중 4종류 선택
    tmp = 1
    for i,v in dc.items():
        tmp *= v
    answer += tmp
    #print('4',answer)
    
    # 4종류 중 3종류 선택
    tmp = 1
    res = 0
    for i,v in dc.items():
        for t,k in dc.items():
            if i != t:
                tmp *= k
        res += tmp
    answer += res
    #print('3',answer)
    # 4종류 중 2종류 선택
    tmp =0
    res = 0
    for i,v in dc.items():
        cnt = 0
        for t,k in dc.items():
            if t == i:
                cnt = 1
                continue
            if cnt == 0:
                continue
            res += v*k
            
    answer +=res
    #print('2',answer)
    # 4종류 중 1종류 선택
    for i,v in dc.items():
        answer +=v
    
    #print('1',answer)
    
    return answer

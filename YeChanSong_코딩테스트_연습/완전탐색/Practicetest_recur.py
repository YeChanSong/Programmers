import sys
sys.setrecursionlimit(1000000)

def recur(ppl,answers):
    cnt = 0
    lim = len(answers)
    if lim == 0:
        return 0
    
    for i in range(len(ppl)):
        if i == lim:
            break
        if ppl[i] == answers[i]:
            cnt +=1
    cnt += recur(ppl,answers[len(ppl):])
    return cnt

def solution(answers):
    answer = []
    tmp = answers
    ppl = [(1,2,3,4,5),(2,1,2,3,2,4,2,5),(3,3,1,1,2,2,4,4,5,5)]
    one = recur(ppl[0],answers)
    two = recur(ppl[1],answers)
    thr = recur(ppl[2],answers)
    
    if max(one,two,thr) == one:
        answer.append(1)
    if max(one,two,thr) == two:
        answer.append(2)
    if max(one,two,thr) == thr:
        answer.append(3)
    
    return answer

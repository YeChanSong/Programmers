import sys
sys.setrecursionlimit(1000000)
from math import sqrt

def recur(b,y,num):
    if num > int(sqrt(b+y)):
        return []
    
    rtn = []
    
    if (b+y)%num == 0:
        tmp = (b+y)//num
        if b == tmp*2 + num*2 -4:
            return [tmp,num]
    rtn = recur(b,y,num+1)
    return rtn


def solution(brown, yellow):
    answer = []
    answer = recur(brown,yellow,3)
    
    return answer

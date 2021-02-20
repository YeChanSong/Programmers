import sys
sys.setrecursionlimit(10000)

def dp(n,idx):
    global cache
    if idx > n:
        return 0
    if idx == n:
        return 1
    
    if cache[idx] != -1:
        return cache[idx]
    
    tmp = (dp(n,idx+1)%1234567 + dp(n,idx+2)%1234567)%1234567
    cache[idx] = tmp
    return tmp

def solution(n):
    global cache
    cache = list(-1 for i in range(n))
    answer = dp(n,0)
    return answer

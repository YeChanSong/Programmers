import sys
sys.setrecursionlimit(100000)

def dq(n,w):
    global cache
    if w > n:
        return 0
    if w == n:
        return 1
    
    if cache[w] != -1:
        return cache[w]
    
    curr = (dq(n,w+1)%1000000007 + dq(n,w+2)%1000000007)%1000000007
    cache[w] = curr
    return curr
    
def solution(n):
    global cache
    answer = 0
    cache = list(-1 for i in range(n))
    w = 0
    answer = dq(n,w)
    
    return answer

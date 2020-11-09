import sys
sys.setrecursionlimit(10000000)

def recur(y,x,fld,dest):
    global cache
    if y+1 > dest[0] or x+1 > dest[1]:
        return 0
    
    if (y+1,x+1) == dest:
        return 1
    
    if [x+1,y+1] in fld:
        return 0
    
    if cache[y][x] != None:
        return cache[y][x]
    
    tmp = recur(y+1,x,fld,dest) + recur(y,x+1,fld,dest)
    cache[y][x] = tmp
    return tmp
    

def solution(m, n, fld):
    global cache
    cache = [[None for i in range(m)] for i in range(n)]
    answer = recur(0,0,fld,(n,m)) % 1000000007
    return answer
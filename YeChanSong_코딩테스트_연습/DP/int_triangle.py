import sys
sys.setrecursionlimit(1000000)

def recur(y,x,fld):
    global cache
    if y == len(fld) - 1:
        cache[y][x] = fld[y][x]
        return fld[y][x]
    if cache[y][x] != None:
        return cache[y][x]
    
    tmp = fld[y][x] + max(recur(y+1,x,fld),recur(y+1,x+1,fld))
    cache[y][x] = tmp
    return tmp

def solution(tri):
    answer = 0
    global cache
    cache = [[None for j in range(i+1)] for i in range(len(tri))]
    answer = recur(0,0,tri)
    return answer
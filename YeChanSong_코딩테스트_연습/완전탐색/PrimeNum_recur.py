import sys
sys.setrecursionlimit(1000000)
from itertools import permutations
from math import sqrt

def recur(num, div):
    cnt = 0
    
    if div > int(sqrt(num)):
        return 1
    if num%div == 0:
        return 0
    
    
    cnt += recur(num,div+1)
    return cnt
    
    
def solution(numbers):
    answer = 0
    li = []
    ans = []
    tmp = len(numbers)
    for i in range(1,tmp+1):
        li = list(map(int,map(''.join,permutations(numbers,i))))
        for j in li:
            if j not in ans and j >1:
                ans.append(j)
                answer += recur(j,2)
    
    
    return answer

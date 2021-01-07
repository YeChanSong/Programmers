import sys

def dfs(idx,acc,numbers,target,sign):
    
    if idx == len(numbers)-1:
        if sign == '+':
            if acc + numbers[idx] == target:
                return 1
            else:
                return 0
        else:
            if acc - numbers[idx] == target:
                return 1
            else:
                return 0
    
    tmp = acc
    if sign == '-':
        tmp -= numbers[idx]
    else:
        tmp += numbers[idx]
    
    cnt = 0
    cnt += dfs(idx+1,tmp,numbers,target,'-')
    cnt += dfs(idx+1,tmp,numbers,target,'+')
    
    return cnt



def solution(numbers, target):
    answer = 0
    answer += dfs(0,0,numbers,target,'-')
    answer += dfs(0,0,numbers,target,'+')
    return answer

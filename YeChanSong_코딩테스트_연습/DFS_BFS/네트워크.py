import sys
sys.setrecursionlimit(10000)

def dfsall(n):
    global visited
    cnt = 0
    for i in range(n):
        if visited[i] == False:
            dfs(i)
            cnt +=1
    return cnt

def dfs(idx):
    global visited, adj
    
    visited[idx] = True
    
    for i in range(len(adj[idx])):
        if i == idx:
            continue
        if adj[idx][i] == 1 and visited[i] == False:
            dfs(i)
    
def solution(n, computers):
    answer = 0
    global visited, adj
    adj = computers
    visited = list(False for i in range(n))
    answer = dfsall(n)
    return answer

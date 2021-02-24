def dfsall(n):
    global dfshist, visited
    for i in range(n):
        visited = list(False for i in range(n))
        cntr = dfs(i,n)
        dfshist[i] = cntr
    
def dfs(idx,n):
    global adj, visited, counting
    visited[idx]=True
    cntr = 1
    for i in adj[idx]:
        if visited[i]==True:
            continue
        cntr += dfs(i,n)
    
    counting[idx] +=1
    return cntr
    
def solution(n, results):
    # dfshist: dfs결과 방문한 노드 수
    global adj, dfshist, counting
    answer = 0
    adj = list([] for i in range(n))
    dfshist = list(-1 for i in range(n))
    counting = list(0 for i in range(n))
    for d,s in results:
        adj[s-1].append(d-1)
    dfsall(n)
    for i in range(n):
        if dfshist[i]+counting[i] == n+1:
            answer+=1
    return answer

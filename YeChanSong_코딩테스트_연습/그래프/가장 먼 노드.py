import collections

def bfs(src):
    global adj, dist
    q = collections.deque()
    q.append(src)
    dist[src] = 0
    while q:
        itm = q.popleft()
        for nxt in adj[itm]:
            if dist[nxt] != -1:
                continue
            q.append(nxt)
            dist[nxt] = dist[itm]+1

def solution(n, edge):
    global adj, dist
    answer = 0
    adj = list([] for i in range(n))
    dist = list(-1 for i in range(n))
    for s,d in edge:
        adj[s-1].append(d-1)
        adj[d-1].append(s-1)
    
    bfs(0)
    dist.sort(reverse=True)
    cmp = dist[0]
    for i in dist:
        if cmp != i:
            break
        answer +=1
    return answer

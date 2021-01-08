from collections import deque

def diffChecker(src,dest):
    cnt = 0
    for i in range(len(src)):
        if src[i] != dest[i]:
            cnt +=1
    return cnt

def graphBuilder(src,words):
    global adj
    tmp = [src] + words
    for i in range(len(tmp)):
        for j in range(len(tmp)):
            if diffChecker(tmp[i],tmp[j]) == 1:
                adj[i].append(j)
    
def bfs(start):
    global adj, discovered, distance
    q = deque()
    q.append(start)
    discovered[start] = True
    distance[start] = 0
    while len(q):
        tmp = q.popleft()
        
        for i in adj[tmp]:
            if discovered[i] == True:
                continue
            
            q.append(i)
            discovered[i] = True
            distance[i] = distance[tmp]+1
    
    

def solution(begin, target, words):
    answer = 0
    global adj, discovered, distance
    discovered = list(False for i in range(len(words)+1))
    adj = list([] for i in range(len(words)+1))
    distance = list(0 for i in range(len(words)+1))
    if target in words:
        graphBuilder(begin, words)
        bfs(0)
        answer = distance[words.index(target)+1]
    
    return answer

import sys
sys.setrecursionlimit(100000)

def buildGraph():
    global data, adj
    
    for s,d in data:
        if adj.get(s) == None:
            adj.setdefault(s,[d])
        else:
            adj[s].append(d)
        if adj.get(d) == None:
            adj.setdefault(d,[])
        
def dfs(name):
    global adj, hist
    
    adj[name] = sorted(adj[name],reverse=True)
    while len(adj[name]):
        nxt = adj[name].pop()
        dfs(nxt)
    hist.append(name)    
    

def solution(tickets):
    answer = []
    global data, adj, hist
    adj = dict()
    hist = list()
    data = tickets
    buildGraph()
    dfs("ICN")
    hist.reverse()
    answer = hist
    
    return answer

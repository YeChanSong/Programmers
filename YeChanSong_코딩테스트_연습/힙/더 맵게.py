import heapq

def solution(sc, K):
    answer = 0
    heapq.heapify(sc)
    
    while 1:
        first = heapq.heappop(sc)
        if first >= K:
            break
        if not sc:
            answer = -1
            break
        second = heapq.heappop(sc)
        combi = first + 2*second
        heapq.heappush(sc,combi)
        answer+=1
    
    return answer

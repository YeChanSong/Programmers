import heapq

def solution(ops):
    answer = []
    minHq = list()
    maxHq = list()
    lenHq = 0
    for i in ops:
        inst, data = i.split()
        if lenHq == 0 and inst == 'D':
            continue
        v = int(data)
        if inst == 'I':
            heapq.heappush(minHq,v)
            heapq.heappush(maxHq,-v)
            lenHq += 1
            continue
        if inst == 'D' and v==1:
            itm = heapq.heappop(maxHq)
            minHq.remove(-itm)
            lenHq -=1
            continue
        else:
            itm = heapq.heappop(minHq)
            maxHq.remove(-itm)
            lenHq -=1
    if lenHq == 0:
        answer = [0,0]
    else:
        answer.append(-heapq.heappop(maxHq))
        answer.append(heapq.heappop(minHq))
    
    return answer
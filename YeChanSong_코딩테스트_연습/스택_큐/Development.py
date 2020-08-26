from math import ceil
from collections import deque

def solution(progresses, speeds):
    answer = []
    queue = deque()
    for i in range(len(progresses)):
        queue.append(ceil((100 - progresses[i])/speeds[i]))
    # 남은 작업일수를 큐에 push
    
    cnt = 1
    flag = True
    tmp = queue.popleft()
    # 비교기준이 되는 작업일수 pop
    
    while 1:
        if len(queue) == 0:
            break
        item = queue.popleft()
        if tmp >= item:
            cnt += 1
            continue
        else:
            answer.append(cnt)
            tmp = item
            cnt = 1
    answer.append(cnt)
    
    # 큐의 앞쪽 기준 작업일수보다 작거나 같은 작업들은 기준 작업이 배포되면서 같이 처리됨
    # 큐의 앞쪽 기준 작업일수보다 큰 작업의 경우, 기준을 큰 작업으로 설정하고 반복
    # 동시에, 카운트한 작업들을 answer에 추가
    
    return answer
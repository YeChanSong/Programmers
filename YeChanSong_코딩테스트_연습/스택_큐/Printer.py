from collections import deque

def solution(priorities, location):
    answer = 0
    q = deque()
    
    for i in range(len(priorities)):
        if i == location:
            q.append((priorities[i],True))
        else:
            q.append((priorities[i],False))
    # 큐 초기화
    
    orders = sorted(priorities,reverse=True)
    # 우선 순위 정렬
    
    while 1:
        item = q.popleft()
        if orders[0] == item[0] and item[1] == True:
            answer +=1
            break
        # 큐에서 원소를 하나 가져와서 location에 해당하는 원소이면서 우선순위와 맞다면 break
        if orders[0] == item[0] and item[1] == False:
            del orders[0]
            answer +=1
            continue
        # 큐에서 가져온 원소가 location에 해당하지 않는 원소이면서 우선순위와 맞다면
        # 우선순위와 함께 제거
        else:
            q.append(item)
        # 큐에서 가져온 원소가 location에 해당하지 않는 원소이면서 우선순위와도 맞지 않다면
        # 큐에 다시 삽입
    return answer

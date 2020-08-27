from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    # 정답은 시간초이므로 1씩 증가
    bridge = deque()
    total = 0
    # 다리를 큐로 활용, 다리 위의 트럭 무게를 total에 저장
    idx = 0
    # 트럭 인덱스
    flag = True
    # 대기 트럭이 남지 않은 경우 False
    
    while True:
        if len(bridge) == 0 and flag == False:
            break
        # 모든 트럭이 다리를 지난 경우 종료
        answer +=1
        
        if len(bridge) > 0:
            if bridge[0][1] + bridge_length == answer:
                tmp = bridge.popleft()
                total -= tmp[0]
            
        # 여기까지 트럭이 다리를 나올 조건
        
        if (total + truck_weights[idx]) <= weight and flag == True and len(bridge) < bridge_length:
            bridge.append((truck_weights[idx],answer))
            total += truck_weights[idx]
            if idx < len(truck_weights) -1:
                idx += 1
            else:
                flag = False
        # 여기까지 트럭이 다리로 진입할 조건
        
    return answer

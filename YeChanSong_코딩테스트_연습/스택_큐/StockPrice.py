def solution(prices):
    answer = [0 for i in range(len(prices))]
    stack = []
    cnt = 0
    for i in prices:
        if len(stack) == 0:
            stack.append((i,cnt))
            cnt += 1
            continue
        else:
            if stack[-1][0] > i:
                # 가격이 떨어진 경우
                while i < stack[-1][0]:
                    tmp = stack.pop()
                    answer[tmp[1]] = cnt - tmp[1]
                    if len(stack) == 0:
                        break
                stack.append((i,cnt))
                cnt += 1
            else:
                # 가격이 높거나 같은 경우
                stack.append((i,cnt))
                cnt += 1
    
    for i in stack:
        answer[i[1]] = len(answer) -1 -i[1]
    
    
    return answer
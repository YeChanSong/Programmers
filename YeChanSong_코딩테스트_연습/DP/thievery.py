def solution(money):
    answer = 0
    cache = list(None for i in range(len(money)))
    cache[0] = money[0]
    # 4번째 집이 2번째 집 + money[3]이 아닌 1번째 집 + money[3]을 챙길 수도 있으므로 cache[1]을 정해준다.
    cache[1] = max(money[0],money[1])
    cache[-1] = money[-1]
    for i in range(2,len(money)-1):
        cache[i] = max(cache[i-1], cache[i-2] + money[i])
    a = max(cache)
    cache = list(None for i in range(len(money)))
    cache[0] = money[0]
    cache[-1] = money[-1]
    cache[-2] = max(money[-1],money[-2])
    for i in range(len(money)-3,0,-1):
        cache[i] = max(cache[i+1], cache[i+2] + money[i])
    b = max(cache)
    answer = max(a,b)
    return answer

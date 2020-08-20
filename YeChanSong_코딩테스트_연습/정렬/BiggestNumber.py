def solution(numbers):
    answer = ''
    nums = list(map(str,numbers))
    li = [x*3 for x in nums]
    for k in reversed(sorted(li)):
        for p in range(len(k)//3):
            answer+=k[p]
    answer = str(int(answer))
    return answer
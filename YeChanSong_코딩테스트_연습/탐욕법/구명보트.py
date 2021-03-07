def solution(ppl, lim):
    answer = 0
    ppl.sort()
    if len(ppl) == 1:
        return 1
    idx = len(ppl)
    for i in range(len(ppl)):
        while idx > i:
            idx -=1
            if ppl[i]+ppl[idx]<=lim:
                answer += 1
                break
            else:
                answer += 1
        if idx<=i:
            break
    return answer
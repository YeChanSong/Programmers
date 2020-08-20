def solution(array, commands):
    answer = []
    tmp = []
    i,j,k = 0,0,0
    for p in commands:
        i,j,k = p[0] -1, p[1], p[2] -1
        tmp = sorted(array[i:j])
        answer.append(tmp[k])
    
    
    
    return answer

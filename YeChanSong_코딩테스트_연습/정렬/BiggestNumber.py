def solution(numbers):
    answer = ''
    strnum = list(map(str,numbers))
    numset = []
    for i in strnum:
        tmp = i
        while i != '0':
            if len(tmp) == 4:
                break
            else:
                tmp+=i[len(i)-1]
        numset.append([tmp,i])
        #[랭크, 원래 값]

    flag = []
    ll = []
    srtd = sorted(numset)
    
    srtd22 = sorted(numset)
    #print(srtd)
    start, end, tmp = 0, 0, 0
    
    for p in range(len(srtd)):
        tmp = srtd[p]
        
        if p == len(srtd)-1 and tmp[0] == srtd[start][0]:
            #마지막 원소까지 같은 랭크의 경우
            srtd22[start:] = reversed(srtd22[start:])
            break
        
        if p == len(srtd)-1 and tmp[0] != srtd[start][0]:
            #마지막 원소에서 다른 랭크의 경우
            srtd22[start:-1] = reversed(srtd22[start:-1])
            break
        
        
        if tmp[0] == srtd[start][0]:
            #같은 랭크를 가진 경우
            continue
        
        end = p-1
        srtd22[start:end+1] = reversed(srtd22[start:end+1])
        
        start = p
        
    print(srtd22)
    chksm = False
    for k in reversed(srtd22):
        
        if k[1] == '0' and chksm == False:
            chksm = True
            answer += k[1]
        elif k[1] == '0' and chksm == True:
            continue
        else:
            answer += k[1]
        
    #print(answer)
    return answer

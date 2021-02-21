'''
숫자가 9인 경우 뒤쪽을 찾아보지 않아도 최고값임을 알 수 있으므로
break를 취해줘야 시간 초과 당하지 않을 수 있다.
'''

def solution(n, k):
    answer = list()
    cntr = k
    pos = 0;cont = 0;lans = 0;flag = False
    ln = len(n)
    while cntr:
        tmp = -1
        for i in range(pos,pos+cntr+1):
            inum = int(n[i])
            if inum == 9:
                pos = i+1
                cont = cntr
                break
            if tmp<inum:
                tmp = inum
                cont = cntr
                pos = i+1
            cntr -=1
        
        answer.append(n[pos-1])
        lans +=1
        cntr = cont
        if lans == ln -k:
            flag = True
            break
    
    if not flag:
        answer.append(n[pos:])
        
    answer = ''.join(answer)
    
    return answer

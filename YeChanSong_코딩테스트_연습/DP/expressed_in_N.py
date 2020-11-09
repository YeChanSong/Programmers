def recur(N,num,cnt,pssbl):
    if cnt > 8:
        return -1
    if num in pssbl[cnt-1]:
        return cnt
    nxtstp = set()
    tmp = int(str(N)*(cnt+1))
    nxtstp.add(tmp)
    for i in range(len(pssbl)):
        idx = cnt - i - 1
        
        for p in range(4):
            for j in pssbl[i]:
                for k in pssbl[idx]:
                    if p == 0:
                        tmp = j*k
                        if tmp > 0:
                            nxtstp.add(tmp)
                    elif p == 1:
                        tmp = j//k
                        if tmp > 0:
                            nxtstp.add(tmp)
                    elif p == 2:
                        tmp = j+k
                        if tmp > 0:
                            nxtstp.add(tmp)
                    elif p == 3:
                        tmp = j-k
                        if tmp > 0:
                            nxtstp.add(tmp)
    pssbl.append(nxtstp)
    return recur(N,num,cnt+1,pssbl)

def solution(N, number):
    stp1 = set()
    stp1.add(N)
    pssbl = [stp1]
    answer = recur(N,number,1,pssbl)
    return answer
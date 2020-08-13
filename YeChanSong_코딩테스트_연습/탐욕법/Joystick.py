def solution(name):
    answer = 0
    left =0
    right =0
    init = list(name)
    chcklst = [chr(65+i) for i in range(26)]
    step = [ 0 for i in range(len(name))]
    
    cntl = 0
    cntr = 0
    chksm = 0
    
    for i in range(1,len(name)):
        if init[i] == 'A' and chksm == 0:
            chksm =1
            continue
        if init[i] == 'A' and chksm != 0:
            chksm +=1
            continue
        if init[i] != 'A' and chksm != 0:
            if cntr < chksm:
                cntr = chksm
            chksm = 0
            continue
    print(cntr)
    chksm = 0
    for i in range(1,len(name)):
        if init[-i] == 'A' and chksm == 0:
            chksm =1
            continue
        if init[-i] == 'A' and chksm != 0:
            chksm +=1
            continue
        if init[-i] != 'A' and chksm != 0:
            if cntl < chksm:
                cntl = chksm
            chksm = 0
            continue
    print(cntl)
    if cntr >= cntl:
        if init[0] == 'A':
            lttrmvmnt = len(name)-cntr
            if init[-1] == 'A':
                lttrmvmnt -=1
        else:
            if init[1] != 'A' and init[-1] != 'A':
                lttrmvmnt = len(name) -1
            else:
                lttrmvmnt = len(name)-1-cntr
    else:
        if init[0] == 'A':
            lttrmvmnt = len(name)-cntl
            if init[-1] == 'A':
                lttrmvmnt -=1
        else:
            if init[1] != 'A' and init[-1] != 'A':
                lttrmvmnt = len(name) -1
            else:
                lttrmvmnt = len(name)-1-cntl
            
    chksm = 0
    for i in range(len(name)):
        if init[i] != 'A':
            chksm = 1
            break
    if chksm == 0:
        lttrmvmnt = 0
        
    
    
    for i in range(len(name)):
        left = 26 - chcklst.index(init[i])
        right = chcklst.index(init[i])
        if left >= right:
            step[i] = right
        else:
            step[i] = left
    print(step,lttrmvmnt) 
    answer = sum(step) + lttrmvmnt
    
    return answer

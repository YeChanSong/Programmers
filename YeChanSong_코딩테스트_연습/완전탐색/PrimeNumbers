def loop(number):
    li = []
    for i in number:
        li.append(int(i))
    return li

def matchup(li):
    #자릿수
    tmp = []
    for i in range(1,len(li)+1):
        cnt = 0
        if i == 1:
            for j in li:
                for k in range(2,j):
                    if j%k==0:
                        cnt =1
                        break
                if cnt ==0:
                    if j not in tmp and j != 0 and j != 1:
                        tmp.append(j)
                        
                cnt =0
                
        #print("1,",tmp)
        if i == 2:
            #조합
            for j in range(len(li)):
                for k in range(len(li)):
                    if j != k and li[j]!=0:
                        num = int(str(li[j]) + str(li[k]))
                    else:
                        continue
                    #소수 판별
                    for p in range(2,num):
                        if num%p == 0:
                            cnt =1
                            break
                    if cnt ==0:
                        if num not in tmp:
                            tmp.append(num)
                    cnt =0
        #print("2,",tmp)
        if i == 3:
            #조합
            for j in range(len(li)):
                for k in range(len(li)):
                    if j == k:
                        continue
                    for l in range(len(li)):
                        if j == l or k == l:
                            continue
                            
                        if j != k != l and li[j] != 0:
                            num = int(str(li[j]) + str(li[k]) + str(li[l]))
                        else:
                            continue
                        #소수 판별
                        for p in range(2,num):
                            if num%p == 0:
                                cnt =1
                                break
                        if cnt ==0:
                            if num not in tmp:
                                tmp.append(num)
                        cnt =0
            
        #print("3,",tmp)
        if i == 4:
            #조합
            for j in range(len(li)):
                for k in range(len(li)):
                    if j == k:
                        continue
                    for l in range(len(li)):
                        if j == l or k == l:
                            continue
                        for m in range(len(li)):
                            if j == m or k == m or l == m:
                                continue
                            
                            if j != k != l != m and li[j] != 0:
                                num = int(str(li[j]) + str(li[k]) + str(li[l]) + str(li[m]))
                            else:
                                continue
                            #소수 판별
                            for p in range(2,num):
                                if num%p == 0:
                                    cnt =1
                                    break
                            if cnt ==0:
                                if num not in tmp:
                                    tmp.append(num)
                            cnt =0    
            
        #print("4,",tmp)    
        if i == 5:
            #조합
            for j in range(len(li)):
                for k in range(len(li)):
                    if j == k:
                        continue
                    for l in range(len(li)):
                        if j == l or k == l:
                            continue
                        for m in range(len(li)):
                            if j == m or k == m or l == m:
                                continue
                            for n in range(len(li)):
                                if j == n or k == n or l == n or m == n:
                                    continue
                                if j != k != l != m != n and li[j] != 0:
                                    num = int(str(li[j]) + str(li[k]) + str(li[l]) + str(li[m]) + str(li[n]))
                                else:
                                    continue
                                #소수 판별
                                for p in range(2,num):
                                    if num%p == 0:
                                        cnt =1
                                        break
                                if cnt ==0:
                                    if num not in tmp:
                                        tmp.append(num)
                                cnt =0
            
        #print("5,",tmp)
        if i == 6:
            #조합
            for j in range(len(li)):
                for k in range(len(li)):
                    if j == k:
                        continue
                    for l in range(len(li)):
                        if j == l or k == l:
                            continue
                        for m in range(len(li)):
                            if j == m or k == m or l == m:
                                continue
                            for n in range(len(li)):
                                if j == n or k == n or l == n or m == n:
                                    continue
                                for o in range(len(li)):
                                    if j == o or k == o or l == o or m == o or n == o:
                                        continue
                                    if j != k != l != m != n != o and li[j] != 0:
                                        num = int(str(li[j]) + str(li[k]) + str(li[l]) + str(li[m]) + str(li[n]) + str(li[o]))
                                    else:
                                        continue
                                    #소수 판별
                                    for p in range(2,num):
                                        if num%p == 0:
                                            cnt =1
                                            break
                                    if cnt ==0:
                                        if num not in tmp:
                                            tmp.append(num)
                                    cnt =0
            
        #print("6,",tmp)
        if i == 7:
            #조합
            for j in range(len(li)):
                for k in range(len(li)):
                    if j == k:
                        continue
                    for l in range(len(li)):
                        if j == l or k == l:
                            continue
                        for m in range(len(li)):
                            if j == m or k == m or l == m:
                                continue
                            for n in range(len(li)):
                                if j == n or k == n or l == n or m == n:
                                    continue
                                for o in range(len(li)):
                                    if j == o or k == o or l == o or m == o or n == o:
                                        continue
                                    for q in range(len(li)):
                                        if j == q or k == q or l == q or m == q or n == q or o == q:
                                            continue
                                        
                                        if j != k != l != m != n != o != q and li[j] != 0:
                                            num = int(str(li[j]) + str(li[k]) + str(li[l]) + str(li[m]) + str(li[n]) + str(li[o]) + str(li[q]))
                                        else:
                                            continue
                                        #소수 판별
                                        for p in range(2,num):
                                            if num%p == 0:
                                                cnt =1
                                                break
                                        if cnt ==0:
                                            if num not in tmp:
                                                tmp.append(num)
                                        cnt =0
            
        #print("7,",tmp)
        
        
    return tmp            

def solution(numbers):
    answer = 0
    result = []
    init = loop(numbers)
    result = matchup(init)
    answer = len(result)
    print(answer)
    
    return answer

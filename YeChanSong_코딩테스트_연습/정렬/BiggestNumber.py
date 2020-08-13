def sorting(numbers):

    #print(numbers)
    
    for k in range(1,len(numbers)):
        for i in range(k,0,-1):
            flag = True
            #print(numbers[i-1],numbers[i])
            if numbers[i-1] == numbers[i]:
                continue
            tmp = ''
            if len(numbers[i-1]) < len(numbers[i]):
                tmp = numbers[i-1]
                for j in range(len(numbers[i])-len(numbers[i-1])):
                    tmp += numbers[i-1][-1]
                
                for j in range(len(tmp)):
                
                    if tmp[j] > numbers[i][j]:
                        break
                    if tmp[j] < numbers[i][j]:
                        flag = False
                        break
                    if tmp[j] == numbers[i][j]:
                        continue
                
                if flag == False:
                    numbers[i-1], numbers[i] = numbers[i], numbers[i-1]    
                
            elif len(numbers[i-1]) > len(numbers[i]):
                tmp = numbers[i]
                for j in range(len(numbers[i-1])-len(numbers[i])):
                    tmp += numbers[i][-1]
                
                for j in range(len(tmp)):
                
                    if numbers[i-1][j] > tmp[j]:
                        break
                    if numbers[i-1][j] < tmp[j]:
                        flag = False
                        break
                    if numbers[i-1][j] == tmp[j]:
                        continue
                
                if flag == False:
                    numbers[i-1], numbers[i] = numbers[i], numbers[i-1]    
                
            else:
                for j in range(len(numbers[i-1])):
                
                    if numbers[i-1][j] > numbers[i][j]:
                        break
                    if numbers[i-1][j] < numbers[i][j]:
                        flag = False
                        break
                    if numbers[i-1][j] == numbers[i][j]:
                        continue
                
                if flag == False:
                    numbers[i-1], numbers[i] = numbers[i], numbers[i-1]

        #print(numbers)
    res = ''
    for i in numbers:
        res += i
    return res

def solution(numbers):
    answer = ''
    answer = sorting(list(map(str,numbers)))
    
    
    
    return answer

def solution(brown, yellow):
    answer = []
    answer = calculator(brown, yellow)
    return answer

def calculator(border, core):
    x = 0 # 가로 길이
    y = 0 # 세로 길이
    # 조건들
    # y = (border+4)/2 - x
    # core = (x-2) * (y-2)
    # x >= y >= 3
    
    answer = []
    for i in range(3,int((border+4)/2) -3 +1):
        # y condition
        for k in range(3,int((border+4)/2) -3 +1):
            # x condition
            if (i == int((border+4))/2 -k) and (core == (k-2) * (i-2)) and (k >= i >= 3):
                answer.append(k)
                answer.append(i)
            
    return answer

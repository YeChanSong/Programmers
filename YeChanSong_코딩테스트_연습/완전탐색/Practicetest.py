def oneman(answer):
    one = [1,2,3,4,5]
    cnt = 0
    idx = 0
    for i in answer:
        if i == one[idx%5]:
            cnt+=1
            idx+=1
        else:
            idx+=1
            continue
    return cnt

def twoman(answer):
    two = [2,1,2,3,2,4,2,5]
    cnt = 0
    idx = 0
    for i in answer:
        if i == two[idx%8]:
            cnt +=1
            idx +=1
        else:
            idx+=1
            continue
    return cnt

def threeman(answer):
    three = [3,3,1,1,2,2,4,4,5,5]
    cnt =0
    idx =0
    for i in answer:
        if i == three[idx%10]:
            cnt +=1
            idx +=1
        else:
            idx+=1
            continue
    return cnt

def ranker(a,b,c):
    answer = []
    if max(a,b,c) == a:
        answer.append(1)
    if max(a,b,c) == b:
        answer.append(2)
    if max(a,b,c) == c:
        answer.append(3)
            
    return answer

    
def solution(answers):
    answer = []
    a = oneman(answers)
    b = twoman(answers)
    c = threeman(answers)
    print(a,b,c)
    answer = ranker(a,b,c)
    
    
    return answer

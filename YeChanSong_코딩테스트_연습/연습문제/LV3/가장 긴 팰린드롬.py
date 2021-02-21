'''
팰린드롬 구성은 abcba 같은 홀수형이 될 수도, abccba같은 짝수형이 될 수도 있다.
이를 따로 구분해서 계산해준다. 홀수,짝수 구분은 검사하는 문자열 오른쪽과 비교해서 같은지 판별한다.
이때, aaaaa같은 예외를 처리하기 위해서 홀수 검사와 짝수 검사를 같이 수행한다.
'''

def solution(s):
    answer = 1
    lng = len(s)
    for i in range(lng-1):
        if s[i] == s[i+1]:
            l,r = i-1, i+2
            cntr = 2
            while l>=0 and r<lng:
                if s[l]==s[r]:
                    cntr +=2
                    l-=1
                    r+=1
                else:
                    break
            answer = answer>cntr and answer or cntr
            
        l,r = i-1, i+1
        cntr = 1
        while l>=0 and r<lng:
            if s[l] == s[r]:
                cntr +=2
                l-=1
                r+=1
            else:
                break
        answer = answer>cntr and answer or cntr
        
    return answer

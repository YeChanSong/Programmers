import heapq

def solution(jobs):
    answer = 0
    idx = 1
    endtime = 0
    hq = list()
    jobs.sort(key=lambda x:(x[0],x[1])) # 시간 순서대로 jobs가 들어오게끔 정렬 수행
    heapq.heappush(hq,(jobs[0][1],jobs[0][0])) # 가장 처음 들어오는 task를 수행하게끔 미리 push
    while hq:
        c,s = heapq.heappop(hq)
        if endtime<s: # idle한 경우
            answer += c
            endtime = s+c
        else:          # 현재 수행중인 task가 끝나고 바로 pop한 task 처리
            endtime+=c
            answer+=(endtime-s)
            
        while idx<len(jobs): # 다음 task들을 heapq에 입력
            if jobs[idx][0]<endtime: # task가 수행중일 때 들어온 task들을 heapq에 저장
                heapq.heappush(hq,(jobs[idx][1],jobs[idx][0]))
                idx+=1
            else:
                if not hq: 
                    # endtime 이후 들어오는 task에 대한 처리
                    # 즉, idle 상태에서 처음 들어오는 task를 처리하는 부분
                    heapq.heappush(hq,(jobs[idx][1],jobs[idx][0]))
                    idx+=1
                break
    
    answer//=len(jobs)
    return answer
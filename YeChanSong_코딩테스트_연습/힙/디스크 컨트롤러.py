import heapq

def solution(jobs):
    answer = 0
    hq = list()
    stime = 0;lim = len(jobs)
    jobs.sort(key=lambda x:(x[0],x[1]))
    idx = 0
    while idx<lim:
        s,t = jobs[idx]
        idx +=1
        if stime>s:
            heapq.heappush(hq,(t,s))
        elif hq:
            while (hq and stime <=s):
                nt,ns = heapq.heappop(hq)
                answer += (nt+stime-ns)
                stime += nt
            if stime<=s:
                # heapq empty and idle
                stime = t+s
                answer += t
            else:
                # still processing
                heapq.heappush(hq,(t,s))
        else:
            # idle
            stime = t+s
            answer += t
    
    while hq:
        # clearing heapq
        nt,ns = heapq.heappop(hq)
        answer += (nt+stime-ns)
        stime += nt
    
    answer //=lim
    return answer

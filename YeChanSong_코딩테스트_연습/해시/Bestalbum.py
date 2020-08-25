from collections import Counter

def solution(genres, plays):
    answer = []
    genrescntr = Counter()
    playscntr = dict(zip(genres,[{} for i in range(len(genres))]))

    for i in range(len(genres)):
        genrescntr[genres[i]] += plays[i]
        playscntr[genres[i]].update({i:plays[i]})


    for i,v in genrescntr.most_common():
        tmp = sorted(playscntr[i].items(),key=lambda x: x[1],reverse=True)
        if len(tmp) <2:
            answer.append(tmp[0][0])
        else:
            answer.append(tmp[0][0])
            answer.append(tmp[1][0])    




    return answer

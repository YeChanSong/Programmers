#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <utility>
#include <algorithm>
#include <set>

using namespace std;

bool compare(pair<int, int> &p1,  pair<int, int> &p2){
    if(p1.first == p2.first)
        return p1.second < p2.second; // 오름차순 
    
    return p1.first > p2.first; // 내림 차순 
}

/*
    set, map, pair 등 많은 stl을 사용 

    sort 함수에 대한 이해를 하였음. 
    set.count() 괄호 안에 있는 원소가 몇개 인가 
    있으면 0보다 크고 없으면 0 

    pair를 sort 할때 compare 함수를 위와 같은 작성하면 좋을듯. 
*/

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    set<string> s;
    map<string, int> genr_idx;
    
    for(int i=0; i<genres.size(); i++){
        if(s.count(genres[i])==0){
            s.insert(genres[i]);
            pair<string, int> tmp;
            tmp = make_pair(genres[i],plays[i]);
            genr_idx[genres[i]] = plays[i];
        }
        else{
            genr_idx[genres[i]] += plays[i];
        }
        
    }
    vector<pair<int, string> > genr_play;
    map<string, int>::iterator mit;
    for(mit = genr_idx.begin(); mit!=genr_idx.end(); mit++){
        pair<int, string> tmp;
        tmp=make_pair(mit->second, mit->first);
        genr_play.push_back(tmp);
    }
    sort(genr_play.begin(), genr_play.end());
    reverse(genr_play.begin(), genr_play.end());
    
    /////////// 장르 순위 구했음 ////////////
    
    vector<vector<pair<int,int> >  >total;
    for(int i=0; i<genr_play.size(); i++){
        vector<pair<int, int> > tmp;
        for(int j=0; j<genres.size(); j++){
            if(genr_play[i].second == genres[j]){
                pair<int, int> p_tmp;
                p_tmp = make_pair(plays[j],j);
                tmp.push_back(p_tmp);
            }
        }
        total.push_back(tmp);
    }
    
    for(int i=0;  i<total.size(); i++){
        sort(total[i].begin(), total[i].end(), compare);
    }
    
    
    for(int i=0;  i<total.size(); i++){
        for(int j=0; j<total[i].size(); j++){
            if(j<2){
                int num = total[i][j].second;
                answer.push_back(num);
            }
        }
    }
   
    
    
    return answer;
}
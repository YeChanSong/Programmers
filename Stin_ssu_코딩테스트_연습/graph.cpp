#include <string>
#include <vector>
#include <iostream>
#include <utility>
#include <algorithm>

using namespace std;

int *parent;
int size;

bool inrange(int p){
    if(p<0 || p>=size)
        return false;
    else
        return true;
}

int find(int p){
    if(inrange(p)==false){
        return -1;
    }
    
    while(p!=parent[p]){
        p = parent[p];
    }
    return p;
}

void _union(int p, int q){
    int parentP = find(p);
    int parentQ = find(q);
    
    if(parentP == parentQ) 
        return;
    
    parent[parentQ] = parentP;
}

int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    parent = new int[n];
    size = n;
    for(int i=0; i<n; i++){
        parent[i] = i;
    }
    vector<pair<int, vector<int> > > graph;
    
    for(int i=0; i<costs.size(); i++){
        vector<int> tmp;
        pair<int, vector<int> > p_tmp;
        tmp.push_back(costs[i][0]);
        tmp.push_back(costs[i][1]);
        p_tmp = make_pair(costs[i][2], tmp);
        
        graph.push_back(p_tmp);
    }
    
    sort(graph.begin(), graph.end());
    int cnt=0;
    for(int i=0; i<graph.size(); i++){
        int p = graph[i].second[0];
        int q = graph[i].second[1];
        
        if(find(p) != -1 && find(q)!= -1){
            if(find(p) != find(q)){
                _union(p,q);
                cnt++;
                answer+=graph[i].first;
                if(cnt == n-1)
                    break;
            }
        }
    }
    
    
    return answer;
}
//[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]

int main(){
    int n = 4;

    vector< vector<int> > costs;

    for(int i=0 ; i<5; i++){
        vector<int> tmp;
        costs.push_back(tmp);
    }

    costs[0].push_back(0);
    costs[0].push_back(1);
    costs[0].push_back(1);
    costs[1].push_back(0);
    costs[1].push_back(2);
    costs[1].push_back(2);
    costs[2].push_back(1);
    costs[2].push_back(2);
    costs[2].push_back(5);
    costs[3].push_back(1);
    costs[3].push_back(3);
    costs[3].push_back(1);
    costs[4].push_back(2);
    costs[4].push_back(3);
    costs[4].push_back(8);

    solution(n, costs);

}
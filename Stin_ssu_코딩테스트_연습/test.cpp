#include <vector> 
#include <iostream>
#include <stack>
#include <utility>

using namespace std;

int main(){
	vector<pair<int,int> > vp;
	
	for(int i=0; i<5; i++){
		pair<int, int> p;
		p = make_pair(i, i+1);

		vp.push_back(p); 
	}


	for(int i=0; i<vp.size(); i++){
		cout<<vp[i].first<<endl;
	}
}
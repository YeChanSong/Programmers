#include <iostream>
#include <vector>

using namespace std;

/*
1. '1'
    2. '1' - 1개의 1이 있음 -> '11'
    3. '11' - 2개의 1이 있음 -> '21'
    4. '21' - 1개의 2과 1개의 1이 있음 -> '1211'
    5. '1211' - 1개의 1과 1개의 2와 2개의 1이 있음 -> '111221'

 */

int main(){
	string s = "12113";
	//string s = "1";
	string answer = "";

	for(int i=0; i<s.size(); i++){
		int cnt = 1;
		int flag = 0;
		for(int j=i+1; j<s.size(); j++){
			if(s[i] != s[j]){
				i = j-1;
				break;
			}
			else{
				cnt++;
				if(j == s.size() - 1)
					flag = 1;
			}
		}
		cout<<i<<endl;
		answer += to_string(cnt);
		answer += s[i];

		if(flag == 1)
			break;
	}

	cout<<answer<<endl;

}
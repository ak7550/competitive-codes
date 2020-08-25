#include<stdio.h>
#include<string>
using namespace std;
string rem(string str, int index, char ch) // invoking this function definately implies there's some same letters in index and index+1
{
    str.erase(index);
    if(str[index]==str[index+1])
        return rem(str, index, str[index]);
    str.erase(index);
    return str;
}
string removestr(string str, int index)
{
    if(index==strlen(str)-1)
        return str;
    if(str[index]==str[index+1])// one match is found, check if there's any more.
        str=rem(str,index,str[index]); // checks if ther's any same adjacent letter and alse deleltes the adjacent letter as well.
     return removestr(str,index+1);
}
int main()
{
	//code
	int T;
	cin>>T;
	for(int i=0;i<T;i++)
	{
	    getline(cin,str);
	    cout<<removestr(str,0);
	}
	return 0;
}
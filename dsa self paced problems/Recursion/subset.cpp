#include<iostream>
#include<string.h>
using namespace std;
void subset(string str, int index, string current)
{
    if(index==str.length())
    {
        cout<<current<<", ";
        return;
    }
    subset(str,index+1,current); // if index become same as of the length of the string, the recursion will fall into an infinity loop and never stop, never each the condition of printing statement.
    subset(str,index+1,current+str[index]);
}
int main()
{
  string str="abc";
  subset(str,0,"");
  return 0;
}
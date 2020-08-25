#include<iostream>
using namespace std;
int find(int n)
{
    int count=1;
    for(count=1;n&1==1;count++)
      n>>1;
    return count;
}
int main()
{
    int no;
    cout<<"Enter the number: ";
    cin>>no;
    cout<<"Right most bit is present is at: "<<find(no);
    return 0;
}
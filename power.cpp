#include<iostream>
using namespace std;
int power(int n, int r)
{
    if(r==1)
        return n;
    return n*power(n,r-1);
}
int main()
{
  int n,r;
  cin>>n>>r;
  cout<<power(n,r);
  return 0;
}
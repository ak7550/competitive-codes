#include<iostream>
using namespace std;
int findLucky(int number, int increment)
{
    if(number==1)
        return 0;
    else
        return(findLucky(number-1, 1+increment)+increment)%number;
}
int lucky(int number)
{
    return findLucky(number,2);
}
int main()
{
  int n=5;
  cout<<lucky(n);
  return 0;
}

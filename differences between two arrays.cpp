#include<iostream>
//#include<math.h>
using namespace std;
int sum(int a[], int b[], int size)
{
    if(size==0)
        return abs(a[0]-b[0]);
    return abs(a[size]-b[size])+sum(a,b,size-1);
}
int main()
{
  int a[]={1,2,3,4,5};
  int b[]={6,7,8,9,10};
  cout<<"Size of a is: ";
  cout<<"The differences between two arrays is: "<<sum(a,b,sizeof(a)/sizeof(int)-1);
  return 0;
}
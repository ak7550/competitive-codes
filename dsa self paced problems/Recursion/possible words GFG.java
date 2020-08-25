class PossibleWordsG
{  
  public static void main(String args[])
  {
    int arr[]=new int[3];
    arr[0]=7;
    arr[1]=5;
    arr[2]=6;
    PhoneDigits4.possibleWords(arr);
  }
}
class PhoneDigits4
{
  static String[] str = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
  static void possibleWords(int a[]) // N is the size of the array.
  {
      StringBuilder result=new StringBuilder(a.length);
      for (int i = 0; i < a.length; i++) {
          result.append(" ");
      }
      int index=0;
      print(result,a,index);
  }
  static void print(StringBuilder out, int[] a, int index)
  {
      if(index==a.length)//base case
      {
          System.out.print(out+" ");
          return;
      }
      for (int i = 0; i < str[a[index]].length(); i++) {
          out.replace(index,index+1, str[a[index]].substring(i, (i+1)));
          print(out, a, index+1);
      }
  }
}
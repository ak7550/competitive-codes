import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[]) 
    {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner myobj =new Scanner(System.in);
        int T = myobj.nextInt();
      for (int i = 0; i < T; i++) 
      {     // Reading data using readLine 
            String name = System.console().readLine();
            //String name = myobj.next(); 
            StringBuilder str= new StringBuilder(name);
            //System.out.println(str.length());
            System.out.println(GFG.removestr(str,0));
      }
      myobj.close();
  }
  static StringBuilder removestr(StringBuilder str, int index)
  {
        if(index>=str.length()-1) // we reached the end of the string
            return str;
        if(str.charAt(index)==str.charAt(index+1))
            str=GFG.rem(str, index, str.charAt(index)); 
        return GFG.removestr(str, index+1);
  }
  static StringBuilder rem(StringBuilder str, int index, char ch)
  {
    str.deleteCharAt(index);
    //System.out.println(str);
    //System.out.println("index is pointing to: "+str.charAt(index));
    if(str.charAt(index)==str.charAt(index+1))
        return rem(str, index, str.charAt(index));
    str.deleteCharAt(index);
    return removestr(str, index);
  }
}
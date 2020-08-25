import java.util.ArrayList;

class SubsetGFG
{
  public static void main(String args[])
  {
    String str="abc";
    ArrayList<String> sub=new ArrayList<String>();
    sub=NormalClass.subset(str);
    System.out.println("Subsets are: ");
    for (String string : sub) {
        System.out.print(string+" ");
    }
  }
}

class NormalClass
{
    static ArrayList<String> sub=new ArrayList<String>();
    static ArrayList<String> subset(String str)
    {
        find(str,"",sub,0);
        return sub;
    }
    static void find(String str, String s, ArrayList<String> sub, int index)
    {
        if(index==str.length())
        {
            System.out.println("Need to indert into the array: "+ s);
            sub.add(s);
            return;
        }
        find(str, s, sub, index+1);
        find(str, s+str.charAt(index), sub, index+1);
    }
}
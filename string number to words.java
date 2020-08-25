import java.util.Scanner;
class Words
{
  public static void main(String args[])
  {
    Scanner obj=new Scanner(System.in);
    String str=obj.nextLine();
    System.out.println(str);
    String arr[]=str.split(" ");
    str="";
    for (String string : arr) {
        try {
            Integer ii=Integer.parseInt(string);
            string=convert(ii);
            // str.replace(string, string2);
            // System.out.println(string);
        } catch (Exception e) {
            //TODO: handle exception
            // System.out.println("Exception avoided. The String is: "+ string);
        }
        str+=string+" ";
    }
    System.out.println(str.trim());
    obj.close();
  }
  static String convert(Integer value)
  {
      switch (value) {
          case 0:
            return "zero";
          case 1:
            return "one";
          case 2:
            return "two";
          case 3:
            return "three";
          case 4:
            return "four";
          case 5:
            return "five";
          case 6:
            return "six";
          case 7:
            return "seven";
          case 8:
            return "eight";
          case 9:
            return "nine";
          default:
            return null;
      }
  }
}
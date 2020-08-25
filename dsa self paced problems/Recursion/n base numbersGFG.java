class Numbers
{
  public static void main(String args[])
  {
    int base=8, bits=4, index=0;
    StringBuilder buffer= new StringBuilder(bits);
    for (int i = 0; i < buffer.length(); i++) {
        buffer.append(" ");
    }
    System.out.println("All the "+bits+" bit numbers of base "+base+" are: ");
    generate(base,buffer,index);
  }
  static void generate(int base, StringBuilder buffer,int index)
  {
     //base case
     if(index==buffer.length())
     {
         System.out.print(buffer+" ");
         return;
     }
    for (int i = 0; i < buffer.length(); i++) {
        buffer.replace(i, i+1, Integer.toString(index));
        generate(base, buffer, index+1);
    }
  }
}
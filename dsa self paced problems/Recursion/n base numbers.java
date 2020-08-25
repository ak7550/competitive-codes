class Numbers
{
  public static void main(String args[])
  {
    int base=8, bits=4, index=0;
    int[] buffer= new int[bits];
    for (int i = 0; i < buffer.length; i++) {
        buffer[i]=0;
    }
    System.out.println("All the "+bits+" bit numbers of base "+base+" are: ");
    generate(base,buffer,index);
  }
  static void generate(int base, int[] buffer,int index)
  {
      //base case
      if(buffer[0]==base)
        return;
      if (index==buffer.length) 
      {
          print(buffer,base);
          index--;
          incrementPreviousBit(buffer,index,base);
      }
      generate(base, buffer, index+1);
  }
  static void incrementPreviousBit(int[] buffer, int index, int base)
  {
    if(buffer[0]==base) //base case, recursion needs to stop
        return;
    buffer[index]=0;
    index--;
    buffer[index]++;
    if(buffer[index]==base) //base case
        incrementPreviousBit(buffer, index, base);
  }
  static void print(int[] buffer, int base)
  {
      //base case
      if(buffer[buffer.length-1]==base)
        return;
      for (int i = 0; i < buffer.length; i++) {
          System.out.print(buffer[i]);
      }
      System.out.println();//just to take a new line
      buffer[buffer.length-1]++;
      print(buffer, base);
  }
}
class Numbers2
{
  static int base, bits;
  static int[] buffer;
  public static void main(String args[])
  {
    base=8;
    bits=4;
    int index=0;
    buffer= new int[bits];
    for (int i = 0; i < buffer.length; i++) {
        buffer[i]=0;
    }
    System.out.println("All the "+bits+" bit numbers of base "+base+" are: ");
    generate(index);
  }
  static void generate(int index)
  {
      //base case
      if(buffer[0]==base)
        return;
      if (index==buffer.length) 
      {
          print();
          index--;
          incrementPreviousBit(index);
      }
      generate(index+1);
  }
  static void incrementPreviousBit(int index)
  {
    if(buffer[0]==base) //base case, recursion needs to stop
        return;
    buffer[index]=0;
    index--;
    buffer[index]++;
    if(buffer[index]==base) //base case
        incrementPreviousBit(index);
  }
  static void print()
  {
      //base case
      if(buffer[buffer.length-1]==base)
        return;
      for (int i = 0; i < buffer.length; i++) {
          System.out.print(buffer[i]);
      }
      System.out.println();//just to take a new line
      buffer[buffer.length-1]++;
      print();
  }
}
class Comb
{
  static String str;
  static StringBuilder st,output;
  public static void main(String args[])
  {
    str="abcd";
    combination(str);
  }
  static void combination(String str)
  {
      st=new StringBuilder(str.length());
      for(int i=0;i<str.length();i++)
        st.append(str.charAt(i));
      output=new StringBuilder(str.length());
      System.out.println("String to find combination is: "+st);
      findCombination();
  }
  static void findCombination()
  {
    if(st.length()==0)//base case
      System.out.print(output+" ");
    for(int i=0; i<st.length();i++)
    {
      swap(st,i); // in java, it's always reference.
      output.append(st.charAt(0));
      st.deleteCharAt(0);
      findCombination();
      getreturn(st,output);
      swap(st, i);
    }
  }
  static void swap(StringBuilder st, int index)
  {
    String firstChar=st.substring(0,1);
    String indexChar=st.substring(index,index+1);
    st.replace(0, 1, indexChar);
    st.replace(index, index+1, firstChar);
  }
  static void getreturn(StringBuilder st, StringBuilder output)
  { // work in it
    String lastElement=output.substring(output.length()-1);
    // st.append(lastElement);
    //append func adds the char at the end of the string, but we need to add it at the 0th index.
    st.insert(0, lastElement);
    output.deleteCharAt(output.length()-1);
  }
} 
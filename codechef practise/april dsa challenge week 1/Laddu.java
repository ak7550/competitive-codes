import java.util.*;
public class Laddu {
	public static void main (String[] args){
		// your code goes here
		try {
		Scanner sc= new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0){
		    int activities=sc.nextInt();
		    boolean isIndian=sc.next().equals("INDIAN");
		    sc.nextLine();
		    int laddu=0;
		    for (int i=0; i<activities; i++){
		        String name=sc.next();
		        if(name.equals("CONTEST_WON")) laddu+=(300+Math.max(0, 20-sc.nextInt()));
		        else if (name.equals("TOP_CONTRIBUTOR")) laddu+=300;
		        else if (name.equals("BUG_FOUND")) laddu+=sc.nextInt();
		        else if (name.equals("CONTEST_HOSTED")) laddu+=50;
		    }
		    System.out.println((isIndian)?laddu/200:laddu/400);
		}
		}catch(Exception e) {
		}
	}
}

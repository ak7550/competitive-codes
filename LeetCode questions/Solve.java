public class Solve {
    static int count ;

    public static void main(String[] args) {
        count = 0;
        int x = 10, y = 7;
        fun(x, y);
        System.out.println(count);
    }

    public static int fun(int x, int y) {
        count++;
        if (x < y)
            return fun(y, x);
            else if(y!=0)
            {
                int z = fun(x, y - 1);
                z += x;
                return z;
            }
            else
                return 0;
    }

}

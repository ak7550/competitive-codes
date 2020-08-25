class Hanoi
{
 long moves=0;;
 void toh(int n, int from, int to, int aux)
  {
    if(n==1)
    {
        System.out.println("move disk "+n+" from rod "+from+" to rod "+to);
        return;
    }
    int k=to;
    to=aux;
    aux=k;
    toh(n-1,from,to,aux);
    System.out.println("move disk "+n+" from rod "+from+" to rod "+to);
    moves++;
    int x=from;
    from=aux;
    aux=x;
    toh(n-1,from,to,aux);
  }
}  
class className2
{
  public static void main(String args[])
  {
    Hanoi h=new Hanoi();
    h.toh(4,1,3,2);
    System.out.println("Total number of moves are: "+h.moves);
  }
} 
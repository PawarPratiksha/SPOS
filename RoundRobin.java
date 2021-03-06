/*Round Robin Scheduling in Java*/
import java.util.Scanner;
 
public class RoundRobin {
        
    public static void main(String args[]) {
            Scanner s = new Scanner(System.in);
 
          int wtime[],btime[],rtime[],num,quantum,total;
 
          wtime = new int[10];
          btime = new int[10];
          rtime = new int[10];
 
System.out.print("Enter number of processes(MAX 10): ");
num = s.nextInt();
System.out.print("Enter burst time");
for(int i=0;i<num;i++) { System.out.print("\nP["+(i+1)+"]: "); btime[i] = s.nextInt(); rtime[i] = btime[i]; wtime[i]=0; } System.out.print("\n\nEnter quantum: "); quantum = s.nextInt(); int rp = num; int i=0; int time=0; System.out.print("0"); wtime[0]=0; while(rp!=0) { if(rtime[i]>quantum)
 {
   rtime[i]=rtime[i]-quantum;
   System.out.print(" | P["+(i+1)+"] | ");
   time+=quantum;
   System.out.print(time);
   }
 else if(rtime[i]<=quantum && rtime[i]>0)
 {time+=rtime[i];
  rtime[i]=rtime[i]-rtime[i];
  System.out.print(" | P["+(i+1)+"] | ");
  rp--;
System.out.print(time);
 }
 
i++;
if(i==num)
{
i=0;
}
 
}
 
 
        }
}
/*output
unix@unix-HP-280-G1-MT:~$ javac RoundRobin.java
unix@unix-HP-280-G1-MT:~$ java RoundRobin
Enter number of processes(MAX 10): 4 
Enter burst time
P[1]: 4

P[2]: 5

P[3]: 8

P[4]: 2


Enter quantum: 4
0 | P[1] | 4 | P[2] | 8 | P[3] | 12 | P[4] | 14 | P[2] | 15 | P[3] | 19unix@unix-HP-280-G1-MT:~$ 
*/

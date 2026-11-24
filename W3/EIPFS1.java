import java.util.Scanner;

public class EIPFS1 {
public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    StringBuilder sb= new StringBuilder();
    int elem=sc.nextInt();
    int[]arr=new int[elem];
    for (int i = 0; i < arr.length; i++) {
        arr[i]=sc.nextInt();
    }
    int[] pf1=new int[elem];
    for (int i = 0; i < pf1.length; i++) {
        if(i<1){
            pf1[i]=arr[0];
            sb.append(pf1[i]+" ");
            continue;
        }else{
            pf1[i]=pf1[i-1]+arr[i];
            sb.append(pf1[i]+" ");
        }
    }
    System.out.println(sb);
}
}
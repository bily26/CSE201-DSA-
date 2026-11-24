import java.util.Arrays;
import java.util.Scanner;

public class EIUGIFT1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb= new StringBuilder();
        int gifts= sc.nextInt();
        int papers= sc.nextInt();
        int[] listGif= new int[gifts];
        int[] listPape= new int[papers];
        for (int i = 0; i < listGif.length; i++) {
            listGif[i]=sc.nextInt();
        }
        for (int i = 0; i < listPape.length; i++) {
            listPape[i]=sc.nextInt();
        }

        Arrays.sort(listGif);
        Arrays.sort(listPape);

        int ableWrap = 0;
        int i = 0,j = 0;
        while(i<listGif.length && j<listPape.length){
            if(listPape[j]<2*listGif[i]){
                j++;
            }else if(listPape[j]>3*listGif[i]){
                i++;
            }
            //ListGif >=3* gift && ListGif <=2* gift
            else {
                ableWrap++;
                i++;
                j++;
            }
            
        }
        System.out.println(ableWrap);
    }
}

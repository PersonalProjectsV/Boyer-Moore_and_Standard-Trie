import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws Exception {
        File file=new File("Boyer_Moore/comparison.txt");
        String text="";
        String pattern="";
        Scanner comparison=new Scanner(file);
        int iter=0;
        while (comparison.hasNextLine()){
            String string=comparison.nextLine();
            if(iter==0)
                text=string;
            else
                pattern=string;

            iter++;
        }
        System.out.println("Index where substring occurs:  "+boyerM(text,pattern));
    }
    private static int boyerM(String text,String pattern){
        int m=pattern.length();
        int i=pattern.length()-1;
        int j=pattern.length()-1;
        int n=text.length();
        while (i<n-1){
            if(pattern.charAt(j)==text.charAt(i)){
                if(j==0)
                    return i;
                else {
                    i--;
                    j--;
                }
            }
            else {
                i=i+m-Integer.min(j,1+last(text.charAt(i),pattern));
                j=m-1;
            }
        }
        return -1;
    }
    private static int last(Character look,String checking){
        for (int x=checking.length()-1;x>=0;x--){
            if(checking.charAt(x)==look){
                return x;
            }
        }
        return -1;
    }

}

/*
@Cazacu Razvan-Nicusor
 */

package lab1;
import java.util.Arrays;
import java.util.Random;
public class Main {
    // BONUS (VERIFICARE GRAF CONEX FOLOSING MATRICEA DE ADIACENTA)
    public static boolean isConnected(boolean[][] matrix){
        int visited[]=new int[matrix.length];
        for(int row=0; row< matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col] == true && visited[row] == 0) {
                    visited[row] = 1;
                }
            }
        }
        boolean connected = false;
        for (int vertex = 0; vertex < matrix.length; vertex++)
        {
            if (visited[vertex] == 1)
            {
                connected = true;
            } else
            {
                connected = false;
                break;
            }
        }
        return connected;
    }

    public static int sumRow(boolean[][] matrix, int row)
    {
        int sum = 0;
        for(int i = 0; i < matrix[row].length; i++)
        {
            if(matrix[row][i]==true){sum=sum+1;}
        }
        return sum;
    }
    public static void print2D(boolean mat[][])
    {
        for (boolean[] row : mat)

            // Convert in string si apoi printare pe linii separate
            System.out.println(Arrays.toString(row));
    }
    public static int verifyNeighbor(String s1,String s2)
    {
        for(int i=0;i<s1.length();i++)
        {
            char ch1=s1.charAt(i);
            for(int j=0;j<s2.length();j++)
            {
                char ch2=s2.charAt(j);
                if(ch1==ch2){return 1;}
            }
        }
        return 0;
    }
    private static String createRandomWord(int len, char[] alphabet)
    {
        StringBuilder word = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < len; i++)
        {
            int k = rand.nextInt(alphabet.length);
            word.append(alphabet[k]);
        }
        return word.toString();
    }
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        if (args.length < 3) {
            System.out.println("Usage: number, number, one or more characters");
            System.exit(-1);
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int m = args.length - 2;
        char alphabet[] = new char[m];
        for (int i = 0; i < m; i++) {
            alphabet[i] = args[i + 2].charAt(0);
        }
        String[] words=new String[n];
        for (int j=0; j<n ;j++)
        {
            words[j]=createRandomWord(k,alphabet);
        }
        int size=words.length;
        System.out.println("Vectorul de cuvinte este : ");
        for (int p=0;p<size;p++)
        {
            System.out.println(words[p]);
        }
        boolean[][] matrix=new boolean[n][n];
        for(int p=0;p<n;p++)
        {
            for(int c=0;c<n;c++)
            {
                matrix[p][c]=false;
            }
        }
        for(int p=0;p<n;p++)
        {
            for(int c=0;c<n;c++)
            {
                if(verifyNeighbor(words[p],words[c])==1){
                    matrix[p][c]=true;
                }
            }
        }

        System.out.println("Matricea de adiacenta (vecini) este : ");
        //print2D(matrix);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        /*int max=-1;
        int min=1_000_000;
        int rowMax=0;
        int rowMin=0;
        int maxi=-1;
        int mini=1_000_000;
        int[] noNeighbors=new int[n];
        for(int i=0;i<n;i++)
        {
            if(sumRow(matrix,i)>max){
                max=sumRow(matrix,i);
                rowMax=i;
            }
            if(sumRow(matrix,i)<min){
                min=sumRow(matrix,i);
                rowMin=i;
            }
            noNeighbors[i]=sumRow(matrix,i);
            if(noNeighbors[i]>maxi){maxi=noNeighbors[i];}
            if(noNeighbors[i]<mini){mini=noNeighbors[i];}
        }
        System.out.println("Cuvintele cu nr maxim de vecini este : ");
        for(int i=0;i<n;i++)
        {
            if (noNeighbors[i]==maxi){System.out.print(words[i]+" ,");
                }
        }
        System.out.println();
        System.out.println("Cuvintele cu nr minim de vecini este : ");
        for(int i=0;i<n;i++)
        {
            if (noNeighbors[i]==mini){System.out.print(words[i]+" ,");
                }
        }
        System.out.println();
        boolean ok=true;
        int first=noNeighbors[0];
        for(int i=0; i<n && ok ;i++)
        {
            if(noNeighbors[i]!=first){ok=false;}
        }
        if(ok==true)
        {System.out.println("Toate cuvintele au acelasi nr de vecini ! ");}*/

        // BONUS (VERIFICARE GRAF CONEX FOLOSING MATRICEA DE ADIACENTA)
        boolean result=isConnected(matrix);
        if(result)
        {
            System.out.println("The graph is connected");
        }
        else{
            System.out.println("The graph is not connected");
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }

}



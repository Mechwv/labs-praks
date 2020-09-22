package praktika.Prak5;

import java.util.Scanner;

public class Recursion {
    public static Scanner scanner = new Scanner(System.in);
    // summa cifr chisla
    public static int task_5(long n, int cnt){
        cnt += n % 10;
        n /= 10;
        if (n>0)
            return task_5(n,cnt);
        return cnt;
    }
    //razvorot chisla
    public static int task_10(int n, int cnt){
        cnt = (cnt * 10) + (n % 10);
        n /=10;
        if (n>0)
            return task_10(n,cnt);
        return cnt;
    }
    //kol-vo elementov ravnyh maksimumu
    public static int task_16(int cnt, int max){
        int n = scanner.nextInt();
        if (n == 0) return cnt;
        if (n > max){
            cnt = 1;
            max = n;
        }
        else if (n == max){
            cnt++;
        }
        return task_16(cnt,max);
    }




    public static void main(String[] args) {
        System.out.print(task_5(1010101,0) + "\n");
        System.out.print(task_10(1234567,0) + "\n");
        System.out.print("Vvedite stroku chisel:\n");
        System.out.print(task_16(1,0));
    }
}


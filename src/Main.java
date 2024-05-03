import java.util.HashSet;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Init.initialize();
        System.out.print("Masukkan String Awal : "); String startWord = sc.nextLine();
        System.out.print("Masukkan String Akhir : "); String destWord = sc.nextLine();

        while (startWord.length() != destWord.length()){
            System.out.println("Panjang string berbeda! Tolong masukkan ulang input.");
            System.out.print("Masukkan String Awal : "); startWord = sc.nextLine();
            System.out.print("Masukkan String Akhir : "); destWord = sc.nextLine();
        }
        System.out.println(Init.Dictionary.size());
        Init.filter(startWord.length());
        System.out.println(Init.Dictionary.size());

        System.out.println("Masukkan Algoritma yang hendak dipilih.");
        System.out.println("1. UCS\n2. GBFS\n3. A*");
        System.out.print("Input pilihan (1/2/3) : "); Integer algo = sc.nextInt();
        while (algo <= 0 && algo >= 4) {
            System.out.println("Input tidak valid! Tolong masukkan ulang input.");
            System.out.print("Input pilihan (1/2/3) : "); algo = sc.nextInt();
        }

        if (algo == 1) UCS.solve(startWord, destWord);
        else if (algo == 2) GBFS.solve(startWord, destWord);
        else AStar.solve(startWord, destWord);

        sc.close();
    }
}
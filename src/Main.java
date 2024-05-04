import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Init.initialize();
        System.out.print("Masukkan String Awal : "); String startWord = sc.nextLine();
        System.out.print("Masukkan String Akhir : "); String destWord = sc.nextLine();

        if (!Init.hasNeighbour(destWord)) System.out.println("jembut");

        while (startWord.length() != destWord.length() || startWord.equals(destWord) || !Init.Dictionary.contains(startWord) || !Init.Dictionary.contains(destWord) || !Init.hasNeighbour(destWord) || !Init.hasNeighbour(startWord)){
            if (startWord.equals(destWord)) System.out.println("String start dan destinasi sama! Tolong masukkan ulang input.");
            else if (!Init.Dictionary.contains(startWord) || !Init.Dictionary.contains(destWord)) System.out.println("String start/destinasi tidak terdaftar di dictionary! Tolong masukkan ulang input.");
            else if (startWord.length() != destWord.length()) System.out.println("Panjang string berbeda! Tolong masukkan ulang input.");
            else System.out.println("String start/destinasi tidak mempunyai tetangga! Tolong masukkan ulang input.");
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

        long startTime = System.nanoTime();
        if (algo == 1) UCS.solve(startWord, destWord);
        else if (algo == 2) GBFS.solve(startWord, destWord);
        else AStar.solve(startWord, destWord);
        System.out.println("Waktu dibutuhkan : " +  (System.nanoTime()-startTime)/1000000 + "ms");

        sc.close();
    }
}
# Penyelesaian Permainan Word Ladder dengan Algoritma UCS, GBFS, dan A*
Tugas Kecil 3 IF2211 Strategi Algoritma 
Semester II tahun 2023/2024

M Athaullah Daffa Kusuma M (13522044)

## Deskripsi Singkat
Program ini merupakan tugas kecil 3 dari mata kuliah IF2211 Strategi Algoritma. Program ini berfungsi untuk menyelesaikan permainan word ladder. Program akan menyelesaikan permainan dengan 3 Algoritma pilihan, yaitu UCS, GBFS, dan A*.

## Informasi Tambahan
Program dibuat dengan : Java 20.0.2 (JDK20)<br />
IDE yang digunakan : Visual Studio Code dengan banyak extension lainnya<br />
Laporan dibuat dengan : Google Docs <br />
OS dari device yang digunakan : Windows

## Petunjuk Cara Menjalankan Program dan lainnya

### Cara Menjalankan Program
masuk ke folder bin dengan perintah
```
cd bin
```
lalu jalankan Main.class dengan perintah
```
java Main
```
<br /><br /> atau dengan mengcompile manual kembali <br /> <br /><br />
masuk ke folder src dengan perintah
```
cd src
```
lalu compile semua java file dengan
```
javac AStar.java GBFS.java Init.java Main.java NodeGraf.java UCS.java
```
jalankan Main.class dengan perintah
```
java Main
```

### Input melalui CLI
Cukup memasukkan input ke CLI sesuai instruksi yang diprint oleh program, masukan berupa String start dan String destinasi, dan Algoritma yang dipilih (UCS/GBFS/A* dengan 1/2/3).
### Output CLI message
Ketika program selesai dijalankan, hasilnya berupa path yang dihasilkan, node yang dikunjungi, panjang path, juga sebuah message berupa lama waktu eksekusi Algoritma yang dipilih.

## Commit Messages

Untuk type mengikuti semantic berikut.

- `feat`: (new feature for the user, not a new feature for build script)
- `fix`: (bug fix for the user, not a fix to a build script)
- `docs`: (changes to the documentation)
- `style`: (formatting, missing semi colons, etc; no production code change)
- `refactor`: (refactoring production code, eg. renaming a variable)
- `test`: (adding missing tests, refactoring tests; no production code change)
- `chore`: (updating grunt tasks etc; no production code change)

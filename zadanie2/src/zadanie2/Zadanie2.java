/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Math.*;
import java.util.Scanner; //do wczytawania z klawiatury

/**
 *
 * @author pawel
 */
public class Zadanie2 {

    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);
    
    public static double[][] wczytaj_figure() {
        System.out.print("Podaj ilosc wierzcholkow: ");

        int wielkosc; //ilosc wierzcholkow
        wielkosc = scan.nextInt();

        double tablica[][] = new double[wielkosc][2];

        for (int i = 0; i < wielkosc; i++) {
            System.out.println("wierzcholek: " + (i + 1));
            System.out.print("x: ");
            tablica[i][0] = scan.nextDouble();
            System.out.print("y: ");
            tablica[i][1] = scan.nextDouble();
        }

        return tablica;
    }

    public static double[][] wypisz_tablice(double tablica[][]) {
        for (int i = 0; i < tablica.length; i++) {
            System.out.println("Wierzcholek " + (i + 1) + " x:" + tablica[i][0]);
            System.out.println("Wierzcholek " + (i + 1) + " y:" + tablica[i][1]);
            System.out.println();
        }
        return tablica;
    }

    public static double oblicz_obwod(double tablica[][]) {
        double wynik = 0;
        for (int i = 0; i < tablica.length - 1; i++) {
            wynik = wynik + Math.sqrt((tablica[i + 1][0] - tablica[i][0]) * (tablica[i + 1][0] - tablica[i][0]) + (tablica[i + 1][1] - tablica[i][1]) * (tablica[i + 1][1] - tablica[i][1]));
        }

        wynik = wynik + Math.sqrt((tablica[0][0] - tablica[tablica.length - 1][0]) * (tablica[0][0] - tablica[tablica.length - 1][0]) + (tablica[0][1] - tablica[tablica.length - 1][1]) * (tablica[0][1] - tablica[tablica.length - 1][1]));

        return wynik;
    }

    public static double oblicz_pole(double tablica[][]) {
        double pole = 0;

        for (int i = 0; i < tablica.length - 1; i++) {
            pole = pole + ((tablica[i][1] + tablica[i + 1][1]) * (tablica[i][0] - tablica[i + 1][0])) / 2;
        }

        pole = pole + ((tablica[0][1] + tablica[tablica.length - 1][1]) * (tablica[0][0] - tablica[tablica.length - 1][0])) / 2;

        return abs(pole);
    }

    public static void zapis_do_pliku(double tablica[][]) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("figura.txt");
        out.println("# plotting_data1.dat");
        out.println("# x y");
        for (int i = 0; i < tablica.length; i++) {
            out.println(tablica[i][0] + " " + tablica[i][1]);
        }
        out.close();
    }

    public static double[][] obrot_o_kat(double oryginal[][]) {

        System.out.println("Obrót o kąt alfa względem punktu (a,b): ");

        //kopiowanie tablicy
        int length = oryginal.length;
        double[][] tablica = new double[length][oryginal[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(oryginal[i], 0, tablica[i], 0, oryginal[i].length);
        }

        for (int i = 0; i < tablica.length; i++) {
            System.out.println("Wierzcholek (kopia)" + (i + 1) + " x:" + tablica[i][0]);
            System.out.println("Wierzcholek (kopia)" + (i + 1) + " y:" + tablica[i][1]);
            System.out.println();
        }

        // obrót o kąt alfa względem punktu (a,b)
        System.out.print("Podaj kąt alfa (w stopniach): ");
        double alfa; //kąt alfa w stopniach
        alfa = 0;
        alfa = scan.nextDouble();

        System.out.print("Podaj współrzędną x punktu: "); //współrzędną x punktu
        double a;
        a = scan.nextDouble();

        System.out.print("Podaj współrzędną y punktu: "); //współrzędną y punktu
        double b;
        b = scan.nextDouble();

        for (int i = 0; i < tablica.length; i++) {
            tablica[i][0] = ((tablica[i][0]) - a) * Math.cos(Math.toRadians(alfa)) - ((tablica[i][1]) - b) * Math.sin(Math.toRadians(alfa)) + a; //x' = (x-a)*cos(alfa) - (y-b)*sin(alfa) + a
            tablica[i][1] = ((tablica[i][0]) - a) * Math.sin(Math.toRadians(alfa)) + ((tablica[i][1]) - b) * Math.cos(Math.toRadians(alfa)) + b; //y' = (x-a)*sin(alfa) + (y-b)*cos(alfa) + b
        }
    // wypisywanie
        wypisz_tablice(tablica);

        return tablica;
    }

    public static double[][] przesuniecie_o_wektor(double oryginal[][]) {

        System.out.println("Przesunięcie punktu o podany wektor: ");

        //kopiowanie tablicy
        int length = oryginal.length;
        double[][] tablica = new double[length][oryginal[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(oryginal[i], 0, tablica[i], 0, oryginal[i].length);
        }

        for (int i = 0; i < tablica.length; i++) {
            System.out.println("Wierzcholek (kopia)" + (i + 1) + " x:" + tablica[i][0]);
            System.out.println("Wierzcholek (kopia)" + (i + 1) + " y:" + tablica[i][1]);
            System.out.println();
        }

        // przesunięcie punktu o podany wektor
        System.out.print("Podaj wartość x wektora: "); //współrzędną x wektora
        double a;
        a = scan.nextDouble();

        System.out.print("Podaj wartość y wektora: "); //współrzędną y wektora
        double b;
        b = scan.nextDouble();

        for (int i = 0; i < tablica.length; i++) {
            tablica[i][0] = (tablica[i][0]) + a;
            tablica[i][1] = (tablica[i][1]) + b;
        }
    // wypisywanie
        wypisz_tablice(tablica);

        return tablica;
    }

    public static double[][] podobienstwo_z_zadana_skala(double oryginal[][]) {

        System.out.println("Podobieństwo z zadaną skalą k wględem punktu (a,b): ");

        //kopiowanie tablicy
        int length = oryginal.length;
        double[][] tablica = new double[length][oryginal[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(oryginal[i], 0, tablica[i], 0, oryginal[i].length);
        }

        for (int i = 0; i < tablica.length; i++) {
            System.out.println("Wierzcholek (kopia)" + (i + 1) + " x:" + tablica[i][0]);
            System.out.println("Wierzcholek (kopia)" + (i + 1) + " y:" + tablica[i][1]);
            System.out.println();
        }

        // podobieństwo z zadaną skalą k wględem punktu (a,b)
        System.out.print("Podaj współrzędną x punktu: "); //współrzędną x punktu
        double a;
        a = scan.nextDouble();

        System.out.print("Podaj współrzędną y punktu: "); //współrzędną y punktu
        double b;
        b = scan.nextDouble();

        System.out.print("Podaj skalę podobieństwa k: "); //skala k
        double k;
        k = scan.nextDouble();

        for (int i = 0; i < tablica.length; i++) {
            tablica[i][0] = (k * ((tablica[i][0]) - a)) + a; // x' = k * (x - a) + a;
            tablica[i][1] = (k * ((tablica[i][1]) - b)) + b; // x' = k * (y - b) + b;
        }
    // wypisywanie
        wypisz_tablice(tablica);

        return tablica;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here

        double[][] wierzcholki = wczytaj_figure(); //tablica ze wspolrzednymi wierzcholkow
        wypisz_tablice(wierzcholki);
        System.out.println("obwód: " + oblicz_obwod(wierzcholki));
        System.out.println("pole: " + oblicz_pole(wierzcholki));
        zapis_do_pliku(wierzcholki);

        obrot_o_kat(wierzcholki); // w tablicy zapisane nowe współrzędne wierzchołków

        przesuniecie_o_wektor(wierzcholki); // przesuwa o wektor

        podobienstwo_z_zadana_skala(wierzcholki); //podobieństwo z zadaną skalą

        scan.close();
    }

}

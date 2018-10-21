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
    public static double[][] wczytaj_figure() {  
        System.out.print("Podaj ilosc wierzcholkow: ");
        Scanner scan = new Scanner(System.in); //do wczytawania z klawiatury
        
        int wielkosc; //ilosc wierzcholkow
        wielkosc = scan.nextInt();
        
        double tablica[][] = new double[wielkosc][2];
        
        for (int i = 0; i<wielkosc; i++)
        {
            System.out.println("wierzcholek: " + (i+1));
            System.out.print("x: ");
            tablica[i][0]=scan.nextDouble();
            System.out.print("y: ");
            tablica[i][1]=scan.nextDouble();
        }
        
        
        scan.close(); //zakonczenie wczytawania z klawiatury
        return tablica; 
}
    
    public static double[][] wypisz_tablice(double tablica[][]) {
        for(int i=0;i<tablica.length;i++)
        {
            System.out.println("Wierzcholek "+i+" x:"+tablica[i][0]);
            System.out.println("Wierzcholek "+i+" y:"+tablica[i][1]);
        }
        return tablica;
    }
    
    public static double oblicz_obwod(double tablica[][]){
        double wynik = 0;
        for(int i = 0; i<tablica.length-1;i++)
        {
            wynik =  wynik + Math.sqrt((tablica[i+1][0]-tablica[i][0])*(tablica[i+1][0]-tablica[i][0])+(tablica[i+1][1]-tablica[i][1])*(tablica[i+1][1]-tablica[i][1]));
        }
        
        wynik = wynik + Math.sqrt((tablica[0][0]-tablica[tablica.length-1][0])*(tablica[0][0]-tablica[tablica.length-1][0])+(tablica[0][1]-tablica[tablica.length-1][1])*(tablica[0][1]-tablica[tablica.length-1][1]));
        
        return wynik;
    }
    
    public static double oblicz_pole(double tablica[][]){
        double pole = 0;
        
        for(int i =0; i<tablica.length-1; i++)
        {
            pole = pole + ((tablica[i][1]+tablica[i+1][1])*(tablica[i][0]-tablica[i+1][0]))/2;
        }
        
        pole = pole + ((tablica[0][1]+tablica[tablica.length-1][1])*(tablica[0][0]-tablica[tablica.length-1][0]))/2;
        
        return abs(pole);
    }
    
   public static double[][] obrot_o_kat (double tablica[][]){
       
       
        System.out.print("Podaj kąt alfa (w stopniach): ");
        Scanner scan = new Scanner(System.in); 
        double alfa; //kąt alfa w stopniach
        alfa = scan.nextInt();
        scan.close(); //zakonczenie wczytawania z klawiatury
        
        for(int i =0; i<tablica.length-1; i++)
        {
         tablica[i][0] = (tablica[i][0]) * Math.cos(Math.toRadians(alfa)) - (tablica[i][1]) *  Math.sin(Math.toRadians(alfa)); //x' = x*cos(alfa) - y*sin(alfa)
         tablica[i][1] = (tablica[i][0]) * Math.sin(Math.toRadians(alfa)) + (tablica[i][1]) *  Math.cos(Math.toRadians(alfa)); //y' = x*sin(alfa) - y*cos(alfa)
        }
        
        return tablica;
    }
    
    public static void zapis_do_pliku(double tablica[][]) throws FileNotFoundException{
        PrintWriter out = new PrintWriter("figura.txt");
        out.println("# plotting_data1.dat");
        out.println("# x y");
        for(int i=0;i<tablica.length;i++)
        {
            out.println(tablica[i][0]+" "+tablica[i][1]);
        }
        out.close();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        double[][] wierzcholki = wczytaj_figure(); //tablica ze wspolrzednymi wierzcholkow
        wypisz_tablice(wierzcholki);
        System.out.println("obwód: "+oblicz_obwod(wierzcholki));
        System.out.println("pole: "+oblicz_pole(wierzcholki));
        zapis_do_pliku(wierzcholki);
        obrot_o_kat (wierzcholki); // w tablicy zapisane nowe współrzędne wierzchołków
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie2;

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
            wynik =  wynik + Math.sqrt((tablica[i+1][0]-tablica[i][0])+(tablica[i+1][1]-tablica[i][1]));
        }
        
        wynik = wynik + Math.sqrt((tablica[tablica.length-1][0]-tablica[tablica.length-1][0])+(tablica[0][1]-tablica[0][1]));
        
        return wynik;
    }
    
    public static double oblicz_pole(double tablica[][]){
        double pole = 0;
        
        return pole;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        double[][] wierzcholki = wczytaj_figure(); //tablica ze wspolrzednymi wierzcholkow
        wypisz_tablice(wierzcholki);
        System.out.print("obwód: "+oblicz_obwod(wierzcholki));
    }
    
}

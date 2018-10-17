/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadanie2;

import java.util.Scanner; //do wczytawania z klawiatury

/**
 *
 * @author pawel
 */
public class Zadanie2 {

    /**
     * @param args the command line arguments
     */
    public static int[][] wczytaj_figure() {  
        System.out.println("Podaj ilosc wierzcholkow: ");
        Scanner scan = new Scanner(System.in); //do wczytawania z klawiatury
        
        int wielkosc; //ilosc wierzcholkow
        wielkosc = scan.nextInt();
        
        int tablica[][] = new int[wielkosc][2];
        
        for (int i = 0; i<wielkosc; i++)
        {
            System.out.println("wierzcholek: " + (i+1));
            System.out.println("x: ");
            tablica[i][0]=scan.nextInt();
            System.out.print("y: ");
            tablica[i][1]=scan.nextInt();
        }
        
        
        scan.close(); //zakonczenie wczytawania z klawiatury
        return tablica; 
}
    
    public static int[][] wypisz_tablice(int tablica[][]) {
        for(int i=0;i<tablica.length;i++)
        {
            System.out.println("Wierzcholek "+i+" x:"+tablica[i][0]);
            System.out.println("Wierzcholek "+i+" y:"+tablica[i][1]);
            System.out.println();
        }
        return tablica;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int[][] wierzcholki = wczytaj_figure(); //tablica ze wspolrzednymi wierzcholkow
        wypisz_tablice(wierzcholki);
    }
    
}

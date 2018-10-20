package zadanie2;

import java.util.Scanner; //do wczytawania z klawiatury
import javax.swing.*; //do interface'u graficznego
import java.awt.*;  //do grafiki 2D
import java.awt.geom.*;

public class Zadanie2 extends JFrame {

    JButton confirm = new JButton("Zatwierdź"); //tworzenie obiektu przycisku
    GeneralPath polygon = new GeneralPath();    //tworzenie obiektu dla wielokąta
    
    // konstruktor klasy Zadanie2
    public Zadanie2() {
        setTitle("Zadanie 2 z MMI");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        JPanel contener = new JPanel(); //tworzenie kontenera
        contener.add(confirm);  //dodawanie przycisku do kontenera
        add(contener);  //dodanie kontenera do ramki
        setVisible(true);

    }

    //ustawienie wyglądu i działania okienka przy użyciu widoku "Windows" + wyjątek klasy Exception
    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception exc) {
        }
    }

    
    public static int[][] wczytaj_figure() {
        System.out.println("Podaj ilosc wierzcholkow: ");
        Scanner scan = new Scanner(System.in); //do wczytawania z klawiatury

        int wielkosc; //ilosc wierzcholkow
        wielkosc = scan.nextInt();

        int tablica[][] = new int[wielkosc][2];

        for (int i = 0; i < wielkosc; i++) {
            System.out.println("wierzcholek: " + (i + 1));
            System.out.print("x: ");
            tablica[i][0] = scan.nextInt();
            System.out.print("y: ");
            tablica[i][1] = scan.nextInt();
        }

        scan.close(); //zakonczenie wczytawania z klawiatury
        return tablica;
    }

    public static int[][] wypisz_tablice(int tablica[][]) {
        for (int i = 0; i < tablica.length; i++) {
            System.out.println("Wierzcholek " + i + " x: " + tablica[i][0]);
            System.out.println("Wierzcholek " + i + " y: " + tablica[i][1]);
            System.out.println();
        }
        return tablica;
    }

    public void paintComponent(Graphics component){
        Graphics2D component2D = (Graphics2D) component; //rzutowanie z z klasy Graphics do klasy Graphics 2D
    }
    
    public static void main(String[] args) {
        setLookAndFeel();
        Zadanie2 frame = new Zadanie2(); //utworzenie obiektu frame

        int[][] wierzcholki = wczytaj_figure(); //tablica ze wspolrzednymi wierzcholkow
        wypisz_tablice(wierzcholki);
        // paintComponent(arg);

}
}
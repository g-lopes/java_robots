import java.util.Scanner;

public class Spielfeld {

    private static final int breite = 1000;
    private static final int laenge = 1000;

    public Spielfeld(){}

    public Punkt[] punkte_eingeben() {
        int size = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Wie viele POIs willst du eingeben?");
        size = sc.nextInt();
        Punkt[] array = new Punkt[size + 1];
        int x = -1;
        int y = -1;
        int index = -1;

        array[0] = new Punkt(0,0);

        for(int i = 0; i < 2*size; i++) {
            index = (int) Math.ceil(i/2) + 1;
            if(i % 2 == 0) {
                System.out.println("Geben sie die Koordinate X für p" + index + " ein.");
                x = sc.nextInt();

            } else {
                System.out.println("Geben sie die Koordinate Y für p" + index + " ein.");
                y = sc.nextInt();
                Punkt p = new Punkt(x,y);
                array[index] = p;
            }
        }

        POI_sortieren(array);

        // Wenn du willst, kannst du die folgenden Zeile loeschen.
        for(int i = 0; i < array.length; i++) {
            System.out.println("(" + array[i].x + "," + array[i].y + ")");
        }

        return array;
    }

    void POI_sortieren(Punkt[] punkte) {
        double minAbstand = 30000;
        double abstand = -1;
        Punkt naechsterPunkt = null;

        for(int i = 0; i < punkte.length - 1; i++) {
            abstand = punkte[i].gibAbstand(punkte[i+1]);
            for(int j = i+1; j < punkte.length; j++) {
                if(abstand > punkte[i].gibAbstand(punkte[j])) {
                    naechsterPunkt = punkte[j];
                    punkte[j] = punkte[i+1];
                    punkte[i+1] = naechsterPunkt;
                }
            }
        }
    }

}

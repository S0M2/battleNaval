package src.Principale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ChantDeBataille flotile1 = new ChantDeBataille(10,10);
        flotile1.afficherGrille();
        Bateau bateau = new Bateau(5, 0,0,'A');

        Bateau bateau1 = new Bateau(3, 2, 3, 'H');
        flotile1.placerBateau(bateau1);
        flotile1.afficherGrille();

    }
}
package src;

import src.ticTacToe.Joueur;
import src.ticTacToe.Plateau;

import javax.swing.*;

public class Morpion {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Joueur joueur1 = new Joueur("Joueur X");
            Joueur joueur2 = new Joueur("Joueur O");

            Plateau plateau = new Plateau(joueur1, joueur2);
        });
    }
}

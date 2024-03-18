// Plateau.java
package src.ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plateau extends JFrame {
    private JButton[][] cases;
    private Joueur joueur1;
    private Joueur joueur2;
    private boolean tourJoueur1;

    public Plateau(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.tourJoueur1 = true;

        setTitle("Morpion");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initialiserMenu();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        cases = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cases[i][j] = new JButton("");
                cases[i][j].setFont(new Font("Arial", Font.PLAIN, 48));
                panel.add(cases[i][j]);
                final int row = i;
                final int col = j;
                cases[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        caseCliquee(row, col);
                    }
                });
            }
        }

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void initialiserMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuOptions = new JMenu("Options");

        JMenuItem changerPseudos = new JMenuItem("Changer les pseudos");
        changerPseudos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changerPseudos();
            }
        });

        JMenuItem reinitialiserGrille = new JMenuItem("Réinitialiser la grille");
        reinitialiserGrille.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reinitialiserPartie();
            }
        });

        menuOptions.add(changerPseudos);
        menuOptions.add(reinitialiserGrille);

        menuBar.add(menuOptions);
        setJMenuBar(menuBar);
    }

    private void caseCliquee(int row, int col) {
        if (cases[row][col].getText().equals("")) {
            if (tourJoueur1) {
                cases[row][col].setText("X");
            } else {
                cases[row][col].setText("O");
            }

            if (aGagne()) {
                afficherMessage("Félicitations, " + (tourJoueur1 ? joueur1.getPseudo() : joueur2.getPseudo()) + " a gagné !");
                reinitialiserPartie();
            } else if (partieNulle()) {
                afficherMessage("Match nul ! Aucun joueur n'a gagné.");
                reinitialiserPartie();
            } else {
                tourJoueur1 = !tourJoueur1;
            }
        }
    }

    private boolean aGagne() {
        // Vérification des lignes
        for (int i = 0; i < 3; i++) {
            if (cases[i][0].getText().equals("X") && cases[i][1].getText().equals("X") && cases[i][2].getText().equals("X") ||
                    cases[i][0].getText().equals("O") && cases[i][1].getText().equals("O") && cases[i][2].getText().equals("O")) {
                return true;
            }
        }

        // Vérification des colonnes
        for (int j = 0; j < 3; j++) {
            if (cases[0][j].getText().equals("X") && cases[1][j].getText().equals("X") && cases[2][j].getText().equals("X") ||
                    cases[0][j].getText().equals("O") && cases[1][j].getText().equals("O") && cases[2][j].getText().equals("O")) {
                return true;
            }
        }

        // Vérification de la diagonale principale
        if (cases[0][0].getText().equals("X") && cases[1][1].getText().equals("X") && cases[2][2].getText().equals("X") ||
                cases[0][0].getText().equals("O") && cases[1][1].getText().equals("O") && cases[2][2].getText().equals("O")) {
            return true;
        }

        // Vérification de la diagonale opposée
        if (cases[0][2].getText().equals("X") && cases[1][1].getText().equals("X") && cases[2][0].getText().equals("X") ||
                cases[0][2].getText().equals("O") && cases[1][1].getText().equals("O") && cases[2][0].getText().equals("O")) {
            return true;
        }

        return false;
    }

    private boolean partieNulle() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cases[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void reinitialiserPartie() {
        // Réinitialiser toutes les cases de la grille
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cases[i][j].setText("");
            }
        }

        // Réinitialiser le tour du joueur
        tourJoueur1 = true;
    }

    private void changerPseudos() {
        String nouveauPseudoJoueur1 = JOptionPane.showInputDialog(this, "Nouveau pseudo pour " + joueur1.getPseudo() + ":");
        String nouveauPseudoJoueur2 = JOptionPane.showInputDialog(this, "Nouveau pseudo pour " + joueur2.getPseudo() + ":");

        if (nouveauPseudoJoueur1 != null && !nouveauPseudoJoueur1.isEmpty()) {
            joueur1 = new Joueur(nouveauPseudoJoueur1);
        }

        if (nouveauPseudoJoueur2 != null && !nouveauPseudoJoueur2.isEmpty()) {
            joueur2 = new Joueur(nouveauPseudoJoueur2);
        }

        afficherMessage("Les pseudos ont été changés !");
    }


    private void afficherMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

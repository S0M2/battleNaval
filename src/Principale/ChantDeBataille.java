package src.Principale;

public class ChantDeBataille {
    int axeX;
    int axeY;
    char[][] flotilde;
    ChantDeBataille(int iaxeX, int iaxeY){
        axeX = iaxeX;
        axeY= iaxeY;
        flotilde = new char[axeX][axeY];
    }
    void afficherGrille() {
        for (int i = 0; i < axeX; i++) {
            for (int j = 0; j < axeY; j++) {
                System.out.print(flotilde[i][j] + "   ");
            }
            System.out.println();
        }
    }
}

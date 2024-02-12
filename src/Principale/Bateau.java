package src.Principale;

public class Bateau {
    int taille;
    int coordonéeX;
    int coordonéeY;
    char direction;
    Bateau(int iTaile,int iCoordonéeX, int iCoordonéeY, char iDirection){
        taille = iTaile;
        coordonéeX = iCoordonéeX;
        coordonéeY = iCoordonéeY;
        direction = iDirection;
    }
    boolean estCorrectPlacee(){
        return true;
    }
    void créeBateaux(int coordonéeX, int coordonéeY, int taille, char direction){
        boolean estCorect = estCorrectPlacee();

    }

}
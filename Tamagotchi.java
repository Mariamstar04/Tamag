import java.util.Random;

public class Tamagotchi {

    // Attributs privés
    private int age;
    private int dureeDeVie;
    private int maxEnergie;
    private int energie;
    private String nom;

    // Générateur de nombres aléatoires
    private Random hasard = new Random();

    // Constructeur
    public Tamagotchi(String nom) {

        this.nom = nom;

        age = 0;

        dureeDeVie = 9 + hasard.nextInt(6);

        maxEnergie = 5 + hasard.nextInt(5);

        energie = 3 + hasard.nextInt(maxEnergie - 2);
    }

    // Méthode parler()
    public void parler() {

        if (energie > 5) {
            System.out.println(nom + " : tout va bien !");
        } else {
            System.out.println(nom + " : je suis affamé !");
        }
    }

    // Méthode manger()
    public void manger() {

        if (energie >= maxEnergie) {

            System.out.println(nom + " : je n'ai pas faim !!");

        } else {

            int nourriture = 1 + hasard.nextInt(3);

            energie += nourriture;

            if (energie > maxEnergie) {
                energie = maxEnergie;
            }

            System.out.println(nom + " : Merci !");
        }
    }

    // Méthode ageLimite()
    public boolean ageLimite() {

        return age >= dureeDeVie;
    }

    // Méthode vivre()
    public boolean vivre() {

        // Cas 1 : le Tamagotchi a atteint son âge limite
        if (ageLimite()) {
            return true;
        }

        // Cas 2 : le Tamagotchi n'a plus d'énergie
        if (energie <= 0) {

            System.out.println(nom + " : je meurs... Arrrggh !");

            return false;
        }

        // Cas 3 : le Tamagotchi continue à vivre
        age++;

        energie--;

        if (ageLimite()) {

            System.out.println(nom + " : c'est gagné pour moi !");

        } else {

            parler();
        }

        return true;
    }

    // Méthode pour récupérer le nom
    public String getNom() {
        return nom;
    }
}

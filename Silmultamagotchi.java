import java.util.Scanner;

public class SimulTamagotchi {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        // Demander le nombre de Tamagotchis
        System.out.print("Combien de Tamagotchis voulez-vous ? ");

        int n = clavier.nextInt();
        clavier.nextLine();

        // Création du tableau
        Tamagotchi[] animaux = new Tamagotchi[n];

        boolean[] vivant = new boolean[n];

        // Initialisation des Tamagotchis
        for (int i = 0; i < n; i++) {

            System.out.print("Quel nom pour le nouveau tamagotchi : ");

            String nom = clavier.nextLine();

            animaux[i] = new Tamagotchi(nom);

            vivant[i] = true;
        }

        int cycle = 1;

        boolean perdu = false;

        boolean gagne = false;

        // Boucle principale du jeu
        while (!perdu && !gagne) {

            System.out.println("\n-------Cycle no "
                    + cycle + " -------");

            // Faire vivre tous les Tamagotchis
            for (int i = 0; i < n; i++) {

                if (vivant[i]) {

                    boolean resultat = animaux[i].vivre();

                    if (!resultat) {

                        vivant[i] = false;

                        perdu = true;

                        break;
                    }

                    // Vérifier si le Tamagotchi a gagné
                    if (animaux[i].ageLimite()) {

                        vivant[i] = false;
                    }
                }
            }

            // Vérifier si tous les Tamagotchis ont gagné
            gagne = true;

            for (int i = 0; i < n; i++) {

                if (vivant[i]) {
                    gagne = false;
                    break;
                }
            }

            // Si un Tamagotchi est mort
            if (perdu) {

                System.out.println("\nPERDU !!");

                break;
            }

            // Si tous les Tamagotchis ont atteint leur âge limite
            if (gagne) {

                System.out.println("\nGAGNE !!");

                break;
            }

            // Afficher les Tamagotchis encore disponibles
            for (int i = 0; i < n; i++) {

                if (vivant[i]) {

                    System.out.print("(" + i + ") "
                            + animaux[i].getNom() + "   ");
                }
            }

            System.out.println();

            // Demander quel Tamagotchi nourrir
            int choix;

            do {

                System.out.print("Nourrir quel tamagotchi ? ");

                choix = clavier.nextInt();

                if (choix < 0 || choix >= n || !vivant[choix]) {

                    System.out.println("Choix invalide !");
                }

            } while (choix < 0 || choix >= n || !vivant[choix]);

            // Nourrir le Tamagotchi choisi
            animaux[choix].manger();

            cycle++;
        }

        clavier.close();
    }
}

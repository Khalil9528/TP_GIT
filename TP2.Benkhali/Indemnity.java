import java.util.Scanner;

class Person {
    private String name;
    private int id;
    private float distanceCovered;

    public Person(String name, int id, float distanceCovered) {
        this.name = name;
        this.id = id;
        this.distanceCovered = distanceCovered;
    }

    public int getId() {
        return id;
    }

    public float calculateIndemnity() {
        try {
            if (distanceCovered < 0) {
                throw new IllegalArgumentException("La distance parcourue ne peut pas être négative.");
            }

            float ind = 0; // Initialisation de l'indemnité
            if (distanceCovered < 1000) {
                if (distanceCovered < 10) {
                    ind = 1.50f * distanceCovered;
                } else if (distanceCovered >= 10 && distanceCovered <= 39) {
                    ind = 0.40f * distanceCovered;
                } else if (distanceCovered >= 40 && distanceCovered <= 59) {
                    ind = 0.55f * distanceCovered;
                } else {
                    ind = 6.81f * (distanceCovered / 20);
                }
            }
            return Math.round(ind * 100.0f) / 100.0f; // Arrondi à 2 décimales
        } catch (IllegalArgumentException argEx) {
            System.out.println("Erreur d'argument : " + argEx.getMessage());
            return 0; // Valeur par défaut en cas d'erreur
        } catch (Exception e) {
            System.out.println("Erreur lors du calcul de l'indemnité : " + e.getMessage());
            return 0; // Valeur par défaut en cas d'erreur
        }
    }
}

public class IndemnityCalculator {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Entrez la distance parcourue :");
            String input = scanner.nextLine();
            float distance;

            // Vérification si la conversion a échoué
            try {
                distance = Float.parseFloat(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("La distance est invalide.");
            }

            // Création de l'objet Person avec la distance saisie
            Person employer = new Person("saad", 123456789, distance);
            float indemnity = employer.calculateIndemnity(); // Calcul de l'indemnité
            System.out.printf("L'indemnité calculée est : %.2f%n", indemnity);
        } catch (IllegalArgumentException formatEx) {
            System.out.println("Erreur de format : " + formatEx.getMessage());
        } catch (Exception e) {
            System.out.println("Une exception a été levée : " + e.getMessage());
        }
    }
}

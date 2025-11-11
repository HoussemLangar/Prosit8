import entities.Employe;
import services.SocieteArrayList;

public class Main {
    public static void main(String[] args) {

        SocieteArrayList societe = new SocieteArrayList();

        Employe e1 = new Employe(1, "Langar", "Houssem", "Informatique", 3);
        Employe e2 = new Employe(2, "Hajjouni", "Mehdi", "RH", 2);
        Employe e3 = new Employe(3, "Khemiri", "Lina", "Informatique", 1);
        Employe e4 = new Employe(4, "Nasfi", "Motaz", "Finance", 2);

        societe.ajouterEmploye(e1);
        societe.ajouterEmploye(e2);
        societe.ajouterEmploye(e3);
        societe.ajouterEmploye(e4);

        System.out.println("Liste initiale :");
        societe.displayEmploye();

        System.out.println("\nTri par ID :");
        societe.trierEmployeParId();
        societe.displayEmploye();

        System.out.println("\nTri par Département, Grade et Nom :");
        societe.trierEmployeParNomDépartementEtGrade();
        societe.displayEmploye();

        System.out.println("\nRecherche par département 'Informatique' :");
        for (Employe e : societe.rechercherParDepartement("Informatique")) {
            System.out.println(e);
        }

        System.out.println("\n🗑Suppression de Lina Khemiri...");
        societe.supprimerEmploye(e3);
        societe.displayEmploye();
    }
}

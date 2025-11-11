package services;

import entities.Employe;
import interfaces.IGestion;
import interfaces.IRechercheAvancee;
import java.util.*;

public class SocieteArrayList implements IGestion<Employe>, IRechercheAvancee<Employe> {

    private List<Employe> listeEmployes = new ArrayList<>();

    @Override
    public void ajouterEmploye(Employe e) {
        listeEmployes.add(e);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe e : listeEmployes) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe e) {
        return listeEmployes.contains(e);
    }

    @Override
    public void supprimerEmploye(Employe e) {
        listeEmployes.remove(e);
    }

    @Override
    public void displayEmploye() {
        for (Employe e : listeEmployes) {
            System.out.println(e);
        }
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(listeEmployes);
    }

    @Override
    public void trierEmployeParNomDépartementEtGrade() {
        listeEmployes.sort((e1, e2) -> {
            int depCompare = e1.getNomDepartement().compareToIgnoreCase(e2.getNomDepartement());
            if (depCompare != 0) return depCompare;
            int gradeCompare = Integer.compare(e1.getGrade(), e2.getGrade());
            if (gradeCompare != 0) return gradeCompare;
            return e1.getNom().compareToIgnoreCase(e2.getNom());
        });
    }

    @Override
    public List<Employe> rechercherParDepartement(String nomDepartement) {
        List<Employe> resultat = new ArrayList<>();
        for (Employe e : listeEmployes) {
            if (e.getNomDepartement().equalsIgnoreCase(nomDepartement)) {
                resultat.add(e);
            }
        }
        return resultat;
    }
}

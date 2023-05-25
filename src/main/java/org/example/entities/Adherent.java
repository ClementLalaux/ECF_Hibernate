package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Adherent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;
    private String prenom;
    private int grade;

    @ManyToMany(mappedBy = "adherents",fetch = FetchType.EAGER)
    private List<Activite> activites = new ArrayList<>();

    public Adherent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Activite> getActivites() {
        return activites;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public void addActivite(Activite activite){
        getActivites().add(activite);
    }

    @Override
    public String toString() {
        return "Adherent{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", grade=" + grade +
                ", activites=" + activites +
                '}';
    }
}

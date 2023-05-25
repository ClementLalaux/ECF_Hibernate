package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Centre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;

    @OneToMany(mappedBy = "centre",fetch = FetchType.EAGER)
    private List<Activite> activites = new ArrayList<>();

    public Centre() {
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

    public List<Activite> getActivites() {
        return activites;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public void addActivites(Activite activite){
        getActivites().add(activite);
    }


    @Override
    public String toString() {
        return "Centre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", activites=" + activites +
                '}';
    }
}

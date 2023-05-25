package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Activite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;

    private int places;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "centre_id")
    private Centre centre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "adherent_activite",
            joinColumns = @JoinColumn(name = "id_activite"),
            inverseJoinColumns = @JoinColumn(name = "id_adherent"))
    private List<Adherent> adherents;

    public Activite() {
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

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }

    public List<Adherent> getAdherents() {
        return adherents;
    }

    public void setAdherents(List<Adherent> adherents) {
        this.adherents = adherents;
    }

    public void addAdherent(Adherent adherent){
        getAdherents().add(adherent);
    }

    @Override
    public String toString() {
        return "Activite{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", places=" + places +
                ", date=" + date +
                ", centre=" + centre +
                ", adherents=" + adherents +
                '}';
    }
}

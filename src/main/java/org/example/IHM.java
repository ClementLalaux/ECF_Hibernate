package org.example;

import org.example.entities.Activite;
import org.example.entities.Adherent;
import org.example.entities.Centre;
import org.example.services.ActiviteService;
import org.example.services.AdherentService;
import org.example.services.CentreService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class IHM {

    Scanner scanner;
    CentreService centreService = new CentreService();
    AdherentService adherentService = new AdherentService();
    ActiviteService activiteService = new ActiviteService();
    String choix;

    public IHM(){
        scanner = new Scanner(System.in);
    }

    public void start(){
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1" :
                    createCentreFunction();
                    break;
                case "2" :
                    findCentreFunction();
                    break;
                case "3" :
                    findCentreByIdFunction();
                    break;
                case "4" :
                    deleteCentreFunction();
                    break;
                case "5":
                    updateCentreFunction();
                    break;
                case "6":
                    createAdherentFunction();
                    break;
                case "7" :
                    findAdherentFunction();
                    break;
                case "8" :
                    findAdherentByIdFunction();
                    break;
                case "9":
                    deleteAdherentFunction();
                    break;
                case "10":
                    updateAdherentFunction();
                    break;
                case "11":
                    createActiviteFunction();
                    break;
                case "12":
                    findActiviteFunction();
                    break;
                case "13":
                    findActiviteByIdFunction();
                    break;
                case "14":
                    deleteActiviteFunction();
                    break;
                case "15":
                    updateActiviteFunction();
                    break;
                case "16":
                    associerActiviteCentre();
                    break;
                case "17":
                    associerActiviteAdherent();
                    break;
            }
        } while (!choix.equals("0"));
    }

    private void menu(){
        System.out.println("1 - Créer un centre");
        System.out.println("2 - Afficher les centres");
        System.out.println("3 - Rechercher un centre par son id");
        System.out.println("4 - Supprimer un centre");
        System.out.println("5 - Modifier un centre");
        System.out.println("6 - Créer un adherent");
        System.out.println("7 - Afficher les adherents");
        System.out.println("8 - Rechercher un adherent par son id");
        System.out.println("9 - Supprimer un adherent");
        System.out.println("10 - Modifier un adherent");
        System.out.println("11 - Créer une activité");
        System.out.println("12 - Afficher les activités");
        System.out.println("13 - Rechercher une activité par son id");
        System.out.println("14 - Supprimer une activité");
        System.out.println("15 - Modifier une activité");
        System.out.println("16 - Associer une activité à un centre");
        System.out.println("17 - Associer un adherent à une activité");
        System.out.println("0 - EXIT");
    }

    public void createCentreFunction(){
        System.out.println("Entrez le nom du centre : ");
        String nom = scanner.nextLine();

        Centre centre = new Centre();
        centre.setNom(nom);
        try {
            centreService.create(centre);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void findCentreFunction(){
        List<Centre> centres = centreService.find();
        for(Centre centre : centres){
            System.out.println("Id : " + centre.getId() + " , nom : " + centre.getNom());
        }
    }

    public void findCentreByIdFunction(){
        System.out.println("Entrez l'id a du centre : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Centre centre = centreService.findById(id);
        if(centre != null){
            System.out.println(centre.getNom());
        }
    }

    public void deleteCentreFunction(){
        System.out.println("Entrez l'id a supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Centre centre = centreService.findById(id);
        if(centre != null){
            try {
                centreService.delete(centre);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateCentreFunction(){
        System.out.println("Entrez l'id a modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Centre centre = centreService.findById(id);
        if(centre != null){
            System.out.println("Entrez un nouveau nom");
            String nouveauNom = scanner.nextLine();
            centre.setNom(nouveauNom);
            try {
                centreService.update(centre);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createAdherentFunction(){
        System.out.println("Entrez le nom de l'adherent : ");
        String nom = scanner.nextLine();
        System.out.println("Entrez le prenom de l'adherent : ");
        String prenom = scanner.nextLine();
        System.out.println("Entrez le grade (1-2-3) : ");
        int grade = scanner.nextInt();
        scanner.nextLine();

        Adherent adherent = new Adherent();
        adherent.setNom(nom);
        adherent.setPrenom(prenom);
        adherent.setGrade(grade);
        try{
            adherentService.create(adherent);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void findAdherentFunction(){
        List<Adherent> adherents = adherentService.find();
        for(Adherent adherent : adherents){
            System.out.println("Id : " + adherent.getId() + " , nom : " + adherent.getNom() + " , prenom : " + adherent.getPrenom());
        }
    }

    public void findAdherentByIdFunction(){
        System.out.println("Entrez l'id a de l'adherent : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Adherent adherent = adherentService.findById(id);
        if(adherent != null){
            System.out.println("Nom : " + adherent.getNom() + " , prénom : " + adherent.getPrenom());
        }
    }

    public void deleteAdherentFunction(){
        System.out.println("Entrez l'id a supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Adherent adherent = adherentService.findById(id);
        if(adherent != null){
            try {
                adherentService.delete(adherent);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateAdherentFunction(){
        System.out.println("Entrez l'id a modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Adherent adherent = adherentService.findById(id);
        if(adherent != null){
            System.out.println("Entrez un nouveau nom");
            String nouveauNom = scanner.nextLine();
            System.out.println("Entrez un nouveau prenom");
            String nouveauPrenom = scanner.nextLine();
            System.out.println("Entrez un nouveau grade (1-2-3)");
            int nouveauGrade = scanner.nextInt();
            scanner.nextLine();
            adherent.setNom(nouveauNom);
            adherent.setPrenom(nouveauPrenom);
            adherent.setGrade(nouveauGrade);
            try {
                adherentService.update(adherent);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void createActiviteFunction(){
        System.out.println("Entrez le nom de l'activite : ");
        String nom = scanner.nextLine();
        System.out.println("Entrez la date (dd.MM.yyyy) : ");
        String date = scanner.nextLine();
        LocalDate dueDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("Entrez le nombre de places : ");
        int places = scanner.nextInt();
        scanner.nextLine();

        Activite activite = new Activite();
        activite.setNom(nom);
        activite.setDate(dueDate);
        activite.setPlaces(places);
        try{
            activiteService.create(activite);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void findActiviteFunction(){
        List<Activite> activites = activiteService.find();
        for(Activite activite : activites){
            System.out.println("Id : " + activite.getId() + " , nom : " + activite.getNom());
        }
    }

    public void findActiviteByIdFunction(){
        System.out.println("Entrez l'id a de l'activite : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Activite activite = activiteService.findById(id);
        if(activite != null){
            System.out.println("Nom : " + activite.getNom() + " , places : " + activite.getPlaces());
        }
    }

    public void deleteActiviteFunction(){
        System.out.println("Entrez l'id a supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Activite activite = activiteService.findById(id);
        if(activite != null){
            try {
                activiteService.delete(activite);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void updateActiviteFunction(){
        System.out.println("Entrez l'id a modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Activite activite = activiteService.findById(id);
        if(activite != null){
            System.out.println("Entrez le nom de l'activite : ");
            String nouveauNom = scanner.nextLine();
            System.out.println("Entrez la date (dd.MM.yyyy) : ");
            String nouvelleDate = scanner.nextLine();
            LocalDate nouvelleDueDate = LocalDate.parse(nouvelleDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            System.out.println("Entrez le nombre de places : ");
            int nouvellesPlaces = scanner.nextInt();
            scanner.nextLine();
            activite.setNom(nouveauNom);
            activite.setDate(nouvelleDueDate);
            activite.setPlaces(nouvellesPlaces);
            try {
                activiteService.update(activite);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void associerActiviteCentre(){
        System.out.println("Entrez l'id de l'activite : ");
        int idActivite = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Entrez l'id du centre : ");
        int idCentre = scanner.nextInt();
        scanner.nextLine();

        if(activiteService.findById(idActivite) != null && centreService.findById(idCentre) != null){
            Activite activite = activiteService.findById(idActivite);
            activite.setCentre(centreService.findById(idCentre));
            activiteService.update(activite);
        }
    }

    public void associerActiviteAdherent(){
        System.out.println("Entrez l'id de l'activite : ");
        int idActivite = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Entrez l'id de l'adherent : ");
        int idAdherent = scanner.nextInt();
        scanner.nextLine();

        if(activiteService.findById(idActivite) != null && adherentService.findById(idAdherent) != null){
           try{
               Activite activite = activiteService.findById(idActivite);
               activite.addAdherent(adherentService.findById(idAdherent));
               activiteService.update(activite);
           }catch (Exception e) {
               System.out.println(e.getMessage());
           }

            try {
                Adherent adherent = adherentService.findById(idAdherent);
                adherent.addActivite(activiteService.findById(idActivite));
                adherentService.update(adherent);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

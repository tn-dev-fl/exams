package bank;

import java.util.ArrayList;

public class Client {
    private int cin;
    private String nom, prenom, adresse, email;
    private int numTel;
    private int role;
    private int userID;
    private String password;
    private ArrayList<Compte> comptes;

    public Client(int cin, String nom, String prenom, String adresse, String email, int numTel, int role, int userID, String password) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.numTel = numTel;
        this.role = role;
        this.userID = userID;
        this.password = password;
        this.comptes = new ArrayList<Compte>();
    }

    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public int getNumTel() {
        return numTel;
    }

    public int getRole() {
        return role;
    }

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Compte> getComptes() {
        return comptes;
    }

    public void ajouterCompte(Compte compte) {
        comptes.add(compte);
    }

    public void retirerCompte(Compte compte) {
        comptes.remove(compte);
    }
}

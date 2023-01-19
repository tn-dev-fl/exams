package bank;

import jdk.dynalink.Operation;

import java.util.ArrayList;
import java.util.Date;
import bank.Operation.*;

public class Compte {
    private int numero;
    private String nomProprietaire;
    private Date dateOuverture;
    private ArrayList<Operation> operations;

    public Compte(int numero, String nomProprietaire, Date dateOuverture) {
        this.numero = numero;
        this.nomProprietaire = nomProprietaire;
        this.dateOuverture = dateOuverture;
        this.operations = new ArrayList<Operation>();
    }

    public int getNumero() {
        return numero;
    }

    public String getNomProprietaire() {
        return nomProprietaire;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public void deposer(float montant, Date date) {
        Operation operation = new Operation(date, montant, Operation.VERSEMENT);
        operations.add(operation);
    }

    public void retirer(float montant, Date date) {
        Operation operation = new Operation(date, montant, Operation.RETRAIT);
        operations.add(operation);
    }


    public float getSolde(Date date) {
        float solde = 0;
        for (Operation operation : operations) {
            if (operation.getType() == Operation.VERSEMENT) {
                solde += operation.getMontant();
            } else {
                solde -= operation.getMontant();
            }
        }
        return solde;
    }
}

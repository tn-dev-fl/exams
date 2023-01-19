package bank;
import java.util.ArrayList;
import java.util.Date;

public class CompteEpargne extends Compte {
    private float tauxInteret;
    private ArrayList<Operation> operations;

    public CompteEpargne(int numCompte, String nomProprietaire, String dateOuverture, float tauxInteret) {
        super(numCompte, nomProprietaire, dateOuverture);
        this.tauxInteret = tauxInteret;
        this.operations = new ArrayList<>();
    }

    @Override
    public void retirer(float montant, Date date) {
        throw new UnsupportedOperationException("Retrait non autorisé pour les comptes épargne");
    }

    public float calculerInteret(Date date) {
        float interet = 0;
        for (Operation operation : operations) {
            int nbJours = (int) ((date.getTime() - operation.getDate().getTime()) / (1000 * 60 * 60 * 24));
            interet += operation.getMontant() * nbJours * tauxInteret / 100 / 365;
        }
        return interet;
    }
}

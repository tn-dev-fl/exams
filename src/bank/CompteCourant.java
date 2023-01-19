import java.util.Date;

public class CompteCourant extends Compte {
    private float decouvert;

    public CompteCourant(int numCompte, String nomProprietaire, String dateOuverture, float decouvert) {
        super(numCompte, nomProprietaire, dateOuverture);
        this.decouvert = decouvert;
    }

    @Override
    public void retirer(float montant, Date date) {
        float solde = getSolde();
        if (solde - montant < -decouvert) {
            throw new IllegalArgumentException("Retrait non autorisé : découvert dépassé");
        } else {
            setSolde(solde - montant);
            // save the operation in the database
        }
    }
}

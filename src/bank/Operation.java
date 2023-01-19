package bank;

import java.util.Date;

public class Operation {
    private Date date;
    private float montant;
    private int type;

    public static final int VERSEMENT = 0;
    public static final int RETRAIT = 1;

    public Operation(Date date, float montant, int type) {
        this.date = date;
        this.montant = montant;
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public float getMontant() {
        return montant;
    }

    public int getType() {
        return type;
    }
}

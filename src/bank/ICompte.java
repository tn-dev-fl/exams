package bank;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface ICompte extends Remote {
    public float getSolde(Date date) throws RemoteException;
    public void deposer(float montant, Date date) throws RemoteException;
    public void retirer(float montant, Date date) throws RemoteException;
}

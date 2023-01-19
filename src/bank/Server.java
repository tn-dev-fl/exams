package bank;

import bank.Compte;
import bank.ICompte;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class Server extends UnicastRemoteObject implements ICompte {
    private Compte compte;

    public Server(Compte compte) throws RemoteException {
        this.compte = compte;
    }

    public float getSolde(Date date) throws RemoteException {
        return compte.getSolde(date);
    }

    public void deposer(float montant, Date date) throws RemoteException {
        compte.deposer(montant, date);
    }

    public void retirer(float montant, Date date) throws RemoteException {
        compte.retirer(montant, date);
    }

    public static void main(String[] args) {
        try {
            Compte compte = new Compte(123, "John Doe", new Date());
            Server server = new Server(compte);

            LocateRegistry.createRegistry(1099);
            Naming.bind("rmi://localhost/compte", server);
            System.out.println("Server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

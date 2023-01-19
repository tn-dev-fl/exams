import bank.Compte;
import bank.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class Agent {
    private DatabaseHelper dbHelper;
    private int agentId;
    private String name;
    private String email;
    private String password;

    public Agent(int agentId, String name, String email, String password) {
        this.agentId = agentId;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public Agent() {
        dbHelper = new DatabaseHelper();
    }
    public int getAgentId() {
        return agentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void openAccount(Compte compte) {
        dbHelper.insertAccount(compte);
    }

    public Compte getAccount(int accountNumber) {
        // Retrieve the account from the database
        return new Compte();
    }
    public Compte viewAccount(int accountNumber) {
        return dbHelper.selectAccount(accountNumber);
    }
    public List<Compte> getAllAccounts() {
        // Retrieve all the accounts from the database
        return dbHelper.selectAllAccounts();
    }

    public void updateAccount(Compte compte) {
        dbHelper.updateAccount(compte);
    }

    public void deleteAccount(int accountNumber) {
        dbHelper.deleteAccount(accountNumber);
    }
}

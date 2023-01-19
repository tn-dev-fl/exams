package bank;

import java.sql.*;

public class DatabaseHelper {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/Banque";

    private static final String USER = "username";
    private static final String PASS = "password";

    private Connection conn = null;
    private Statement stmt = null;

    public DatabaseHelper() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAccount(Compte compte) {
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO compte (num_cpt, date, type, solde, cin) " +
                    "VALUES (" + compte.getNumCompte() + ", '" + compte.getDateOuverture() + "', " + compte.getType() + ", " + compte.getSolde() + ", " + compte.getCin() + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Compte selectAccount(int accountNumber) {
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM compte WHERE num_cpt = " + accountNumber;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int numCompte = rs.getInt("num_cpt");
                String dateOuverture = rs.getString("date");
                int type = rs.getInt("type");
                float solde = rs.getFloat("solde");
                int cin = rs.getInt("cin");

                return new Compte(numCompte, dateOuverture, type, solde, cin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Compte> selectAllAccounts() {
        List<Compte> accounts = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM compte";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int numCompte = rs.getInt("num_cpt");
                String dateOuverture = rs.getString("date");
                int type = rs.getInt("type");
                float solde = rs.getFloat("solde");
                int cin = rs.getInt("cin");

                accounts.add(new Compte(numCompte, dateOuverture, type, solde, cin));
            }
            return accounts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateAccount(Compte compte) {
        try {
            stmt = conn.createStatement();
            String sql = "UPDATE compte SET date = '" + compte.getDateOuverture() + "', type = " + compte.getType() + ", solde = " + compte.getSolde() + ", cin = " + compte.getCin() + " WHERE num_cpt = " + compte.getNumCompte();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int accountNumber) {
        try {
            stmt = conn.createStatement();
            String sql = "DELETE FROM compte WHERE num_cpt = " + accountNumber;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User user) {
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO user (cin, nom, prenom, adresse, numTel, role, userID, password) " +
                    "VALUES (" + user.getCin() + ", '" + user.getNom() + "', '" + user.getPrenom() + "', '" + user.getAdresse() + "', " + user.getNumTel() + ", " + user.getRole() + ", '" + user.getUserID() + "', '" + user.getPassword() + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User selectUser(int cin) {
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM user WHERE cin = " + cin;
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int cin = rs.getInt("cin");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                int numTel = rs.getInt("numTel");
                int role = rs.getInt("role");
                String userID = rs.getString("userID");
                String password = rs.getString("password");

                return new User(cin, nom, prenom, adresse, numTel, role, userID, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int cin = rs.getInt("cin");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                int numTel = rs.getInt("numTel");
                int role = rs.getInt("role");
                String userID = rs.getString("userID");
                String password = rs.getString("password");

                users.add(new User(cin, nom, prenom, adresse, numTel, role, userID, password));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(User user) {
        try {
            stmt = conn.createStatement();
            String sql = "UPDATE user SET nom = '" + user.getNom() + "', prenom = '" + user.getPrenom() + "', adresse = '" + user.getAdresse() + "', numTel = " + user.getNumTel() + ", role = " + user.getRole() + ", userID = '" + user.getUserID() + "', password = '" + user.getPassword() + "' WHERE cin = " + user.getCin();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int cin) {
        try {
            stmt = conn.createStatement();
            String sql = "DELETE FROM user WHERE cin = " + cin;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
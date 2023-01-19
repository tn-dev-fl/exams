package bank;

public class Admin {
    private DatabaseHelper dbHelper;

    public Admin() {
        dbHelper = new DatabaseHelper();
    }

    public void addUser(User user) {
        dbHelper.insertUser(user);
    }

    public User viewUser(int cin) {
        return dbHelper.selectUser(cin);
    }

    public List<User> viewAllUsers() {
        return dbHelper.selectAllUsers();
    }

    public void updateUser(User user) {
        dbHelper.updateUser(user);
    }

    public void deleteUser(int cin) {
        dbHelper.deleteUser(cin);
    }
}

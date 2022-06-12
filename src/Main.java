public class Main {
    static Server server;
    static DataBase dataBase;

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Server.runServer();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

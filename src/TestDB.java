public class TestDB {
    public static void main(String[] args) {
        try {
            DBConnection.getConnection();
        } catch (Exception e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }
}

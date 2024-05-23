package core1;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class bai4 {
    private static final String URL = "jdbc:mysql://localhost:3306/dbdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    public static void main(String[] args) {
        Connection connection = null;
        try {
             connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Scanner sc = new Scanner(System.in);



            while (true) {
                try {
                System.out.println("Nhập thông tin sinh viên: ");
                System.out.println("Tên: ");
                String name = sc.nextLine();
                System.out.println("Giới tính: ");
                String gender = sc.nextLine();
                System.out.println("Quê quán: ");
                String hometown = sc.nextLine();
                System.out.println("Tuổi: ");
                int age = sc.nextInt();
                sc.nextLine();
                String insertQuery = "INSERT INTO students (name, gender, hometown, age) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, gender);
                preparedStatement.setString(3, hometown);
                preparedStatement.setInt(4, age);
                preparedStatement.executeUpdate();

                System.out.println("Thêm sinh viên thành công! ");
                System.out.println("Bạn có muốn thêm nữa không! YES OR NO");
                if ((sc.nextLine()).equals("NO") ){
                    preparedStatement.close();
                    connection.close();
                    break;
                }
            }catch (SQLException e) {
                    System.out.println("error");
                }
            // Đóng kết nối
        }
    }
}

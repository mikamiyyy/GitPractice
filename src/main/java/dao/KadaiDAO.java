package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Kadai;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class KadaiDAO {

	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public static int registerKadai(Kadai kd) {
		String sql = "INSERT INTO kadai16 VALUES(?,?,?,?,?,?,?)";
		int result=0;
		
		String salt = GenerateSalt.getSalt(16);
		String hashedPw = GenerateHashedPw.getSafetyPassword(kd.getPw(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, kd.getName());
			pstmt.setInt(2, kd.getAge());
			pstmt.setString(3, kd.getGender());
			pstmt.setString(4, kd.getTel());
			pstmt.setString(5, kd.getMail());
			pstmt.setString(6, salt);
			pstmt.setString(7, hashedPw);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	
	public static List<Kadai> selectAllKadai(){
		String sql = "SELECT * FROM kadai16";
		List<Kadai> result = new ArrayList<>();
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String gender = rs.getString("gender");
					String tel = rs.getString("tel");
					String mail = rs.getString("mail");
					String salt = rs.getString("salt");
					String hashedPw = rs.getString("pw");
					
					Kadai books = new Kadai(name, age, gender, tel, mail, salt, null, hashedPw);
					
					result.add(books);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static int deleteKadai(String mail) {
		String sql = "DELETE FROM kadai16 WHERE mail = ?";
		int result = 0;
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return result;
	}
	
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM kadai16 WHERE mail = ?";
		
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			
			try(ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Kadai login(String mail, String hashedPw) {
		String sql = "SELECT * FROM kadai16 WHERE mail = ? AND pw = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String name = rs.getString("name");
					String salt = rs.getString("salt");
					
					return new Kadai(name, -1, null, null, mail, salt, null, hashedPw);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}

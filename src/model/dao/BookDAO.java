package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.DatabaseManager;
import model.bean.Book;

public class BookDAO {

	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
 
	public int countTotal(String key){
		if(key == null)
			key = "";
		int result = 0;
		conn = DatabaseManager.getConnection();
		String sql = "SELECT count(*) FROM BOOK WHERE name like ?";			
		try {
			pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, "%" + key + "%");
			rs = pst.executeQuery();
		
			while (rs.next()) {
				result = rs.getInt(1);
			}
			rs.close();
			pst.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<Book> getList() {						
		ArrayList<Book> result = new ArrayList<>();				
		conn = DatabaseManager.getConnection();
		String sql = "SELECT * FROM Book";					
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Book book = new Book(					
						rs.getInt("idBook"), 				
						rs.getString("name"),			
						rs.getDate("dateAdded"));
				result.add(book);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<Book> getList(String key, int start, int end) {			
		ArrayList<Book> result = new ArrayList<>();
		conn = DatabaseManager.getConnection();
		String sql = "SELECT * FROM Book WHERE name like ? LIMIT ?,?";	
		try {
			pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, "%" + key + "%");
			pst.setInt(2, start);
			pst.setInt(3, end);
			rs = pst.executeQuery();
			while (rs.next()) {
				Book book = new Book(					
						rs.getInt("idBook"), 				
						rs.getString("name"),			
						rs.getDate("dateAdded"));				
				result.add(book);
			}
			rs.close();
			pst.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<Book> getList(String key) {
		ArrayList<Book> result = new ArrayList<>();				
		conn = DatabaseManager.getConnection();
		String sql = "SELECT * FROM Book WHERE name like ?";			
		try {
			pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, "%" + key + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				Book book = new Book(
						rs.getInt("idBook"), 				
						rs.getString("name"),			
						rs.getDate("dateAdded"));				
				result.add(book);
			}
			rs.close();
			pst.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}


	public Book getItem(int id){
		Book book =new Book();
		conn = DatabaseManager.getConnection();
		String sql = "SELECT * FROM Book WHERE idBook = ?";			
		try {
			pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				book = new Book(
						rs.getInt("idBook"), 				
						rs.getString("name"),			
						rs.getDate("dateAdded"));
			}
			rs.close();
			pst.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return book;
	}
public int addItem(Book book) {										
	conn = DatabaseManager.getConnection();
	String sql="INSERT INTO Book(name, dateAdded) VALUE(?,?)";			
	int kq=0;
	try {
		pst = conn.prepareStatement(sql);
		pst.setString(1, book.getName());
		pst.setDate(2, (Date) book.getDateAdded());
		kq = pst.executeUpdate();
		
		pst.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return kq;
	}

	public int editItem(Book book) {
		conn = DatabaseManager.getConnection();
		String sql ="UPDATE Book SET name=? WHERE idBook =?";			
		int kq = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getName());
			pst.setInt(2, book.getIdBook());
			kq = pst.executeUpdate();
			
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return kq;
	}

	public int deleteItem(int idBook) {								
		conn = DatabaseManager.getConnection();
		String sql = "DELETE FROM Book WHERE idBook=?";		
		int kq =0;
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, idBook);									
			kq = pst.executeUpdate();
			
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return kq;
	}

	public static void main(String[] args) {
		
		BookDAO tmp = new BookDAO();
		System.out.println(tmp.countTotal(""));
		for (Book item : tmp.getList("", 0, 5)) {
			System.out.println(item.getName());
		}
	}
}

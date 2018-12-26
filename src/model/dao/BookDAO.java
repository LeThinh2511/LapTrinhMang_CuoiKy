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

	public int countTotal(String key) {
		if (key == null)
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

	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> books = new ArrayList<>();
		conn = DatabaseManager.getConnection();
		String sql = "SELECT * FROM Book";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Book book = new Book(rs.getInt("idBook"), rs.getString("name"), rs.getDate("dateAdded"), rs.getString("author"));
				books.add(book);
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
		return books;
	}

	public ArrayList<Book> getBooks(String key) {
		ArrayList<Book> books = new ArrayList<>();
		conn = DatabaseManager.getConnection();
		String sql = "SELECT * FROM Book WHERE name like ?";
		try {
			pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, "%" + key + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				Book book = new Book(rs.getInt("idBook"), rs.getString("name"), rs.getDate("dateAdded"), rs.getString("author"));
				books.add(book);
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
		return books;
	}

	public Book getBook(int idBook) {
		Book book = new Book();
		conn = DatabaseManager.getConnection();
		String sql = "SELECT * FROM Book WHERE idBook = ?";
		try {
			pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, idBook);
			rs = pst.executeQuery();
			while (rs.next()) {
				book = new Book(rs.getInt("idBook"), rs.getString("name"), rs.getDate("dateAdded"), rs.getString("author"));
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

	public int editBook(Book book) {
		conn = DatabaseManager.getConnection();
		String sql = "UPDATE Book SET name=?, author=? WHERE idBook =?";
		int count = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getName());
			pst.setString(2, book.getAuthor());
			pst.setInt(3, book.getIdBook());
			count = pst.executeUpdate();

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
		return count;
	}

	public int addBook(Book book) {
		conn = DatabaseManager.getConnection();
		String sql = "INSERT INTO Book(name, dateAdded, author) VALUE(?,?,?)";
		int count = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getName());
			pst.setDate(2, (Date) book.getDateAdded());
			pst.setString(3, book.getAuthor());
			count = pst.executeUpdate();

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
		return count;
	}

	public int deleteItem(int idBook) {
		conn = DatabaseManager.getConnection();
		String sql = "DELETE FROM Book WHERE idBook=?";
		int count = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idBook);
			count = pst.executeUpdate();

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

		return count;
	}
}

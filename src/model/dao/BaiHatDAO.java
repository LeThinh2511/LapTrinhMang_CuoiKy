package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.DBConnect;
import model.bean.BaiHat;

public class BaiHatDAO {

	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
 
	public int countTotal(String key){
		if(key == null)
			key = "";
		int result = 0;
		conn = DBConnect.getConnection();
		String sql = "SELECT count(*) FROM SONG WHERE ten_bai_hat like ?";			
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
	
	public ArrayList<BaiHat> getList() {						
		ArrayList<BaiHat> result = new ArrayList<>();				
		conn = DBConnect.getConnection();
		String sql = "SELECT * FROM SONG";					
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				BaiHat temp = new BaiHat(					
						rs.getInt("ma_bai_hat"), 				
						rs.getString("ten_bai_hat"),			
						rs.getDate("ngay_tao"));
				result.add(temp);
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

	public ArrayList<BaiHat> getList(String key, int start, int end) {			
		ArrayList<BaiHat> result = new ArrayList<>();
		conn = DBConnect.getConnection();
		String sql = "SELECT * FROM  SONG WHERE ten_bai_hat like ? LIMIT ?,?";	
		try {
			pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, "%" + key + "%");
			pst.setInt(2, start);
			pst.setInt(3, end);
			rs = pst.executeQuery();
			while (rs.next()) {
				BaiHat temp = new BaiHat(					
						rs.getInt("ma_bai_hat"), 				
						rs.getString("ten_bai_hat"),			
						rs.getDate("ngay_tao"));				
				result.add(temp);
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

	public ArrayList<BaiHat> getList(String key) {
		ArrayList<BaiHat> result = new ArrayList<>();				
		conn = DBConnect.getConnection();
		String sql = "SELECT * FROM SONG WHERE ten_bai_hat like ?";			
		try {
			pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, "%" + key + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				BaiHat temp = new BaiHat(
						rs.getInt("ma_bai_hat"), 				
						rs.getString("ten_bai_hat"),			
						rs.getDate("ngay_tao"));				
				result.add(temp);
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


	public BaiHat getItem(int id){
		BaiHat result =new BaiHat();
		conn = DBConnect.getConnection();
		String sql = "SELECT * FROM SONG WHERE ma_bai_hat = ?";			
		try {
			pst = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				result = new BaiHat(
						rs.getInt("ma_bai_hat"), 				
						rs.getString("ten_bai_hat"),			
						rs.getDate("ngay_tao"));
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
public int addItem(BaiHat item) {										
	conn = DBConnect.getConnection();
	String sql="INSERT INTO SONG(ten_bai_hat, ngay_tao) VALUE(?,?)";			
	int kq=0;
	try {
		pst = conn.prepareStatement(sql);
		pst.setString(1, item.getTen());
		pst.setDate(2, item.getNgaytao());
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

	public int editItem(BaiHat item) {
		conn = DBConnect.getConnection();
		String sql ="UPDATE SONG SET ten_bai_hat=? WHERE ma_bai_hat =?";			
		int kq = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, item.getTen());
			pst.setInt(2, item.getMa());
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

	public int deleteItem(int maBaiHat) {								
		conn = DBConnect.getConnection();
		String sql = "DELETE FROM SONG WHERE ma_bai_hat=?";		
		int kq =0;
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, maBaiHat);									
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
		
		BaiHatDAO tmp = new BaiHatDAO();
		System.out.println(tmp.countTotal(""));
		for (BaiHat item : tmp.getList("", 0, 5)) {
			System.out.println(item.getTen());
		}
	}
}

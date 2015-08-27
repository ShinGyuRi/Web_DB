package test.com.jsp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.sku.common.util.DBUtil;
import test.com.vo.DeptVO;


public class EmpDAO {

	public List<DeptVO> select() {
		List<DeptVO> userList = new ArrayList<DeptVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from dept");
			rs = ps.executeQuery();
			while(rs.next()){
				DeptVO vo = new DeptVO();
				vo.setDeptno(rs.getString(1));
				vo.setDname(rs.getString(2));
				vo.setLoc(rs.getString(3));
				userList.add(vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, ps, rs);
		}
		return userList;
	}//end select()


	public int insert(DeptVO vo) {
		

		int resultCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into dept values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getDeptno());
			ps.setString(2, vo.getDname());
			ps.setString(3, vo.getLoc());			
			resultCount = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn, ps);
		}
		return resultCount;
	}//end insert()
			
//	public EmpDTO retrieve(String deptno) {
//		
//		EmpDTO dto = new EmpDTO();
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			
//			con = DriverManager.getConnection(url,userid,passwd);
//			String sql = "select * from dept where deptno = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(deptno));
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				dto.setDeptno(rs.getInt("deptno"));
//				dto.setDname(rs.getString("dname"));
//				dto.setLoc(rs.getString("loc"));
//			}
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				rs.close();
//				pstmt.close();
//				con.close();
//			} catch (SQLException se) {
//				// TODO Auto-generated catch block
//				se.printStackTrace();
//			}
//			
//		}
//		
//		return dto;
//		
//	}//end retrieve()
//	
//	public void delete(String deptno) {
//		
//		EmpDTO dto = new EmpDTO();
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			con = DriverManager.getConnection(url,userid,passwd);
//			String sql = "delete from dept where deptno=?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(deptno));
//			int n = pstmt.executeUpdate();
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				pstmt.close();
//				con.close();
//			} catch (SQLException se) {
//				// TODO Auto-generated catch block
//				se.printStackTrace();
//			}
//			
//		}
//		
//
//	}//end delete
//	
//	public void update(String deptno, String dname, String loc) {
//		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			
//			con = DriverManager.getConnection(url,userid,passwd);
//			
//			String sql = "update dept set dname = ?, loc = ? where deptno = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, dname);
//			pstmt.setString(2, loc);
//			pstmt.setInt(3, Integer.parseInt(deptno));
//			int n = pstmt.executeUpdate();
//			
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				pstmt.close();
//				con.close();
//			} catch (SQLException se) {
//
//				se.printStackTrace();
//				
//			}
//		}
//		
//		
//	}//end update()
//	
}
	
	
	
	
package com.project.web.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.project.web.member.dto.MDto;


public class MDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public void getCon() {
		try {
			// 커넥션풀을 이용하여 데이터 베이스에 접근
			Context initctx = new InitialContext();
			// 톰캣 서버에 정보를담아놓은 곳으로 이동
			Context envctx = (Context) initctx.lookup("java:comp/env");

			// 데이터 소스 객체를 선언
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			// 데이터 소스를 기준으로 커넥션을 연결해주시오
			conn = ds.getConnection();
			System.out.println("MDAO: DB 연결 성공");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SQLException :" + e.getMessage());
		} 
	}


	// 회원가입 중복아이디 체크
	public int insertCheckId(String id) {
		getCon();
		int idCheck = 1;
		MDto dto = new MDto();
		try {
			String sql = "select member_Id from member_users where member_id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				dto.setMember_Id(rs.getString("member_Id"));
			}

			if(id.equals(dto.getMember_Id())) {
				idCheck = 0; // DB에 동일한 아이디가 있음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return idCheck;
	}


	public int insertMember(MDto dto) throws SQLException {
		try {
			getCon();

			String sql = "insert into member_users values (?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getMember_Id());
			pstmt.setString(2, dto.getMember_Pw());
			pstmt.setString(3, dto.getMember_Name());
			pstmt.setString(4, dto.getMember_Addr());
			pstmt.setString(5, dto.getMember_Phone());
			pstmt.setString(6, dto.getMember_Email());

			pstmt.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return -1; // 데이터베이스 오류
	}


	public ArrayList<MDto> getUserInfo(String id) throws Exception {
		getCon();
		ArrayList<MDto> member = new ArrayList<MDto>();

		try {
			String sql = "select * from member_users where member_Id =? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				String member_Id = rs.getString("member_Id");
				String member_Pw = rs.getString("member_Pw");
				String member_Name = rs.getString("member_Name");
				String member_Addr = rs.getString("member_Addr");
				String member_Phone = rs.getString("member_Phone");
				String member_Email = rs.getString("member_Email");
				MDto dto = new MDto(member_Id, member_Pw, member_Name, member_Addr, member_Phone, member_Email);
				member.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return member;
	}

	public void updateMember(MDto dto) throws Exception {
		getCon();

		try {
			String sql = "update member_users set member_Pw=?, member_Name=?, member_Addr=?, member_Phone=?, member_Email=? where member_Id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getMember_Pw());
			pstmt.setString(2, dto.getMember_Name());
			pstmt.setString(3, dto.getMember_Addr());
			pstmt.setString(4, dto.getMember_Phone());
			pstmt.setString(5, dto.getMember_Email());
			pstmt.setString(6, dto.getMember_Id());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	// 회원정보를 삭제한다.
	// id 회원정보 삭제 시 필요한 아이디
	// pw 회원정보 삭제 시 필요한 비밀번호
	// x : deletemember() 수행 후 결과값
	public int deleteMember(String id, String pw) throws Exception {
		getCon();
		String dbpw = ""; // DB상의 비밀번호를 담아둘 변수
		int x = -1;

		try {
			// 비밀번호 조회
			String sql1 = "select member_Pw from member_users where member_Id=?";
			// 회원 삭제
			String sql2 = "delete from member_users where member_Id=?";

			// 아이디에 해당하는 비밀번호를 조회한다.
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery(); 

			if(rs.next()) {
				dbpw = rs.getString("member_Pw");
				if(dbpw.equals(pw)) { // 입력된 비밀번호와 DB비밀번호 비교
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, id);
					pstmt.executeUpdate(); // 
					x = 1; // 삭제 성공
				} else {
					x = 0; // 비밀번호 비교결과 다름
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return x;
	}


	public int loginCheck(String id, String passwd) throws Exception {
		getCon();

		String dbpw = ""; // db에서 꺼낸 비밀번호를 담을 변수
		int x = -1;

		try {
			String sql = "select member_Pw from member_users where member_Id =?";

			//			conn = this.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()) 
			{
				dbpw = rs.getString("member_Pw");

				if(dbpw.equals(passwd)) 
					x = 1; // 넘겨받은 비번과 꺼내온 비번 비교. 같으면 인증성공
				else 
					x = 0; // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return x;
	}

	//	public int idCheck(String id) throws Exception {
	//		
	//		getCon();
	//		
	//		try {
	//			String sql = "select * from member_users where member_Id=?";
	//			
	//			pstmt = conn.prepareStatement(sql);
	//			pstmt.setString(1, id);
	//			rs = pstmt.executeQuery();
	//			
	//			if(rs.next()) return 0; // 중복
	//				else return 1;
	//			
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//		return -1;
	//	}

	public int idCheck(String id) throws Exception {
		
		getCon();
		String checkID = "";
		int check = 0;
		try {
			String sql = "select member_Id from member_users where member_Id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				checkID = rs.getString("member_Id");
				
				if(id.equals(checkID)) {
					check = 1;
				} else 
					check = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
		
	}


	// 관리자 - 회원리스트 출력
	public ArrayList<MDto> MemberListAll() {
		getCon();
		MDto dto = null;
		ArrayList<MDto> list = new ArrayList<MDto>();
		try {
			String sql = "select * from member_users";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				dto = new MDto();
				dto.setMember_Id(rs.getString("member_Id"));
				dto.setMember_Pw(rs.getString("member_Pw"));
				dto.setMember_Name(rs.getString("member_Name"));
				dto.setMember_Addr(rs.getString("member_Addr"));
				dto.setMember_Phone(rs.getString("member_Phone"));
				dto.setMember_Email(rs.getString("member_Email"));
				list.add(dto);
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}	
}

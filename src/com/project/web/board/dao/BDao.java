package com.project.web.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.web.board.dto.BDto;

public class BDao {
	
	
	private Connection conn = null; // 데이터 접근을 위한 객체
	private PreparedStatement pstmt = null; // 쿼리문 실행을 위한 객체
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
			System.out.println("BDAO: DB 연결 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연결실패");
		} 
	}
	
//	게시판을 화면에 10개씩 추출해서 리턴하는 메소드
	public ArrayList<BDto> BoardList(int startRow, int endRow) {

		ArrayList<BDto> list = new ArrayList<BDto>();
		getCon();
		
		try {
			// 자식글 까지 포함해서 최신글 10개를 가져오라는 쿼리
			String sql = "select * from (select A.*, Rownum Rnum from (select * from boardtbl order by ref desc, reStep asc)A)"
					+"where Rnum >= ? and Rnum <= ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BDto dto = new BDto();
				dto.setbNum(rs.getInt(1));
				dto.setbWriter(rs.getString(2));
				dto.setbEmail(rs.getString(3));
				dto.setbTitle(rs.getString(4));
				dto.setbPassword(rs.getString(5));
				dto.setbDate(rs.getTimestamp(6)); // 이거
				dto.setRef(rs.getInt(7));
				dto.setReStep(rs.getInt(8));
				dto.setReLevel(rs.getInt(9));
				dto.setReadCount(rs.getInt(10));
				dto.setContent(rs.getString(11));
				
				list.add(dto);
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
		return list;
	}
	
	// 게시글을 작성하는 메소드
	public int BoardWrite(BDto dto) {
		getCon();
		int ref = 0; // 글그룹 : 쿼리를 실행시켜서 가장 큰 ref값을 가져온 후 +1을 더해주면 됨.
		int reStep = 1; // 새글이기에, 부모글이기에
		int reLevel = 1;
		try {
			// 가장 큰 ref값을 읽어오는 쿼리 준비
			String refsql = "select max(ref) from boardtbl";
			
			// 쿼리실행 객체
			pstmt = conn.prepareStatement(refsql);
			
			// 쿼리실행 후 결과를 리턴
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 결과 값이 있다면
				ref = rs.getInt(1)+1; // 최대값에 +1을 더해서 글그룹을 설정
			}
			
			
			String sql = "insert into boardtbl"
					+ "(bNum, bWriter, bEmail, bTitle, bPassword, bDate, ref, reStep, reLevel, readCount, content)"
							+ "values(pboard_seq.NEXTVAL, ?, ?, ?, ?, sysdate, ?, ?, ?, 0, ?)";
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getbWriter());
			pstmt.setString(2, dto.getbEmail());
			pstmt.setString(3, dto.getbTitle());
			pstmt.setString(4, dto.getbPassword());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, reStep);
			pstmt.setInt(7, reLevel);
			pstmt.setString(8, dto.getContent());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} try {
			
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
			
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}
		return 1;
	}
	
	// 한개의 게시판을 보여주는 메소드
	public BDto BoardOne(int bNum) {
		
		BDto dto = null;
		getCon();
		
		try {
			// 게시글 조회수를 증가하는 쿼리
			String readSql = "update boardtbl set readcount = readcount+1 where bNum=?";
			pstmt = conn.prepareStatement(readSql);
			pstmt.setInt(1, bNum);
			pstmt.executeUpdate();
			
			String sql = "select * from boardtbl where bNum=?";
			System.out.println(bNum);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bNum);
			
			System.out.println(bNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BDto();
				dto.setbNum(rs.getInt(1));
				dto.setbWriter(rs.getString(2));
				dto.setbEmail(rs.getString(3));
				dto.setbTitle(rs.getString(4));
				dto.setbDate(rs.getTimestamp(6));
				dto.setRef(rs.getInt(7));
				dto.setReStep(rs.getInt(8));
				dto.setReLevel(rs.getInt(9));
				dto.setReadCount(rs.getInt(10));
				dto.setContent(rs.getString(11));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return dto;
	}
	
	// 수정하는 페이지 보여주기
	public ArrayList<BDto> BoardMofidyForm(int bNum) {
		ArrayList<BDto> list = new ArrayList<BDto>();
		BDto dto = null;
		getCon();
		
		try {
			String sql = "select * from boardtbl where bNum=?";
			System.out.println(bNum);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bNum);
			
			System.out.println(bNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BDto();
				dto.setbNum(rs.getInt(1));
				dto.setbWriter(rs.getString(2));
				dto.setbEmail(rs.getString(3));
				dto.setbTitle(rs.getString(4));
				dto.setReadCount(rs.getInt(10));
				dto.setbDate(rs.getTimestamp(6));
				dto.setContent(rs.getString(11));
				
				list.add(dto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return list;
	}
	
	// 수정했던 정보를 DB에 저장 
	public int BoardModify(int bNum, String bTitle, String content) {
		getCon();
		int test = 0;
		try {
			String sql = "update boardtbl set bTitle=?, content=? where bNum=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			pstmt.setString(2, content);
			pstmt.setInt(3, bNum);
			
			test = pstmt.executeUpdate();
			
			if(test == 0) {
				test = 0;
			} else {
				test = 1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null)
				try {
					pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
		}
		return test;
	}
	
	// 게시글을 삭제하는 메소드
	public void ActionBoardDelete(int bNum) {
		getCon();
		
		try {
			String sql = "delete from boardtbl where bNum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 이메일과 패스워드를 알아오는 메소드
	public BDto WriteForm(String bWriter) {
		getCon();
		BDto dto = null;
		try {
			String sql = "select bEmail, bPassword from boardtbl where bWriter=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bWriter);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BDto();
				dto.setbEmail(rs.getString("bEmail"));
				dto.setbPassword(rs.getString("bPassword"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public void BoardReWrite(BDto dto) {
		// 부모글그룹과 글레벨 글스텝을 읽어드림
		int ref = dto.getRef();
		int reStep = dto.getReStep();
		int reLevel = dto.getReLevel();
		
		getCon();
		
		try {
			// 부모 글보다 reLevel의 값을 전부 1씩 증가시켜줌
			String levelsql = "update boardtbl set relevel = relevel+1 where ref=? and reLevel > ?";
			
			pstmt = conn.prepareStatement(levelsql);
			pstmt.setInt(1, ref);
			pstmt.setInt(2, reLevel);
			
			pstmt.executeUpdate();
			
			// 답변글 데이터를 저장
			String sql = "insert into boardtbl values(pboard_seq.nextval, ?, ?, ?, ?, sysdate, ?, ?, ?,0, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getbWriter());
			pstmt.setString(2, dto.getbEmail());
			pstmt.setString(3, dto.getbTitle());
			pstmt.setString(4, dto.getbPassword());
			pstmt.setInt(5, ref);
			pstmt.setInt(6, reStep + 1); // 기존 부모글에 스텝보다 1을 증가
			pstmt.setInt(7, reLevel + 1); // 기존 부모글에 스텝보다 1을 증가
			pstmt.setString(8, dto.getContent());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	// 전체 게시글의 갯수를 리턴하는 메소드
	public int getAllCount() {
		int count = 0;
		getCon();
		
		try {
			String sql = "select count(*) from boardtbl";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
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
		return count;
	}
}
package com.project.web.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.project.web.product.dto.DDto;
import com.project.web.product.dto.DeliverOkDto;
import com.project.web.product.dto.PDto;
import com.project.web.product.dto.ProductRefundDto;

public class PDao {

	private Connection conn = null; // 데이터 접근을 위한 객체
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void getCon() {
		try {
			// 커넥션풀을 이용하여 데이터베이스에 접근
			Context initctx = new InitialContext();
			
			// 톰캣 서버에 정보를담아놓은 곳으로 이동
			Context envctx = (Context) initctx.lookup("java:comp/env");
			
			// 데이터 소스 객체를 선언
			DataSource ds = (DataSource) envctx.lookup("jdbc/pool");
			
			// 데이터 소스를 기준으로 커넥션을 연결해주시오.
			conn = ds.getConnection();
			System.out.println("PDAO : DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 전체상품을 리턴해주는 메소드
	public ArrayList<PDto> ProductListAll() {
		ArrayList<PDto> list = new ArrayList<PDto>();
		
		getCon();
		
		try {
			String sql = "select * from product";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PDto dto = new PDto();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setCategory(rs.getInt(3));
				dto.setPrice(rs.getInt(4));
				dto.setImg(rs.getString(5));
				dto.setInfo(rs.getString(6));
				
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
	
	// 한개의 상품을 보여주는 메소드
	public PDto ProductDetailForm(int no) {
		PDto dto = null;
		getCon();
		
		try {
			String sql = "select img, name, info, category, price, no from product where no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			System.out.println("디비들어옴");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new PDto();
				dto.setImg(rs.getString("img"));
				dto.setName(rs.getString("name"));
				dto.setInfo(rs.getString("info"));
				dto.setCategory(rs.getInt("category"));
				dto.setPrice(rs.getInt("price"));
				dto.setNo(rs.getInt("no"));
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
		return dto;
	}
	
	// 주문받은 상품을 DB에 저장하는 메소드
	public int ProductBuyOk(DDto Ddto) {
		getCon();
		int test = 0;
		try {
//			String sql = "insert into deliverdb values (?,?,?,?,?,?,?,?,?)";
			String sql = "insert into deliverdb"
							+"(name, phone, zipcode, addr, id, productname, productqty, producttotal, no, productnum)"
								+"values(?,?,?,?,?,?,?,?,?,deliver_seq.nextval)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, Ddto.getName());
			pstmt.setString(2, Ddto.getPhone());
			pstmt.setString(3, Ddto.getZipCode());
			pstmt.setString(4, Ddto.getAddr());
			pstmt.setString(5, Ddto.getId());
			pstmt.setString(6, Ddto.getProductName());
			pstmt.setInt(7, Ddto.getProductQty());
			pstmt.setInt(8, Ddto.getProductTotal());
			pstmt.setInt(9, Ddto.getNo());
			
			
			test = pstmt.executeUpdate();
			
			
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
		return test;
	}
	
	// 구매한 제품 리스트를 출력하는 메소드
	public ArrayList<DDto> ProductOrderList(String id) {
		
		getCon();
		DDto dto = null;
		ArrayList<DDto> list = new ArrayList<DDto>();
		try {
			String sql = "select * from deliverdb where id = ? order by productnum desc";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			System.out.println("orderlist dao id : " + id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new DDto();
				dto.setName(rs.getString(1));
				dto.setAddr(rs.getString(4));
				dto.setProductName(rs.getString(6));
				dto.setProductQty(rs.getInt(7));
				dto.setProductTotal(rs.getInt(8));
				dto.setProductnum(rs.getInt(10));
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
	
	public ArrayList<ProductRefundDto> ProductRefundList() {
		getCon();
		ProductRefundDto dto = null;
		ArrayList<ProductRefundDto> list = new ArrayList<ProductRefundDto>();
		try {
			String sql = "select * from productrefunddb";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new ProductRefundDto();
				dto.setProductNum(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAddr(rs.getString(3));
				dto.setProductName(rs.getString(4));
				dto.setProductQty(rs.getInt(5));
				dto.setProductTotal(rs.getInt(6));
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
	
	// 환불 요청 메소드 ProductRefund DB에 insert
	public void ProductRefund(ProductRefundDto dto) {
		getCon();
		
		try {
			String sql = "insert into productrefunddb values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getProductNum());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getAddr());
			pstmt.setString(4, dto.getProductName());
			pstmt.setInt(5, dto.getProductQty());
			pstmt.setInt(6, dto.getProductTotal());
			
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
	
	
	// 관리자 환불승인(DB 삭제) 메소드
	public void ProductDeleteRefund(int productnum) {
		getCon();
		
		try {
			String sql1 = "delete from productrefunddb where productnum = ?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, productnum);
			pstmt.executeUpdate();
			
			String sql2 = "delete from deliverdb where productnum = ?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, productnum);
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
	
	// 관리자 배송준비(모든 유저가 제품 구입한 정보 출력)
	public ArrayList<DDto> ProductDeliveryPreparation() {
		getCon();
		ArrayList<DDto> list = new ArrayList<DDto>();
		DDto dto = null;
		try {
			String sql = "select * from deliverdb";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new DDto();
				dto.setProductnum(rs.getInt(10));
				dto.setName(rs.getString(1));
				dto.setAddr(rs.getString(4));
				dto.setProductName(rs.getString(6));
				dto.setProductQty(rs.getInt(7));
				dto.setProductTotal(rs.getInt(8));
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
	
	public void ProductDeliverOk(int productnum) {
		getCon();
		DDto Ddto = new DDto();
		DeliverOkDto dto = new DeliverOkDto();
		System.out.println("프로덕넘 DAO : " + productnum);
		try {
			String SelectSQL = "select * from deliverdb where productnum = ?";
			pstmt = conn.prepareStatement(SelectSQL);
			pstmt.setInt(1, productnum);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Ddto.setProductnum(rs.getInt(10));
				Ddto.setName(rs.getString(1));
				Ddto.setAddr(rs.getString(4));
				Ddto.setProductName(rs.getString(6));
				Ddto.setProductQty(rs.getInt(7));
				Ddto.setProductTotal(rs.getInt(8));
			}
			
			String InsertSQL = "insert into deliverokdb values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(InsertSQL);
			
			pstmt.setInt(1, productnum);
			pstmt.setString(2, Ddto.getName());
			pstmt.setString(3, Ddto.getAddr());
			pstmt.setString(4, Ddto.getProductName());
			pstmt.setInt(5, Ddto.getProductQty());
			pstmt.setInt(6, Ddto.getProductTotal());
			
			pstmt.executeUpdate();
			
			String DeleteSQL = "delete from deliverdb where productnum = ?";
			pstmt = conn.prepareStatement(DeleteSQL);
			pstmt.setInt(1, productnum);
			
			pstmt.executeUpdate();
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
	}
	
	// 배송완료 전체 리스트 출력
	public ArrayList<DeliverOkDto> DeliveryOkList() {
		getCon();
		DeliverOkDto dto = null;
		ArrayList<DeliverOkDto> list = new ArrayList<DeliverOkDto>();
		try {
			String sql = "select * from deliverokdb";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new DeliverOkDto();
				dto.setProductNum(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAddr(rs.getString(3));
				dto.setProductName(rs.getString(4));
				dto.setProductQty(rs.getInt(5));
				dto.setProductTotal(rs.getInt(6));
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
	
	// 배송완료된 제품 DB에서 삭제하기
	public void ProductDeliveryOkDelete(int productnum) {
		getCon();
		
		try {
			String sql = "delete from deliverokdb where productnum = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productnum);
			
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
	
	// 중복체크(주문 정보페이지에서 제품취소신청을 했는데 다시 눌렀을 때 alert)
	public int refundOverlapCheck(int productnum1) {
		getCon();
		int num = 0;
		int check = 0;
		try {
			String sql = "select * from productrefunddb where productnum = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productnum1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
			
			if(productnum1 == num) {
				check = 0;
			} else 
				check = 1;
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
}
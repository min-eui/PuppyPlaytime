package com.puppy.client.reservation.vo;

import java.util.Date;

public class ReservationVO {
	private int r_no;			// 예약번호
	private String r_approval; 	// 승인여부
	private int r_payPrice;		// 결제가격
	private Date r_requestDate; // 신청날짜
	private Date r_startDate; 	// 실제 예약 시작날짜
	private Date r_endDate;		// 실제 예약 종료날짜
	private String m_id;		// 아이디
	private int c_no;			// 케이지 번호
	
	public int getR_no() {
		return r_no;
	}
	public void setR_no(int r_no) {
		this.r_no = r_no;
	}
	public String getR_approval() {
		return r_approval;
	}
	public void setR_approval(String r_approval) {
		this.r_approval = r_approval;
	}
	public int getR_payPrice() {
		return r_payPrice;
	}
	public void setR_payPrice(int r_payPrice) {
		this.r_payPrice = r_payPrice;
	}
	public Date getR_requestDate() {
		return r_requestDate;
	}
	public void setR_requestDate(Date r_requestDate) {
		this.r_requestDate = r_requestDate;
	}
	public Date getR_startDate() {
		return r_startDate;
	}
	public void setR_startDate(Date r_startDate) {
		this.r_startDate = r_startDate;
	}
	public Date getR_endDate() {
		return r_endDate;
	}
	public void setR_endDate(Date r_endDate) {
		this.r_endDate = r_endDate;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
}

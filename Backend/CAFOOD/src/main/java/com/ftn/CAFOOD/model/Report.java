package com.ftn.CAFOOD.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Report implements Serializable{
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "report_id")
	private Long report_id;
	
	@Column(name="report_name" , nullable = false , unique = false)
	private String reportName;
	   
	@Enumerated(EnumType.ORDINAL)
	public PERIOD period;
	   
	@Enumerated(EnumType.ORDINAL)
	public TYPE type;
	   
	@Column(name="report_price" , nullable = false , unique = false)
	public Long price;

	public Report() {}
	
	public Report(String reportName, PERIOD period, TYPE type, Long price) {
		super();
		this.reportName = reportName;
		this.period = period;
		this.type = type;
		this.price = price;
	}

	public Long getReport_id() {
		return report_id;
	}

	public void setReport_id(Long report_id) {
		this.report_id = report_id;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public PERIOD getPeriod() {
		return period;
	}

	public void setPeriod(PERIOD period) {
		this.period = period;
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Report [report_id=" + report_id + ", reportName=" + reportName + ", period=" + period + ", type=" + type
				+ ", price=" + price + "]";
	}
	
	
	
}

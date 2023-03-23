package com.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankDetails {
	@Id
	private long accountNumber;
	private String bankName;
	private String bankIFSC_Code;
	private String branchName;
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankIFSC_Code() {
		return bankIFSC_Code;
	}
	public void setBankIFSC_Code(String bankIFSC_Code) {
		this.bankIFSC_Code = bankIFSC_Code;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
}

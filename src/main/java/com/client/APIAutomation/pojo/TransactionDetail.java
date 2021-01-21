package com.client.APIAutomation.pojo;

import java.io.Serializable;
import java.util.List;

public class TransactionDetail implements Serializable{

	private String EmployerID;

    private TransactionRemark[] TransactionRemark;

    private String EmployeeID;

    public String getEmployerID ()
    {
        return EmployerID;
    }

    public void setEmployerID (String EmployerID)
    {
        this.EmployerID = EmployerID;
    }

    public TransactionRemark[] getTransactionRemark ()
    {
        return TransactionRemark;
    }

    public void setTransactionRemark (TransactionRemark[] TransactionRemark)
    {
        this.TransactionRemark = TransactionRemark;
    }

    public String getEmployeeID ()
    {
        return EmployeeID;
    }

    public void setEmployeeID (String EmployeeID)
    {
        this.EmployeeID = EmployeeID;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [EmployerID = "+EmployerID+", TransactionRemark = "+TransactionRemark+", EmployeeID = "+EmployeeID+"]";
    }
	
}

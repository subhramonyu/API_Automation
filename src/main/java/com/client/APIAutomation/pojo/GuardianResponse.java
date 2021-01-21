package com.client.APIAutomation.pojo;

import java.util.List;

public class GuardianResponse {

	private String Audit;

    private String CreationDateTime;

    private String TransmissionStatusCode;

    private String TransactionRemark;

    private TransactionDetail[] TransactionDetail;

    private String TransmissionGUID;

    public String getAudit ()
    {
        return Audit;
    }

    public void setAudit (String Audit)
    {
        this.Audit = Audit;
    }

    public String getCreationDateTime ()
    {
        return CreationDateTime;
    }

    public void setCreationDateTime (String CreationDateTime)
    {
        this.CreationDateTime = CreationDateTime;
    }

    public String getTransmissionStatusCode ()
    {
        return TransmissionStatusCode;
    }

    public void setTransmissionStatusCode (String TransmissionStatusCode)
    {
        this.TransmissionStatusCode = TransmissionStatusCode;
    }

    public String getTransactionRemark ()
    {
        return TransactionRemark;
    }

    public void setTransactionRemark (String TransactionRemark)
    {
        this.TransactionRemark = TransactionRemark;
    }

    public TransactionDetail[] getTransactionDetail ()
    {
        return TransactionDetail;
    }

    public void setTransactionDetail (TransactionDetail[] TransactionDetail)
    {
        this.TransactionDetail = TransactionDetail;
    }

    public String getTransmissionGUID ()
    {
        return TransmissionGUID;
    }

    public void setTransmissionGUID (String TransmissionGUID)
    {
        this.TransmissionGUID = TransmissionGUID;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Audit = "+Audit+", CreationDateTime = "+CreationDateTime+", TransmissionStatusCode = "+TransmissionStatusCode+", TransactionRemark = "+TransactionRemark+", TransactionDetail = "+TransactionDetail+", TransmissionGUID = "+TransmissionGUID+"]";
    }
}

package com.client.APIAutomation.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRemark implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String EntityReferenceID;

    private String MessageTypeCode;

    private String EntityCode;

    private String MessageText;

    private String RemarkStatusCode;

    private String FieldName;

    public String getEntityReferenceID ()
    {
        return EntityReferenceID;
    }

    public void setEntityReferenceID (String EntityReferenceID)
    {
        this.EntityReferenceID = EntityReferenceID;
    }

    public String getMessageTypeCode ()
    {
        return MessageTypeCode;
    }

    public void setMessageTypeCode (String MessageTypeCode)
    {
        this.MessageTypeCode = MessageTypeCode;
    }

    public String getEntityCode ()
    {
        return EntityCode;
    }

    public void setEntityCode (String EntityCode)
    {
        this.EntityCode = EntityCode;
    }

    public String getMessageText ()
    {
        return MessageText;
    }

    public void setMessageText (String MessageText)
    {
        this.MessageText = MessageText;
    }

    public String getRemarkStatusCode ()
    {
        return RemarkStatusCode;
    }

    public void setRemarkStatusCode (String RemarkStatusCode)
    {
        this.RemarkStatusCode = RemarkStatusCode;
    }

    public String getFieldName ()
    {
        return FieldName;
    }

    public void setFieldName (String FieldName)
    {
        this.FieldName = FieldName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [EntityReferenceID = "+EntityReferenceID+", MessageTypeCode = "+MessageTypeCode+", EntityCode = "+EntityCode+", MessageText = "+MessageText+", RemarkStatusCode = "+RemarkStatusCode+", FieldName = "+FieldName+"]";
    }
	
}

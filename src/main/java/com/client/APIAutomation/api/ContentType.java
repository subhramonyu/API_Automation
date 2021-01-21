package com.client.APIAutomation.api;

/**
 * Enum for containing headers , Application content types and OAuth tokens
 * @author subhra.das
 *
 */
public enum ContentType {

    JSON("application/json"),
    XML("text/xml; charset=utf-8");

    private String contentType;

    private ContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    @Override
    public String toString() {
        return this.getContentType();
    }
}
/**
 * RegistrationRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gov.bgc.bean.xsd;

public class RegistrationRequest  implements java.io.Serializable {
    private com.gov.bgc.bean.xsd.Applicant applicant;

    private com.gov.bgc.bean.xsd.LoanRequest loanRequest;

    public RegistrationRequest() {
    }

    public RegistrationRequest(
           com.gov.bgc.bean.xsd.Applicant applicant,
           com.gov.bgc.bean.xsd.LoanRequest loanRequest) {
           this.applicant = applicant;
           this.loanRequest = loanRequest;
    }


    /**
     * Gets the applicant value for this RegistrationRequest.
     * 
     * @return applicant
     */
    public com.gov.bgc.bean.xsd.Applicant getApplicant() {
        return applicant;
    }


    /**
     * Sets the applicant value for this RegistrationRequest.
     * 
     * @param applicant
     */
    public void setApplicant(com.gov.bgc.bean.xsd.Applicant applicant) {
        this.applicant = applicant;
    }


    /**
     * Gets the loanRequest value for this RegistrationRequest.
     * 
     * @return loanRequest
     */
    public com.gov.bgc.bean.xsd.LoanRequest getLoanRequest() {
        return loanRequest;
    }


    /**
     * Sets the loanRequest value for this RegistrationRequest.
     * 
     * @param loanRequest
     */
    public void setLoanRequest(com.gov.bgc.bean.xsd.LoanRequest loanRequest) {
        this.loanRequest = loanRequest;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RegistrationRequest)) return false;
        RegistrationRequest other = (RegistrationRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applicant==null && other.getApplicant()==null) || 
             (this.applicant!=null &&
              this.applicant.equals(other.getApplicant()))) &&
            ((this.loanRequest==null && other.getLoanRequest()==null) || 
             (this.loanRequest!=null &&
              this.loanRequest.equals(other.getLoanRequest())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getApplicant() != null) {
            _hashCode += getApplicant().hashCode();
        }
        if (getLoanRequest() != null) {
            _hashCode += getLoanRequest().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RegistrationRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "RegistrationRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicant");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "applicant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "Applicant"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loanRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "loanRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "LoanRequest"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

/**
 * LoanRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gov.bgc.bean.xsd;

public class LoanRequest  implements java.io.Serializable {
    private java.lang.Integer loanAmount;

    private java.lang.Integer loanTenure;

    private java.lang.String remarks;

    public LoanRequest() {
    }

    public LoanRequest(
           java.lang.Integer loanAmount,
           java.lang.Integer loanTenure,
           java.lang.String remarks) {
           this.loanAmount = loanAmount;
           this.loanTenure = loanTenure;
           this.remarks = remarks;
    }


    /**
     * Gets the loanAmount value for this LoanRequest.
     * 
     * @return loanAmount
     */
    public java.lang.Integer getLoanAmount() {
        return loanAmount;
    }


    /**
     * Sets the loanAmount value for this LoanRequest.
     * 
     * @param loanAmount
     */
    public void setLoanAmount(java.lang.Integer loanAmount) {
        this.loanAmount = loanAmount;
    }


    /**
     * Gets the loanTenure value for this LoanRequest.
     * 
     * @return loanTenure
     */
    public java.lang.Integer getLoanTenure() {
        return loanTenure;
    }


    /**
     * Sets the loanTenure value for this LoanRequest.
     * 
     * @param loanTenure
     */
    public void setLoanTenure(java.lang.Integer loanTenure) {
        this.loanTenure = loanTenure;
    }


    /**
     * Gets the remarks value for this LoanRequest.
     * 
     * @return remarks
     */
    public java.lang.String getRemarks() {
        return remarks;
    }


    /**
     * Sets the remarks value for this LoanRequest.
     * 
     * @param remarks
     */
    public void setRemarks(java.lang.String remarks) {
        this.remarks = remarks;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoanRequest)) return false;
        LoanRequest other = (LoanRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.loanAmount==null && other.getLoanAmount()==null) || 
             (this.loanAmount!=null &&
              this.loanAmount.equals(other.getLoanAmount()))) &&
            ((this.loanTenure==null && other.getLoanTenure()==null) || 
             (this.loanTenure!=null &&
              this.loanTenure.equals(other.getLoanTenure()))) &&
            ((this.remarks==null && other.getRemarks()==null) || 
             (this.remarks!=null &&
              this.remarks.equals(other.getRemarks())));
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
        if (getLoanAmount() != null) {
            _hashCode += getLoanAmount().hashCode();
        }
        if (getLoanTenure() != null) {
            _hashCode += getLoanTenure().hashCode();
        }
        if (getRemarks() != null) {
            _hashCode += getRemarks().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoanRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "LoanRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loanAmount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "loanAmount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loanTenure");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "loanTenure"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remarks");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "remarks"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

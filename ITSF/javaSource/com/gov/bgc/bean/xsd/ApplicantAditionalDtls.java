/**
 * ApplicantAditionalDtls.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gov.bgc.bean.xsd;

public class ApplicantAditionalDtls  implements java.io.Serializable {
    private java.lang.String dlNo;

    private java.lang.String passportCountry;

    private java.lang.String passportNo;

    private java.lang.String passportValidity;

    private java.lang.String ssn;

    public ApplicantAditionalDtls() {
    }

    public ApplicantAditionalDtls(
           java.lang.String dlNo,
           java.lang.String passportCountry,
           java.lang.String passportNo,
           java.lang.String passportValidity,
           java.lang.String ssn) {
           this.dlNo = dlNo;
           this.passportCountry = passportCountry;
           this.passportNo = passportNo;
           this.passportValidity = passportValidity;
           this.ssn = ssn;
    }


    /**
     * Gets the dlNo value for this ApplicantAditionalDtls.
     * 
     * @return dlNo
     */
    public java.lang.String getDlNo() {
        return dlNo;
    }


    /**
     * Sets the dlNo value for this ApplicantAditionalDtls.
     * 
     * @param dlNo
     */
    public void setDlNo(java.lang.String dlNo) {
        this.dlNo = dlNo;
    }


    /**
     * Gets the passportCountry value for this ApplicantAditionalDtls.
     * 
     * @return passportCountry
     */
    public java.lang.String getPassportCountry() {
        return passportCountry;
    }


    /**
     * Sets the passportCountry value for this ApplicantAditionalDtls.
     * 
     * @param passportCountry
     */
    public void setPassportCountry(java.lang.String passportCountry) {
        this.passportCountry = passportCountry;
    }


    /**
     * Gets the passportNo value for this ApplicantAditionalDtls.
     * 
     * @return passportNo
     */
    public java.lang.String getPassportNo() {
        return passportNo;
    }


    /**
     * Sets the passportNo value for this ApplicantAditionalDtls.
     * 
     * @param passportNo
     */
    public void setPassportNo(java.lang.String passportNo) {
        this.passportNo = passportNo;
    }


    /**
     * Gets the passportValidity value for this ApplicantAditionalDtls.
     * 
     * @return passportValidity
     */
    public java.lang.String getPassportValidity() {
        return passportValidity;
    }


    /**
     * Sets the passportValidity value for this ApplicantAditionalDtls.
     * 
     * @param passportValidity
     */
    public void setPassportValidity(java.lang.String passportValidity) {
        this.passportValidity = passportValidity;
    }


    /**
     * Gets the ssn value for this ApplicantAditionalDtls.
     * 
     * @return ssn
     */
    public java.lang.String getSsn() {
        return ssn;
    }


    /**
     * Sets the ssn value for this ApplicantAditionalDtls.
     * 
     * @param ssn
     */
    public void setSsn(java.lang.String ssn) {
        this.ssn = ssn;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ApplicantAditionalDtls)) return false;
        ApplicantAditionalDtls other = (ApplicantAditionalDtls) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dlNo==null && other.getDlNo()==null) || 
             (this.dlNo!=null &&
              this.dlNo.equals(other.getDlNo()))) &&
            ((this.passportCountry==null && other.getPassportCountry()==null) || 
             (this.passportCountry!=null &&
              this.passportCountry.equals(other.getPassportCountry()))) &&
            ((this.passportNo==null && other.getPassportNo()==null) || 
             (this.passportNo!=null &&
              this.passportNo.equals(other.getPassportNo()))) &&
            ((this.passportValidity==null && other.getPassportValidity()==null) || 
             (this.passportValidity!=null &&
              this.passportValidity.equals(other.getPassportValidity()))) &&
            ((this.ssn==null && other.getSsn()==null) || 
             (this.ssn!=null &&
              this.ssn.equals(other.getSsn())));
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
        if (getDlNo() != null) {
            _hashCode += getDlNo().hashCode();
        }
        if (getPassportCountry() != null) {
            _hashCode += getPassportCountry().hashCode();
        }
        if (getPassportNo() != null) {
            _hashCode += getPassportNo().hashCode();
        }
        if (getPassportValidity() != null) {
            _hashCode += getPassportValidity().hashCode();
        }
        if (getSsn() != null) {
            _hashCode += getSsn().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ApplicantAditionalDtls.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "ApplicantAditionalDtls"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dlNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "dlNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passportCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "passportCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passportNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "passportNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("passportValidity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "passportValidity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ssn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "ssn"));
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

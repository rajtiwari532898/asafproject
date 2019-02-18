/**
 * Applicant.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gov.bgc.bean.xsd;

public class Applicant  implements java.io.Serializable {
    private com.gov.bgc.bean.xsd.Address address;

    private java.lang.Integer age;

    private java.lang.Integer annualExpense;

    private java.lang.Integer annualIncome;

    private com.gov.bgc.bean.xsd.ApplicantAditionalDtls applicantAditionalDtls;

    private com.gov.bgc.bean.xsd.BankAccountDtls bankAccountDetails;

    private java.lang.String email;

    private java.lang.String firstName;

    private java.lang.String gender;

    private java.lang.Integer id;

    private java.lang.String jobType;

    private java.lang.String lastName;

    private java.lang.String midleName;

    public Applicant() {
    }

    public Applicant(
           com.gov.bgc.bean.xsd.Address address,
           java.lang.Integer age,
           java.lang.Integer annualExpense,
           java.lang.Integer annualIncome,
           com.gov.bgc.bean.xsd.ApplicantAditionalDtls applicantAditionalDtls,
           com.gov.bgc.bean.xsd.BankAccountDtls bankAccountDetails,
           java.lang.String email,
           java.lang.String firstName,
           java.lang.String gender,
           java.lang.Integer id,
           java.lang.String jobType,
           java.lang.String lastName,
           java.lang.String midleName) {
           this.address = address;
           this.age = age;
           this.annualExpense = annualExpense;
           this.annualIncome = annualIncome;
           this.applicantAditionalDtls = applicantAditionalDtls;
           this.bankAccountDetails = bankAccountDetails;
           this.email = email;
           this.firstName = firstName;
           this.gender = gender;
           this.id = id;
           this.jobType = jobType;
           this.lastName = lastName;
           this.midleName = midleName;
    }


    /**
     * Gets the address value for this Applicant.
     * 
     * @return address
     */
    public com.gov.bgc.bean.xsd.Address getAddress() {
        return address;
    }


    /**
     * Sets the address value for this Applicant.
     * 
     * @param address
     */
    public void setAddress(com.gov.bgc.bean.xsd.Address address) {
        this.address = address;
    }


    /**
     * Gets the age value for this Applicant.
     * 
     * @return age
     */
    public java.lang.Integer getAge() {
        return age;
    }


    /**
     * Sets the age value for this Applicant.
     * 
     * @param age
     */
    public void setAge(java.lang.Integer age) {
        this.age = age;
    }


    /**
     * Gets the annualExpense value for this Applicant.
     * 
     * @return annualExpense
     */
    public java.lang.Integer getAnnualExpense() {
        return annualExpense;
    }


    /**
     * Sets the annualExpense value for this Applicant.
     * 
     * @param annualExpense
     */
    public void setAnnualExpense(java.lang.Integer annualExpense) {
        this.annualExpense = annualExpense;
    }


    /**
     * Gets the annualIncome value for this Applicant.
     * 
     * @return annualIncome
     */
    public java.lang.Integer getAnnualIncome() {
        return annualIncome;
    }


    /**
     * Sets the annualIncome value for this Applicant.
     * 
     * @param annualIncome
     */
    public void setAnnualIncome(java.lang.Integer annualIncome) {
        this.annualIncome = annualIncome;
    }


    /**
     * Gets the applicantAditionalDtls value for this Applicant.
     * 
     * @return applicantAditionalDtls
     */
    public com.gov.bgc.bean.xsd.ApplicantAditionalDtls getApplicantAditionalDtls() {
        return applicantAditionalDtls;
    }


    /**
     * Sets the applicantAditionalDtls value for this Applicant.
     * 
     * @param applicantAditionalDtls
     */
    public void setApplicantAditionalDtls(com.gov.bgc.bean.xsd.ApplicantAditionalDtls applicantAditionalDtls) {
        this.applicantAditionalDtls = applicantAditionalDtls;
    }


    /**
     * Gets the bankAccountDetails value for this Applicant.
     * 
     * @return bankAccountDetails
     */
    public com.gov.bgc.bean.xsd.BankAccountDtls getBankAccountDetails() {
        return bankAccountDetails;
    }


    /**
     * Sets the bankAccountDetails value for this Applicant.
     * 
     * @param bankAccountDetails
     */
    public void setBankAccountDetails(com.gov.bgc.bean.xsd.BankAccountDtls bankAccountDetails) {
        this.bankAccountDetails = bankAccountDetails;
    }


    /**
     * Gets the email value for this Applicant.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this Applicant.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the firstName value for this Applicant.
     * 
     * @return firstName
     */
    public java.lang.String getFirstName() {
        return firstName;
    }


    /**
     * Sets the firstName value for this Applicant.
     * 
     * @param firstName
     */
    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }


    /**
     * Gets the gender value for this Applicant.
     * 
     * @return gender
     */
    public java.lang.String getGender() {
        return gender;
    }


    /**
     * Sets the gender value for this Applicant.
     * 
     * @param gender
     */
    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }


    /**
     * Gets the id value for this Applicant.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this Applicant.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }


    /**
     * Gets the jobType value for this Applicant.
     * 
     * @return jobType
     */
    public java.lang.String getJobType() {
        return jobType;
    }


    /**
     * Sets the jobType value for this Applicant.
     * 
     * @param jobType
     */
    public void setJobType(java.lang.String jobType) {
        this.jobType = jobType;
    }


    /**
     * Gets the lastName value for this Applicant.
     * 
     * @return lastName
     */
    public java.lang.String getLastName() {
        return lastName;
    }


    /**
     * Sets the lastName value for this Applicant.
     * 
     * @param lastName
     */
    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the midleName value for this Applicant.
     * 
     * @return midleName
     */
    public java.lang.String getMidleName() {
        return midleName;
    }


    /**
     * Sets the midleName value for this Applicant.
     * 
     * @param midleName
     */
    public void setMidleName(java.lang.String midleName) {
        this.midleName = midleName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Applicant)) return false;
        Applicant other = (Applicant) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.age==null && other.getAge()==null) || 
             (this.age!=null &&
              this.age.equals(other.getAge()))) &&
            ((this.annualExpense==null && other.getAnnualExpense()==null) || 
             (this.annualExpense!=null &&
              this.annualExpense.equals(other.getAnnualExpense()))) &&
            ((this.annualIncome==null && other.getAnnualIncome()==null) || 
             (this.annualIncome!=null &&
              this.annualIncome.equals(other.getAnnualIncome()))) &&
            ((this.applicantAditionalDtls==null && other.getApplicantAditionalDtls()==null) || 
             (this.applicantAditionalDtls!=null &&
              this.applicantAditionalDtls.equals(other.getApplicantAditionalDtls()))) &&
            ((this.bankAccountDetails==null && other.getBankAccountDetails()==null) || 
             (this.bankAccountDetails!=null &&
              this.bankAccountDetails.equals(other.getBankAccountDetails()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.firstName==null && other.getFirstName()==null) || 
             (this.firstName!=null &&
              this.firstName.equals(other.getFirstName()))) &&
            ((this.gender==null && other.getGender()==null) || 
             (this.gender!=null &&
              this.gender.equals(other.getGender()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.jobType==null && other.getJobType()==null) || 
             (this.jobType!=null &&
              this.jobType.equals(other.getJobType()))) &&
            ((this.lastName==null && other.getLastName()==null) || 
             (this.lastName!=null &&
              this.lastName.equals(other.getLastName()))) &&
            ((this.midleName==null && other.getMidleName()==null) || 
             (this.midleName!=null &&
              this.midleName.equals(other.getMidleName())));
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
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getAge() != null) {
            _hashCode += getAge().hashCode();
        }
        if (getAnnualExpense() != null) {
            _hashCode += getAnnualExpense().hashCode();
        }
        if (getAnnualIncome() != null) {
            _hashCode += getAnnualIncome().hashCode();
        }
        if (getApplicantAditionalDtls() != null) {
            _hashCode += getApplicantAditionalDtls().hashCode();
        }
        if (getBankAccountDetails() != null) {
            _hashCode += getBankAccountDetails().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getFirstName() != null) {
            _hashCode += getFirstName().hashCode();
        }
        if (getGender() != null) {
            _hashCode += getGender().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getJobType() != null) {
            _hashCode += getJobType().hashCode();
        }
        if (getLastName() != null) {
            _hashCode += getLastName().hashCode();
        }
        if (getMidleName() != null) {
            _hashCode += getMidleName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Applicant.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "Applicant"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "Address"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("age");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "age"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annualExpense");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "annualExpense"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("annualIncome");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "annualIncome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantAditionalDtls");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "applicantAditionalDtls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "ApplicantAditionalDtls"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankAccountDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "bankAccountDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "BankAccountDtls"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "firstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gender");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "gender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "jobType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "lastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("midleName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.bgc.gov.com/xsd", "midleName"));
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

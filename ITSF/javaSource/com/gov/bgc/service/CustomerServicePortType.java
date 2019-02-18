/**
 * CustomerServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gov.bgc.service;

public interface CustomerServicePortType extends java.rmi.Remote {
    public com.gov.bgc.bean.xsd.RegistrationResponse registration(com.gov.bgc.bean.xsd.RegistrationRequest request) throws java.rmi.RemoteException;
    public com.gov.bgc.bean.xsd.LoanProductResponse getLoanProduct(com.gov.bgc.bean.xsd.LoanProductRequest request) throws java.rmi.RemoteException;
}

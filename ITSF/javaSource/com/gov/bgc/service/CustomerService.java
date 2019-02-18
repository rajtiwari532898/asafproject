/**
 * CustomerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gov.bgc.service;

public interface CustomerService extends javax.xml.rpc.Service {
    public java.lang.String getCustomerServiceHttpSoap11EndpointAddress();

    public com.gov.bgc.service.CustomerServicePortType getCustomerServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public com.gov.bgc.service.CustomerServicePortType getCustomerServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}

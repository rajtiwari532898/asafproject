/**
 * CustomerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.gov.bgc.service;

public class CustomerServiceLocator extends org.apache.axis.client.Service implements com.gov.bgc.service.CustomerService {

    public CustomerServiceLocator() {
    }


    public CustomerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CustomerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CustomerServiceHttpSoap11Endpoint
    private java.lang.String CustomerServiceHttpSoap11Endpoint_address = "http://localhost:8088/BGCProject/services/CustomerService.CustomerServiceHttpSoap11Endpoint/";

    public java.lang.String getCustomerServiceHttpSoap11EndpointAddress() {
        return CustomerServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CustomerServiceHttpSoap11EndpointWSDDServiceName = "CustomerServiceHttpSoap11Endpoint";

    public java.lang.String getCustomerServiceHttpSoap11EndpointWSDDServiceName() {
        return CustomerServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setCustomerServiceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        CustomerServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public com.gov.bgc.service.CustomerServicePortType getCustomerServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CustomerServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCustomerServiceHttpSoap11Endpoint(endpoint);
    }

    public com.gov.bgc.service.CustomerServicePortType getCustomerServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.gov.bgc.service.CustomerServiceSoap11BindingStub _stub = new com.gov.bgc.service.CustomerServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getCustomerServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCustomerServiceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        CustomerServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.gov.bgc.service.CustomerServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.gov.bgc.service.CustomerServiceSoap11BindingStub _stub = new com.gov.bgc.service.CustomerServiceSoap11BindingStub(new java.net.URL(CustomerServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getCustomerServiceHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CustomerServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getCustomerServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.bgc.gov.com", "CustomerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.bgc.gov.com", "CustomerServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CustomerServiceHttpSoap11Endpoint".equals(portName)) {
            setCustomerServiceHttpSoap11EndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}

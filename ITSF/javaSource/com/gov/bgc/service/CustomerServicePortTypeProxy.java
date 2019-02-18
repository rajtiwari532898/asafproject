package com.gov.bgc.service;

public class CustomerServicePortTypeProxy implements com.gov.bgc.service.CustomerServicePortType {
  private String _endpoint = null;
  private com.gov.bgc.service.CustomerServicePortType customerServicePortType = null;
  
  public CustomerServicePortTypeProxy() {
    _initCustomerServicePortTypeProxy();
  }
  
  public CustomerServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCustomerServicePortTypeProxy();
  }
  
  private void _initCustomerServicePortTypeProxy() {
    try {
      customerServicePortType = (new com.gov.bgc.service.CustomerServiceLocator()).getCustomerServiceHttpSoap11Endpoint();
      if (customerServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)customerServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)customerServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (customerServicePortType != null)
      ((javax.xml.rpc.Stub)customerServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.gov.bgc.service.CustomerServicePortType getCustomerServicePortType() {
    if (customerServicePortType == null)
      _initCustomerServicePortTypeProxy();
    return customerServicePortType;
  }
  
  public com.gov.bgc.bean.xsd.RegistrationResponse registration(com.gov.bgc.bean.xsd.RegistrationRequest request) throws java.rmi.RemoteException{
    if (customerServicePortType == null)
      _initCustomerServicePortTypeProxy();
    return customerServicePortType.registration(request);
  }
  
  public com.gov.bgc.bean.xsd.LoanProductResponse getLoanProduct(com.gov.bgc.bean.xsd.LoanProductRequest request) throws java.rmi.RemoteException{
    if (customerServicePortType == null)
      _initCustomerServicePortTypeProxy();
    return customerServicePortType.getLoanProduct(request);
  }
  
  
}
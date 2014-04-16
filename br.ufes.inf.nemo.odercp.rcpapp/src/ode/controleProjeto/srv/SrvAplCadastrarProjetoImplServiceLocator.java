/**
 * SrvAplCadastrarProjetoImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ode.controleProjeto.srv;

public class SrvAplCadastrarProjetoImplServiceLocator extends org.apache.axis.client.Service implements ode.controleProjeto.srv.SrvAplCadastrarProjetoImplService {

    public SrvAplCadastrarProjetoImplServiceLocator() {
    }


    public SrvAplCadastrarProjetoImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SrvAplCadastrarProjetoImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SrvAplCadastrarProjetoImplPort
    private java.lang.String SrvAplCadastrarProjetoImplPort_address = "http://dev.nemo.inf.ufes.br:8080/ode-web/servicos/srvCadastrarProjeto";

    public java.lang.String getSrvAplCadastrarProjetoImplPortAddress() {
        return SrvAplCadastrarProjetoImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SrvAplCadastrarProjetoImplPortWSDDServiceName = "SrvAplCadastrarProjetoImplPort";

    public java.lang.String getSrvAplCadastrarProjetoImplPortWSDDServiceName() {
        return SrvAplCadastrarProjetoImplPortWSDDServiceName;
    }

    public void setSrvAplCadastrarProjetoImplPortWSDDServiceName(java.lang.String name) {
        SrvAplCadastrarProjetoImplPortWSDDServiceName = name;
    }

    public ode.controleProjeto.srv.SrvAplCadastrarProjeto getSrvAplCadastrarProjetoImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SrvAplCadastrarProjetoImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSrvAplCadastrarProjetoImplPort(endpoint);
    }

    public ode.controleProjeto.srv.SrvAplCadastrarProjeto getSrvAplCadastrarProjetoImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ode.controleProjeto.srv.SrvAplCadastrarProjetoImplServiceSoapBindingStub _stub = new ode.controleProjeto.srv.SrvAplCadastrarProjetoImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSrvAplCadastrarProjetoImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSrvAplCadastrarProjetoImplPortEndpointAddress(java.lang.String address) {
        SrvAplCadastrarProjetoImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ode.controleProjeto.srv.SrvAplCadastrarProjeto.class.isAssignableFrom(serviceEndpointInterface)) {
                ode.controleProjeto.srv.SrvAplCadastrarProjetoImplServiceSoapBindingStub _stub = new ode.controleProjeto.srv.SrvAplCadastrarProjetoImplServiceSoapBindingStub(new java.net.URL(SrvAplCadastrarProjetoImplPort_address), this);
                _stub.setPortName(getSrvAplCadastrarProjetoImplPortWSDDServiceName());
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
        if ("SrvAplCadastrarProjetoImplPort".equals(inputPortName)) {
            return getSrvAplCadastrarProjetoImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://srv.controleProjeto.ode/", "SrvAplCadastrarProjetoImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://srv.controleProjeto.ode/", "SrvAplCadastrarProjetoImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SrvAplCadastrarProjetoImplPort".equals(portName)) {
            setSrvAplCadastrarProjetoImplPortEndpointAddress(address);
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

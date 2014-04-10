/**
 * SrvAplAutenticarUsuarioImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ode.controleUsuario.srv;

public class SrvAplAutenticarUsuarioImplServiceLocator extends org.apache.axis.client.Service implements ode.controleUsuario.srv.SrvAplAutenticarUsuarioImplService {

    public SrvAplAutenticarUsuarioImplServiceLocator() {
    }


    public SrvAplAutenticarUsuarioImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SrvAplAutenticarUsuarioImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SrvAplAutenticarUsuarioImplPort
    private java.lang.String SrvAplAutenticarUsuarioImplPort_address = "http://dev.nemo.inf.ufes.br:8080/ode-web/servicos/srvAutenticarUsuario";

    public java.lang.String getSrvAplAutenticarUsuarioImplPortAddress() {
        return SrvAplAutenticarUsuarioImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SrvAplAutenticarUsuarioImplPortWSDDServiceName = "SrvAplAutenticarUsuarioImplPort";

    public java.lang.String getSrvAplAutenticarUsuarioImplPortWSDDServiceName() {
        return SrvAplAutenticarUsuarioImplPortWSDDServiceName;
    }

    public void setSrvAplAutenticarUsuarioImplPortWSDDServiceName(java.lang.String name) {
        SrvAplAutenticarUsuarioImplPortWSDDServiceName = name;
    }

    public ode.controleUsuario.srv.SrvAplAutenticarUsuario getSrvAplAutenticarUsuarioImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SrvAplAutenticarUsuarioImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSrvAplAutenticarUsuarioImplPort(endpoint);
    }

    public ode.controleUsuario.srv.SrvAplAutenticarUsuario getSrvAplAutenticarUsuarioImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ode.controleUsuario.srv.SrvAplAutenticarUsuarioImplServiceSoapBindingStub _stub = new ode.controleUsuario.srv.SrvAplAutenticarUsuarioImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSrvAplAutenticarUsuarioImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSrvAplAutenticarUsuarioImplPortEndpointAddress(java.lang.String address) {
        SrvAplAutenticarUsuarioImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ode.controleUsuario.srv.SrvAplAutenticarUsuario.class.isAssignableFrom(serviceEndpointInterface)) {
                ode.controleUsuario.srv.SrvAplAutenticarUsuarioImplServiceSoapBindingStub _stub = new ode.controleUsuario.srv.SrvAplAutenticarUsuarioImplServiceSoapBindingStub(new java.net.URL(SrvAplAutenticarUsuarioImplPort_address), this);
                _stub.setPortName(getSrvAplAutenticarUsuarioImplPortWSDDServiceName());
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
        if ("SrvAplAutenticarUsuarioImplPort".equals(inputPortName)) {
            return getSrvAplAutenticarUsuarioImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://srv.controleUsuario.ode/", "SrvAplAutenticarUsuarioImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://srv.controleUsuario.ode/", "SrvAplAutenticarUsuarioImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SrvAplAutenticarUsuarioImplPort".equals(portName)) {
            setSrvAplAutenticarUsuarioImplPortEndpointAddress(address);
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

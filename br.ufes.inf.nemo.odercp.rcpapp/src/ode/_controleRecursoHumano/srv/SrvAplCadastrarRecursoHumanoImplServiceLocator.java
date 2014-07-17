/**
 * SrvAplCadastrarRecursoHumanoImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ode._controleRecursoHumano.srv;

public class SrvAplCadastrarRecursoHumanoImplServiceLocator extends org.apache.axis.client.Service implements ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumanoImplService {

    public SrvAplCadastrarRecursoHumanoImplServiceLocator() {
    }


    public SrvAplCadastrarRecursoHumanoImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SrvAplCadastrarRecursoHumanoImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SrvAplCadastrarRecursoHumanoImplPort
    private java.lang.String SrvAplCadastrarRecursoHumanoImplPort_address = "http://dev.nemo.inf.ufes.br:8080/ode-web/servicos/srvCadastrarRecursoHumano";

    public java.lang.String getSrvAplCadastrarRecursoHumanoImplPortAddress() {
        return SrvAplCadastrarRecursoHumanoImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SrvAplCadastrarRecursoHumanoImplPortWSDDServiceName = "SrvAplCadastrarRecursoHumanoImplPort";

    public java.lang.String getSrvAplCadastrarRecursoHumanoImplPortWSDDServiceName() {
        return SrvAplCadastrarRecursoHumanoImplPortWSDDServiceName;
    }

    public void setSrvAplCadastrarRecursoHumanoImplPortWSDDServiceName(java.lang.String name) {
        SrvAplCadastrarRecursoHumanoImplPortWSDDServiceName = name;
    }

    public ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumano getSrvAplCadastrarRecursoHumanoImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SrvAplCadastrarRecursoHumanoImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSrvAplCadastrarRecursoHumanoImplPort(endpoint);
    }

    public ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumano getSrvAplCadastrarRecursoHumanoImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumanoImplServiceSoapBindingStub _stub = new ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumanoImplServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSrvAplCadastrarRecursoHumanoImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSrvAplCadastrarRecursoHumanoImplPortEndpointAddress(java.lang.String address) {
        SrvAplCadastrarRecursoHumanoImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumano.class.isAssignableFrom(serviceEndpointInterface)) {
                ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumanoImplServiceSoapBindingStub _stub = new ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumanoImplServiceSoapBindingStub(new java.net.URL(SrvAplCadastrarRecursoHumanoImplPort_address), this);
                _stub.setPortName(getSrvAplCadastrarRecursoHumanoImplPortWSDDServiceName());
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
        if ("SrvAplCadastrarRecursoHumanoImplPort".equals(inputPortName)) {
            return getSrvAplCadastrarRecursoHumanoImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://srv._controleRecursoHumano.ode/", "SrvAplCadastrarRecursoHumanoImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://srv._controleRecursoHumano.ode/", "SrvAplCadastrarRecursoHumanoImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SrvAplCadastrarRecursoHumanoImplPort".equals(portName)) {
            setSrvAplCadastrarRecursoHumanoImplPortEndpointAddress(address);
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

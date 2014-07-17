/**
 * SrvAplAutenticarUsuario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ode.controleUsuario.srv;

public interface SrvAplAutenticarUsuario extends java.rmi.Remote {
    public java.lang.Long efetuarLogin(java.lang.String user, java.lang.String senha, boolean remember) throws java.rmi.RemoteException, ode.controleUsuario.srv.NucleoRegraNegocioExcecao;
}

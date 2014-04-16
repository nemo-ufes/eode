/**
 * SrvAplCadastrarProjeto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ode.controleProjeto.srv;

public interface SrvAplCadastrarProjeto extends java.rmi.Remote {
    public void excluir(ode.controleProjeto.srv.Projeto arg0) throws java.rmi.RemoteException;
    public int recuperarQuantidadeTotal() throws java.rmi.RemoteException;
    public int salvar(ode.controleProjeto.srv.Projeto arg0) throws java.rmi.RemoteException;
    public ode.controleProjeto.srv.Projeto recuperarPorId(long id) throws java.rmi.RemoteException;
    public ode.controleProjeto.srv.Projeto[] recuperarTodos() throws java.rmi.RemoteException;
}

/**
 * SrvAplCadastrarRecursoHumano.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ode._controleRecursoHumano.srv;

public interface SrvAplCadastrarRecursoHumano extends java.rmi.Remote {
    public ode._controleRecursoHumano.srv.RecursoHumano recuperarPorId(long id) throws java.rmi.RemoteException;
    public int recuperarQuantidadeTotal() throws java.rmi.RemoteException;
    public void excluir(ode._controleRecursoHumano.srv.RecursoHumano arg0) throws java.rmi.RemoteException;
    public ode._controleRecursoHumano.srv.RecursoHumano[] recuperarTodos() throws java.rmi.RemoteException;
    public ode._controleRecursoHumano.srv.RecursoHumano[] recuperarRecursosHumanosAtivos() throws java.rmi.RemoteException;
    public ode._controleRecursoHumano.srv.RecursoHumano[] recuperarPorCargo(ode._controleRecursoHumano.srv.KRecursoHumano kRH) throws java.rmi.RemoteException;
    public void salvar(ode._controleRecursoHumano.srv.RecursoHumano arg0) throws java.rmi.RemoteException;
}

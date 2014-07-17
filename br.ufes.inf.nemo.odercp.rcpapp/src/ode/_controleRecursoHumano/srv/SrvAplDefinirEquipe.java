/**
 * SrvAplDefinirEquipe.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ode._controleRecursoHumano.srv;

public interface SrvAplDefinirEquipe extends java.rmi.Remote {
    public ode._controleRecursoHumano.srv.Equipe obterEquipePorProjeto(long id) throws java.rmi.RemoteException;
    public void definirEquipe(ode._controleRecursoHumano.srv.RecursoHumano[] arg0, ode._controleRecursoHumano.srv.Projeto arg1) throws java.rmi.RemoteException;
    public ode._controleRecursoHumano.srv.Equipe[] recuperarTodos() throws java.rmi.RemoteException;
    public void atualizar(ode._controleRecursoHumano.srv.Equipe arg0) throws java.rmi.RemoteException;
}

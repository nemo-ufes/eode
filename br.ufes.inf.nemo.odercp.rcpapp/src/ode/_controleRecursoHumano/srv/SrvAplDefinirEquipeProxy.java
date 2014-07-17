package ode._controleRecursoHumano.srv;

public class SrvAplDefinirEquipeProxy implements ode._controleRecursoHumano.srv.SrvAplDefinirEquipe {
  private String _endpoint = null;
  private ode._controleRecursoHumano.srv.SrvAplDefinirEquipe srvAplDefinirEquipe = null;
  
  public SrvAplDefinirEquipeProxy() {
    _initSrvAplDefinirEquipeProxy();
  }
  
  public SrvAplDefinirEquipeProxy(String endpoint) {
    _endpoint = endpoint;
    _initSrvAplDefinirEquipeProxy();
  }
  
  private void _initSrvAplDefinirEquipeProxy() {
    try {
      srvAplDefinirEquipe = (new ode._controleRecursoHumano.srv.SrvAplDefinirEquipeImplServiceLocator()).getSrvAplDefinirEquipeImplPort();
      if (srvAplDefinirEquipe != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)srvAplDefinirEquipe)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)srvAplDefinirEquipe)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (srvAplDefinirEquipe != null)
      ((javax.xml.rpc.Stub)srvAplDefinirEquipe)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ode._controleRecursoHumano.srv.SrvAplDefinirEquipe getSrvAplDefinirEquipe() {
    if (srvAplDefinirEquipe == null)
      _initSrvAplDefinirEquipeProxy();
    return srvAplDefinirEquipe;
  }
  
  public ode._controleRecursoHumano.srv.Equipe obterEquipePorProjeto(long id) throws java.rmi.RemoteException{
    if (srvAplDefinirEquipe == null)
      _initSrvAplDefinirEquipeProxy();
    return srvAplDefinirEquipe.obterEquipePorProjeto(id);
  }
  
  public void definirEquipe(ode._controleRecursoHumano.srv.RecursoHumano[] arg0, ode._controleRecursoHumano.srv.Projeto arg1) throws java.rmi.RemoteException{
    if (srvAplDefinirEquipe == null)
      _initSrvAplDefinirEquipeProxy();
    srvAplDefinirEquipe.definirEquipe(arg0, arg1);
  }
  
  public ode._controleRecursoHumano.srv.Equipe[] recuperarTodos() throws java.rmi.RemoteException{
    if (srvAplDefinirEquipe == null)
      _initSrvAplDefinirEquipeProxy();
    return srvAplDefinirEquipe.recuperarTodos();
  }
  
  public void atualizar(ode._controleRecursoHumano.srv.Equipe arg0) throws java.rmi.RemoteException{
    if (srvAplDefinirEquipe == null)
      _initSrvAplDefinirEquipeProxy();
    srvAplDefinirEquipe.atualizar(arg0);
  }
  
  
}
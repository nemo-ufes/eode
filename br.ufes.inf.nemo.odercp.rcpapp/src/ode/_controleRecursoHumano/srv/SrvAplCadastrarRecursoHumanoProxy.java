package ode._controleRecursoHumano.srv;

public class SrvAplCadastrarRecursoHumanoProxy implements ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumano {
  private String _endpoint = null;
  private ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumano srvAplCadastrarRecursoHumano = null;
  
  public SrvAplCadastrarRecursoHumanoProxy() {
    _initSrvAplCadastrarRecursoHumanoProxy();
  }
  
  public SrvAplCadastrarRecursoHumanoProxy(String endpoint) {
    _endpoint = endpoint;
    _initSrvAplCadastrarRecursoHumanoProxy();
  }
  
  private void _initSrvAplCadastrarRecursoHumanoProxy() {
    try {
      srvAplCadastrarRecursoHumano = (new ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumanoImplServiceLocator()).getSrvAplCadastrarRecursoHumanoImplPort();
      if (srvAplCadastrarRecursoHumano != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)srvAplCadastrarRecursoHumano)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)srvAplCadastrarRecursoHumano)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (srvAplCadastrarRecursoHumano != null)
      ((javax.xml.rpc.Stub)srvAplCadastrarRecursoHumano)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ode._controleRecursoHumano.srv.SrvAplCadastrarRecursoHumano getSrvAplCadastrarRecursoHumano() {
    if (srvAplCadastrarRecursoHumano == null)
      _initSrvAplCadastrarRecursoHumanoProxy();
    return srvAplCadastrarRecursoHumano;
  }
  
  public ode._controleRecursoHumano.srv.RecursoHumano recuperarPorId(long id) throws java.rmi.RemoteException{
    if (srvAplCadastrarRecursoHumano == null)
      _initSrvAplCadastrarRecursoHumanoProxy();
    return srvAplCadastrarRecursoHumano.recuperarPorId(id);
  }
  
  public int recuperarQuantidadeTotal() throws java.rmi.RemoteException{
    if (srvAplCadastrarRecursoHumano == null)
      _initSrvAplCadastrarRecursoHumanoProxy();
    return srvAplCadastrarRecursoHumano.recuperarQuantidadeTotal();
  }
  
  public void excluir(ode._controleRecursoHumano.srv.RecursoHumano arg0) throws java.rmi.RemoteException{
    if (srvAplCadastrarRecursoHumano == null)
      _initSrvAplCadastrarRecursoHumanoProxy();
    srvAplCadastrarRecursoHumano.excluir(arg0);
  }
  
  public ode._controleRecursoHumano.srv.RecursoHumano[] recuperarTodos() throws java.rmi.RemoteException{
    if (srvAplCadastrarRecursoHumano == null)
      _initSrvAplCadastrarRecursoHumanoProxy();
    return srvAplCadastrarRecursoHumano.recuperarTodos();
  }
  
  public ode._controleRecursoHumano.srv.RecursoHumano[] recuperarRecursosHumanosAtivos() throws java.rmi.RemoteException{
    if (srvAplCadastrarRecursoHumano == null)
      _initSrvAplCadastrarRecursoHumanoProxy();
    return srvAplCadastrarRecursoHumano.recuperarRecursosHumanosAtivos();
  }
  
  public ode._controleRecursoHumano.srv.RecursoHumano[] recuperarPorCargo(ode._controleRecursoHumano.srv.KRecursoHumano kRH) throws java.rmi.RemoteException{
    if (srvAplCadastrarRecursoHumano == null)
      _initSrvAplCadastrarRecursoHumanoProxy();
    return srvAplCadastrarRecursoHumano.recuperarPorCargo(kRH);
  }
  
  public void salvar(ode._controleRecursoHumano.srv.RecursoHumano arg0) throws java.rmi.RemoteException{
    if (srvAplCadastrarRecursoHumano == null)
      _initSrvAplCadastrarRecursoHumanoProxy();
    srvAplCadastrarRecursoHumano.salvar(arg0);
  }
  
  
}
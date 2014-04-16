package ode.controleProjeto.srv;

public class SrvAplCadastrarProjetoProxy implements ode.controleProjeto.srv.SrvAplCadastrarProjeto {
  private String _endpoint = null;
  private ode.controleProjeto.srv.SrvAplCadastrarProjeto srvAplCadastrarProjeto = null;
  
  public SrvAplCadastrarProjetoProxy() {
    _initSrvAplCadastrarProjetoProxy();
  }
  
  public SrvAplCadastrarProjetoProxy(String endpoint) {
    _endpoint = endpoint;
    _initSrvAplCadastrarProjetoProxy();
  }
  
  private void _initSrvAplCadastrarProjetoProxy() {
    try {
      srvAplCadastrarProjeto = (new ode.controleProjeto.srv.SrvAplCadastrarProjetoImplServiceLocator()).getSrvAplCadastrarProjetoImplPort();
      if (srvAplCadastrarProjeto != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)srvAplCadastrarProjeto)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)srvAplCadastrarProjeto)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (srvAplCadastrarProjeto != null)
      ((javax.xml.rpc.Stub)srvAplCadastrarProjeto)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ode.controleProjeto.srv.SrvAplCadastrarProjeto getSrvAplCadastrarProjeto() {
    if (srvAplCadastrarProjeto == null)
      _initSrvAplCadastrarProjetoProxy();
    return srvAplCadastrarProjeto;
  }
  
  public void excluir(ode.controleProjeto.srv.Projeto arg0) throws java.rmi.RemoteException{
    if (srvAplCadastrarProjeto == null)
      _initSrvAplCadastrarProjetoProxy();
    srvAplCadastrarProjeto.excluir(arg0);
  }
  
  public int recuperarQuantidadeTotal() throws java.rmi.RemoteException{
    if (srvAplCadastrarProjeto == null)
      _initSrvAplCadastrarProjetoProxy();
    return srvAplCadastrarProjeto.recuperarQuantidadeTotal();
  }
  
  public int salvar(ode.controleProjeto.srv.Projeto arg0) throws java.rmi.RemoteException{
    if (srvAplCadastrarProjeto == null)
      _initSrvAplCadastrarProjetoProxy();
    return srvAplCadastrarProjeto.salvar(arg0);
  }
  
  public ode.controleProjeto.srv.Projeto recuperarPorId(long id) throws java.rmi.RemoteException{
    if (srvAplCadastrarProjeto == null)
      _initSrvAplCadastrarProjetoProxy();
    return srvAplCadastrarProjeto.recuperarPorId(id);
  }
  
  public ode.controleProjeto.srv.Projeto[] recuperarTodos() throws java.rmi.RemoteException{
    if (srvAplCadastrarProjeto == null)
      _initSrvAplCadastrarProjetoProxy();
    return srvAplCadastrarProjeto.recuperarTodos();
  }
  
  
}
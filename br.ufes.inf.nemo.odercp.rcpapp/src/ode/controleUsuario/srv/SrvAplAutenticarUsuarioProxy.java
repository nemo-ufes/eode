package ode.controleUsuario.srv;

public class SrvAplAutenticarUsuarioProxy implements ode.controleUsuario.srv.SrvAplAutenticarUsuario {
  private String _endpoint = null;
  private ode.controleUsuario.srv.SrvAplAutenticarUsuario srvAplAutenticarUsuario = null;
  
  public SrvAplAutenticarUsuarioProxy() {
    _initSrvAplAutenticarUsuarioProxy();
  }
  
  public SrvAplAutenticarUsuarioProxy(String endpoint) {
    _endpoint = endpoint;
    _initSrvAplAutenticarUsuarioProxy();
  }
  
  private void _initSrvAplAutenticarUsuarioProxy() {
    try {
      srvAplAutenticarUsuario = (new ode.controleUsuario.srv.SrvAplAutenticarUsuarioImplServiceLocator()).getSrvAplAutenticarUsuarioImplPort();
      if (srvAplAutenticarUsuario != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)srvAplAutenticarUsuario)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)srvAplAutenticarUsuario)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (srvAplAutenticarUsuario != null)
      ((javax.xml.rpc.Stub)srvAplAutenticarUsuario)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ode.controleUsuario.srv.SrvAplAutenticarUsuario getSrvAplAutenticarUsuario() {
    if (srvAplAutenticarUsuario == null)
      _initSrvAplAutenticarUsuarioProxy();
    return srvAplAutenticarUsuario;
  }
  
  public java.lang.Long efetuarLogin(java.lang.String user, java.lang.String senha, boolean remember) throws java.rmi.RemoteException, ode.controleUsuario.srv.NucleoRegraNegocioExcecao{
    if (srvAplAutenticarUsuario == null)
      _initSrvAplAutenticarUsuarioProxy();
    return srvAplAutenticarUsuario.efetuarLogin(user, senha, remember);
  }
  
  
}
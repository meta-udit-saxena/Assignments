package webservice;

public class FahrenheitToCelsiusProxy implements webservice.FahrenheitToCelsius {
  private String _endpoint = null;
  private webservice.FahrenheitToCelsius fahrenheitToCelsius = null;
  
  public FahrenheitToCelsiusProxy() {
    _initFahrenheitToCelsiusProxy();
  }
  
  public FahrenheitToCelsiusProxy(String endpoint) {
    _endpoint = endpoint;
    _initFahrenheitToCelsiusProxy();
  }
  
  private void _initFahrenheitToCelsiusProxy() {
    try {
      fahrenheitToCelsius = (new webservice.FahrenheitToCelsiusServiceLocator()).getFahrenheitToCelsius();
      if (fahrenheitToCelsius != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)fahrenheitToCelsius)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)fahrenheitToCelsius)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (fahrenheitToCelsius != null)
      ((javax.xml.rpc.Stub)fahrenheitToCelsius)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservice.FahrenheitToCelsius getFahrenheitToCelsius() {
    if (fahrenheitToCelsius == null)
      _initFahrenheitToCelsiusProxy();
    return fahrenheitToCelsius;
  }
  
  public double convertFahrenheitToCelsius(double temperature) throws java.rmi.RemoteException{
    if (fahrenheitToCelsius == null)
      _initFahrenheitToCelsiusProxy();
    return fahrenheitToCelsius.convertFahrenheitToCelsius(temperature);
  }
  
  
}
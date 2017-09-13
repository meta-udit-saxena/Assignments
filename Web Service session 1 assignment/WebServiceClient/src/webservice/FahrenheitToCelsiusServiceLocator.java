/**
 * FahrenheitToCelsiusServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservice;

public class FahrenheitToCelsiusServiceLocator extends org.apache.axis.client.Service implements webservice.FahrenheitToCelsiusService {

    public FahrenheitToCelsiusServiceLocator() {
    }


    public FahrenheitToCelsiusServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FahrenheitToCelsiusServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FahrenheitToCelsius
    private java.lang.String FahrenheitToCelsius_address = "http://localhost:8080/Web_Service_Assignment_1/services/FahrenheitToCelsius";

    public java.lang.String getFahrenheitToCelsiusAddress() {
        return FahrenheitToCelsius_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FahrenheitToCelsiusWSDDServiceName = "FahrenheitToCelsius";

    public java.lang.String getFahrenheitToCelsiusWSDDServiceName() {
        return FahrenheitToCelsiusWSDDServiceName;
    }

    public void setFahrenheitToCelsiusWSDDServiceName(java.lang.String name) {
        FahrenheitToCelsiusWSDDServiceName = name;
    }

    public webservice.FahrenheitToCelsius getFahrenheitToCelsius() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FahrenheitToCelsius_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFahrenheitToCelsius(endpoint);
    }

    public webservice.FahrenheitToCelsius getFahrenheitToCelsius(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            webservice.FahrenheitToCelsiusSoapBindingStub _stub = new webservice.FahrenheitToCelsiusSoapBindingStub(portAddress, this);
            _stub.setPortName(getFahrenheitToCelsiusWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFahrenheitToCelsiusEndpointAddress(java.lang.String address) {
        FahrenheitToCelsius_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (webservice.FahrenheitToCelsius.class.isAssignableFrom(serviceEndpointInterface)) {
                webservice.FahrenheitToCelsiusSoapBindingStub _stub = new webservice.FahrenheitToCelsiusSoapBindingStub(new java.net.URL(FahrenheitToCelsius_address), this);
                _stub.setPortName(getFahrenheitToCelsiusWSDDServiceName());
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
        if ("FahrenheitToCelsius".equals(inputPortName)) {
            return getFahrenheitToCelsius();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice", "FahrenheitToCelsiusService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice", "FahrenheitToCelsius"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FahrenheitToCelsius".equals(portName)) {
            setFahrenheitToCelsiusEndpointAddress(address);
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


package bos.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CustomerService", targetNamespace = "http://service.bos/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CustomerService {


    /**
     * 
     * @param arg0
     * @return
     *     returns bos.service.Customer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findCustomerByTelephone", targetNamespace = "http://service.bos/", className = "bos.service.FindCustomerByTelephone")
    @ResponseWrapper(localName = "findCustomerByTelephoneResponse", targetNamespace = "http://service.bos/", className = "bos.service.FindCustomerByTelephoneResponse")
    public Customer findCustomerByTelephone(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<bos.service.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "noAssociateCustomer", targetNamespace = "http://service.bos/", className = "bos.service.NoAssociateCustomer")
    @ResponseWrapper(localName = "noAssociateCustomerResponse", targetNamespace = "http://service.bos/", className = "bos.service.NoAssociateCustomerResponse")
    public List<Customer> noAssociateCustomer();

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "associateCustomer", targetNamespace = "http://service.bos/", className = "bos.service.AssociateCustomer")
    @ResponseWrapper(localName = "associateCustomerResponse", targetNamespace = "http://service.bos/", className = "bos.service.AssociateCustomerResponse")
    public void associateCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Integer> arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @return
     *     returns java.util.List<bos.service.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://service.bos/", className = "bos.service.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://service.bos/", className = "bos.service.FindAllResponse")
    public List<Customer> findAll();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<bos.service.Customer>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hasAssociateCustomer", targetNamespace = "http://service.bos/", className = "bos.service.HasAssociateCustomer")
    @ResponseWrapper(localName = "hasAssociateCustomerResponse", targetNamespace = "http://service.bos/", className = "bos.service.HasAssociateCustomerResponse")
    public List<Customer> hasAssociateCustomer(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findCustomerIdByAddress", targetNamespace = "http://service.bos/", className = "bos.service.FindCustomerIdByAddress")
    @ResponseWrapper(localName = "findCustomerIdByAddressResponse", targetNamespace = "http://service.bos/", className = "bos.service.FindCustomerIdByAddressResponse")
    public String findCustomerIdByAddress(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
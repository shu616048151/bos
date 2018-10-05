
package bos.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bos.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindCustomerByTelephone_QNAME = new QName("http://service.bos/", "findCustomerByTelephone");
    private final static QName _AssociateCustomer_QNAME = new QName("http://service.bos/", "associateCustomer");
    private final static QName _FindCustomerIdByAddress_QNAME = new QName("http://service.bos/", "findCustomerIdByAddress");
    private final static QName _NoAssociateCustomer_QNAME = new QName("http://service.bos/", "noAssociateCustomer");
    private final static QName _HasAssociateCustomer_QNAME = new QName("http://service.bos/", "hasAssociateCustomer");
    private final static QName _NoAssociateCustomerResponse_QNAME = new QName("http://service.bos/", "noAssociateCustomerResponse");
    private final static QName _HasAssociateCustomerResponse_QNAME = new QName("http://service.bos/", "hasAssociateCustomerResponse");
    private final static QName _FindAllResponse_QNAME = new QName("http://service.bos/", "findAllResponse");
    private final static QName _FindCustomerIdByAddressResponse_QNAME = new QName("http://service.bos/", "findCustomerIdByAddressResponse");
    private final static QName _AssociateCustomerResponse_QNAME = new QName("http://service.bos/", "associateCustomerResponse");
    private final static QName _FindCustomerByTelephoneResponse_QNAME = new QName("http://service.bos/", "findCustomerByTelephoneResponse");
    private final static QName _FindAll_QNAME = new QName("http://service.bos/", "findAll");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bos.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AssociateCustomerResponse }
     * 
     */
    public AssociateCustomerResponse createAssociateCustomerResponse() {
        return new AssociateCustomerResponse();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link FindCustomerByTelephoneResponse }
     * 
     */
    public FindCustomerByTelephoneResponse createFindCustomerByTelephoneResponse() {
        return new FindCustomerByTelephoneResponse();
    }

    /**
     * Create an instance of {@link AssociateCustomer }
     * 
     */
    public AssociateCustomer createAssociateCustomer() {
        return new AssociateCustomer();
    }

    /**
     * Create an instance of {@link FindCustomerByTelephone }
     * 
     */
    public FindCustomerByTelephone createFindCustomerByTelephone() {
        return new FindCustomerByTelephone();
    }

    /**
     * Create an instance of {@link FindCustomerIdByAddress }
     * 
     */
    public FindCustomerIdByAddress createFindCustomerIdByAddress() {
        return new FindCustomerIdByAddress();
    }

    /**
     * Create an instance of {@link HasAssociateCustomer }
     * 
     */
    public HasAssociateCustomer createHasAssociateCustomer() {
        return new HasAssociateCustomer();
    }

    /**
     * Create an instance of {@link NoAssociateCustomer }
     * 
     */
    public NoAssociateCustomer createNoAssociateCustomer() {
        return new NoAssociateCustomer();
    }

    /**
     * Create an instance of {@link HasAssociateCustomerResponse }
     * 
     */
    public HasAssociateCustomerResponse createHasAssociateCustomerResponse() {
        return new HasAssociateCustomerResponse();
    }

    /**
     * Create an instance of {@link NoAssociateCustomerResponse }
     * 
     */
    public NoAssociateCustomerResponse createNoAssociateCustomerResponse() {
        return new NoAssociateCustomerResponse();
    }

    /**
     * Create an instance of {@link FindCustomerIdByAddressResponse }
     * 
     */
    public FindCustomerIdByAddressResponse createFindCustomerIdByAddressResponse() {
        return new FindCustomerIdByAddressResponse();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerByTelephone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "findCustomerByTelephone")
    public JAXBElement<FindCustomerByTelephone> createFindCustomerByTelephone(FindCustomerByTelephone value) {
        return new JAXBElement<FindCustomerByTelephone>(_FindCustomerByTelephone_QNAME, FindCustomerByTelephone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociateCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "associateCustomer")
    public JAXBElement<AssociateCustomer> createAssociateCustomer(AssociateCustomer value) {
        return new JAXBElement<AssociateCustomer>(_AssociateCustomer_QNAME, AssociateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerIdByAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "findCustomerIdByAddress")
    public JAXBElement<FindCustomerIdByAddress> createFindCustomerIdByAddress(FindCustomerIdByAddress value) {
        return new JAXBElement<FindCustomerIdByAddress>(_FindCustomerIdByAddress_QNAME, FindCustomerIdByAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoAssociateCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "noAssociateCustomer")
    public JAXBElement<NoAssociateCustomer> createNoAssociateCustomer(NoAssociateCustomer value) {
        return new JAXBElement<NoAssociateCustomer>(_NoAssociateCustomer_QNAME, NoAssociateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasAssociateCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "hasAssociateCustomer")
    public JAXBElement<HasAssociateCustomer> createHasAssociateCustomer(HasAssociateCustomer value) {
        return new JAXBElement<HasAssociateCustomer>(_HasAssociateCustomer_QNAME, HasAssociateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoAssociateCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "noAssociateCustomerResponse")
    public JAXBElement<NoAssociateCustomerResponse> createNoAssociateCustomerResponse(NoAssociateCustomerResponse value) {
        return new JAXBElement<NoAssociateCustomerResponse>(_NoAssociateCustomerResponse_QNAME, NoAssociateCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HasAssociateCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "hasAssociateCustomerResponse")
    public JAXBElement<HasAssociateCustomerResponse> createHasAssociateCustomerResponse(HasAssociateCustomerResponse value) {
        return new JAXBElement<HasAssociateCustomerResponse>(_HasAssociateCustomerResponse_QNAME, HasAssociateCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerIdByAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "findCustomerIdByAddressResponse")
    public JAXBElement<FindCustomerIdByAddressResponse> createFindCustomerIdByAddressResponse(FindCustomerIdByAddressResponse value) {
        return new JAXBElement<FindCustomerIdByAddressResponse>(_FindCustomerIdByAddressResponse_QNAME, FindCustomerIdByAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociateCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "associateCustomerResponse")
    public JAXBElement<AssociateCustomerResponse> createAssociateCustomerResponse(AssociateCustomerResponse value) {
        return new JAXBElement<AssociateCustomerResponse>(_AssociateCustomerResponse_QNAME, AssociateCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerByTelephoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "findCustomerByTelephoneResponse")
    public JAXBElement<FindCustomerByTelephoneResponse> createFindCustomerByTelephoneResponse(FindCustomerByTelephoneResponse value) {
        return new JAXBElement<FindCustomerByTelephoneResponse>(_FindCustomerByTelephoneResponse_QNAME, FindCustomerByTelephoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.bos/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

}

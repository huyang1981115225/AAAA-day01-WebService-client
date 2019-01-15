
package cn.tedu.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.tedu.ws package. 
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

    private final static QName _IntroduceResponse_QNAME = new QName("http://ws.tedu.cn/", "introduceResponse");
    private final static QName _SayHelloResponse_QNAME = new QName("http://ws.tedu.cn/", "sayHelloResponse");
    private final static QName _SayHello_QNAME = new QName("http://ws.tedu.cn/", "sayHello");
    private final static QName _Introduce_QNAME = new QName("http://ws.tedu.cn/", "introduce");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.tedu.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link Introduce }
     * 
     */
    public Introduce createIntroduce() {
        return new Introduce();
    }

    /**
     * Create an instance of {@link IntroduceResponse }
     * 
     */
    public IntroduceResponse createIntroduceResponse() {
        return new IntroduceResponse();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntroduceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tedu.cn/", name = "introduceResponse")
    public JAXBElement<IntroduceResponse> createIntroduceResponse(IntroduceResponse value) {
        return new JAXBElement<IntroduceResponse>(_IntroduceResponse_QNAME, IntroduceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tedu.cn/", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tedu.cn/", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Introduce }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.tedu.cn/", name = "introduce")
    public JAXBElement<Introduce> createIntroduce(Introduce value) {
        return new JAXBElement<Introduce>(_Introduce_QNAME, Introduce.class, null, value);
    }

}

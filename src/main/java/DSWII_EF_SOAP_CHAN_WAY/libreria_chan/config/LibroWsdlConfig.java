package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class LibroWsdlConfig {
    @Bean(name = "libros")
    public DefaultWsdl11Definition librosWsdl11Definition(XsdSchema libroScheme) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("LibrosPort");
        wsdl11Definition.setLocationUri("/ws/libros");
        wsdl11Definition.setTargetNamespace("http://www.libreriaChanWay.com.pe/ws/objects");
        wsdl11Definition.setSchema(libroScheme);

        return wsdl11Definition;
    }
    @Bean
    public XsdSchema libroSheme() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/libros.xsd"));
    }
}

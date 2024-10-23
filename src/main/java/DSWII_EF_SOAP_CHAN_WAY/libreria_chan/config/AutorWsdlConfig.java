package DSWII_EF_SOAP_CHAN_WAY.libreria_chan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class AutorWsdlConfig {
    @Bean(name = "autor")
    public DefaultWsdl11Definition librosWsdl11Definition(XsdSchema autorScheme) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("AutorPort");
        wsdl11Definition.setLocationUri("/ws/autor");
        wsdl11Definition.setTargetNamespace("http://www.libreriaChanWay.com.pe/ws/objects");
        wsdl11Definition.setSchema(autorScheme);

        return wsdl11Definition;
    }
    @Bean
    public XsdSchema autorSheme() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/autor.xsd"));
    }
}

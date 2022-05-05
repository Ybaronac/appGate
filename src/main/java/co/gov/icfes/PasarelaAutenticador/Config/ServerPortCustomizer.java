package co.gov.icfes.PasarelaAutenticador.Config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class ServerPortCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    /**
     * Método para cambiar el puerto en el que se despliega el servidor
     */
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(8090);
    }

}

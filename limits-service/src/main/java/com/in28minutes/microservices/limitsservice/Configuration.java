package com.in28minutes.microservices.limitsservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
/**
 * Anotação utilizada para buscar valores informados no bootstrap.properties.
 * Utilizando o prefix "limits-service" irá ser buscado todos os valores informados com este
 * prefixo na frente, os valores serão mapeados para as propriedades informadas na classe com os
 * respectivos nomes.
 */
@ConfigurationProperties(prefix = "limits-service")
public class Configuration {

    private int minimum;

    private int maximum;

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}

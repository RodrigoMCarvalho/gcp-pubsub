package com.rodrigo.pubsub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.support.converter.JacksonPubSubMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class PubsubPublisher {

    private final PubSubTemplate pubSubTemplate;

    public PubsubPublisher(PubSubTemplate pubSubTemplate) {
        this.pubSubTemplate = pubSubTemplate;
    }

    @Autowired
    private JacksonPubSubMessageConverter jacksonPubSubMessageConverter;

    public void publishMessage(String mensagem) {
        this.pubSubTemplate.publish("my-topico-teste", mensagem);
        System.out.println("Mensagem publicada!!! ");
    }

    public void publishMessageObject(Object mensagem) {
        this.pubSubTemplate.setMessageConverter(jacksonPubSubMessageConverter);
        this.pubSubTemplate.publish("my-topico-teste", mensagem);
        System.out.println("Mensagem publicada!!! ");
    }
}

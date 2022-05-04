package com.lightsoft.bestpractices.ws;


import jakarta.websocket.server.ServerEndpointConfig.Configurator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ASRWebSocketServerConfiguration extends Configurator {
    public void initialize() {

    }
}

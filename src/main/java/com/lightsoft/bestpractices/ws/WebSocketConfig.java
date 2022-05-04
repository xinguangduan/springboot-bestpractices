package com.lightsoft.bestpractices.ws;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.CloseStatus;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(new TextWsHandler(), "/ws");
    }

    class TextWsHandler extends TextWebSocketHandler {
        private List<WebSocketSession> sessions = new java.util.concurrent.CopyOnWriteArrayList<>();

        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            super.afterConnectionEstablished(session);
            sessions.add(session);
        }

        @Override
        public void handleMessage(
                WebSocketSession session, WebSocketMessage<?> message) {
//            super.handleMessage(session, message);
//            sessions.add(session);
        }

        @Override
        public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
//            super.afterConnectionClosed(session, status);
            sessions.remove(session);
        }
    }
}

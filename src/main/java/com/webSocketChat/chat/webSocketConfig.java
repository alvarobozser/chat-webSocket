package com.webSocketChat.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class webSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// Endpoint de entrada al chat
		registry.addEndpoint("/chat-webSocket")
		// Permite las solicitudes desde el origen http://localhost:4200 (CORS)
		.setAllowedOrigins("http://localhost:4200")
		// Habilita el soporte de SockJS para el endpoint
		.withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// Habilita un broker de mensajes simple para enviar mensajes a clientes suscritos a destinos específicos	  
		registry.enableSimpleBroker("/chat/");
		// Establece el prefijo para los destinos de la aplicación a "/app"
		registry.setApplicationDestinationPrefixes("/app");
	}	
}
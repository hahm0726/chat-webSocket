package com.chat.chatex.config;


import com.chat.chatex.handler.ChatHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@RequiredArgsConstructor
@EnableWebSocket //websocket 활성화
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatHandler chatHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        // websocket 접속을 위한 Endpoint는 /chat
        // 도메인이 다른 서버에서도 접속 가능하도록 CORS : setAllowedOrigins("*")를 추가
        // 이로서 ws://localhost:8080/chat 으로 커넥션 연결 가능
        registry.addHandler(chatHandler, "/ws/chat").setAllowedOrigins("*");
    }
}

package com.chat.chatex.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class ChatHandler extends TextWebSocketHandler {

    private static List<WebSocketSession> list = new ArrayList<>();


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload => " + payload);

        for (WebSocketSession sess: list){
            sess.sendMessage(message);
        }
    }

    // client가 접속 연결 시 호출되는 메소드
    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        list.add(session);
        log.info(session + " 클라이언트 접속");

    }

    // client가 접속 해제 시 호출되는 메소드
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {

        list.remove(session);
        log.info(session + " 클라이언트 접속 해제");
    }


}

package ifsc.edu.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class WsHandler extends TextWebSocketHandler {
    record Dado(int id, String conteudo) {}
    final ObjectMapper mapper = new ObjectMapper();

    private ConcurrentHashMap<String, WebSocketSession> conections = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        super.afterConnectionEstablished(session);
        conections.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        super.afterConnectionClosed(session, status);
        conections.remove(session.getId(), session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        var addr = session.getRemoteAddress();

        String usuario = addr.toString();
        TextMessage msg = new TextMessage(usuario + ": " + message.getPayload());

        for(var cliente : conections.values()) {
            if (!cliente.equals(session)) cliente.sendMessage(msg);
        }
    }
}
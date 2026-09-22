package ifsc.edu.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WsHandler extends TextWebSocketHandler {
    record Dado(int id, String conteudo) {}
    final ObjectMapper mapper = new ObjectMapper();

    private List<WebSocketSession> conections = new ArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        Thread.ofVirtual().start(() -> {
            try {
                for (int j = 0; j < 2; j++) {
                    // cria um objeto Dado
                    Dado dado = new Dado(j, message.getPayload());

                    // converte o objeto Dado para JSON
                    String conteudo = mapper.writeValueAsString(dado);

                    // encapsula a string JSON em uma mensagem a ser enviada para o cliente
                    TextMessage msg = new TextMessage(conteudo);
                    session.sendMessage(msg);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                return;
            }
        });
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        super.afterConnectionEstablished(session);
        conections.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
        super.afterConnectionClosed(session, status);
        conections.remove(session);
    }
}
package wildflyswarm.websocket;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author Yoshimasa Tanabe
 */
@ServerEndpoint("/myapp")
public class ChatWebSocketEndpoint {

  @OnMessage
  public void message(String message, Session session) {
    session.getOpenSessions()
      .forEach(s -> s.getAsyncRemote().sendText(message));
  }

}

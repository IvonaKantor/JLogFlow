package org.jlog.flow.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.websocket.server.PathParam;

@ApplicationScoped
@ServerEndpoint("/api/logs/{logId}")
public class WebSocket {

    @OnOpen
    public void onOpen(Session session, @PathParam("logId") String logId) {
        System.out.println("onOpen> " + logId);
    }

    @OnClose
    public void onClose(Session session,  @PathParam("logId") String logId) {
        System.out.println("onClose> " + logId);
    }

    @OnError
    public void onError(Session session,  @PathParam("logId") String logId, Throwable throwable) {
        System.out.println("onError> " + logId + " " + throwable);
    }

    @OnMessage
    public void onMessage(Session session, @PathParam("logId") String logId, String message) {
        System.out.println("onMessage> " + logId + " " + message);
    }
}

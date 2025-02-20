package org.graduate.example.config;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;
public class GetHttpSessionConfig extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig serverEndpointConfig, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();

        // 将 httpSession 对象存到 ServerEndpointConfig 对象中
        serverEndpointConfig.getUserProperties().put(HttpSession.class.getName(), httpSession);
    }

}

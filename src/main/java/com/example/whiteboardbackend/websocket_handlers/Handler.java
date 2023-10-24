package com.example.whiteboardbackend.websocket_handlers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class Handler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Format the date as a string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        // Create a response message
        String response = "Received on " + formattedDate + ": " + payload;

        session.sendMessage(new TextMessage(response));
    }

}

package com.logging.platform;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Writer {

    @Outgoing("out")
    Emitter<Record<String, Message>> emitter;

    public void writeLog(Message message){

    }
}

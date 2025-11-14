package com.logging.platform;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;

@ApplicationScoped
public class Writer {

    @Channel("out")
    Emitter<Record<String, Message>> emitter;

    public void writeLog(Message message){

    }
}

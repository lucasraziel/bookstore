package com.bookstore.application.shared;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

record EventRegistered(String eventId, List<Handler> handlers) {
}

public class EventEmitter {
    private Map<String, List<Handler>> eventsRegistered;

    public EventEmitter() {
        this.eventsRegistered = new HashMap<>();
    }

    public void register(String eventId, List<Handler> handlers) {

        this.eventsRegistered.put(eventId, handlers);
    }

    public void emit(Event<?> event) {
        List<Handler> handlers = this.eventsRegistered.get(event.getEventId());
        handlers.forEach(handler -> handler.handle(event));
    }
}

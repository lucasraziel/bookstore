package com.bookstore.domains;

import java.util.ArrayList;
import java.util.List;

record EventRegistered(String eventId, List<Handler> handlers) {
}

public class EventEmitter {
    private List<EventRegistered> eventsRegistered;

    public EventEmitter() {
        this.eventsRegistered = new ArrayList<>();
    }

    public void register(String eventId, List<Handler> handlers) {
        this.eventsRegistered.add(new EventRegistered(eventId, handlers));
    }

    public void emit(Event<?> event) {
        for (EventRegistered eventRegistered : this.eventsRegistered) {
            if (eventRegistered.eventId().equals(event.eventId)) {
                eventRegistered.handlers().forEach(handler -> handler.handle(event));
                break;
            }
        }
    }
}

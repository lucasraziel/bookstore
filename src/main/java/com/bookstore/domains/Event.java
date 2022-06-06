package com.bookstore.domains;

import java.util.Date;

public abstract class Event<T extends DataEvent> {
    public String eventId;

    public Date eventDate;

    public T eventData;

}

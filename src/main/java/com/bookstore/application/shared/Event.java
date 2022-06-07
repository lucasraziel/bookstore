package com.bookstore.application.shared;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Event<T extends DataEvent> {
    String eventId;

    Date eventDate;

    T eventData;

}

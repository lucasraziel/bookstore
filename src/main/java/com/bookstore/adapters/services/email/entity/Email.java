package com.bookstore.adapters.services.email.entity;

import java.util.List;

public record Email(String to, String from, String message, String subject, List<String> atachments) {

}

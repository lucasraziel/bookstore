package com.bookstore.adapters.services.email.entity;

public record Email(String to, String from, String message, String subject, String[] atachments) {

}

package com.bookstore.domains.book;

public record Book(String title, String author, String isbn, Integer price, String id) {

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return id.equals(book.id) && this.isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + isbn.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title +
                '\'' + ", author='" + author + '\'' + ", isbn='"
                + isbn + '\'' + ", price="
                + price + ", id='" + id + '\'' + '}';
    }
}

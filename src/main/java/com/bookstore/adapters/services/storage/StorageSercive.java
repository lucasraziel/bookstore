package com.bookstore.adapters.services.storage;

public interface StorageSercive {

    public void save(String fileName, byte[] data);

    public byte[] load(String fileName);

    public void delete(String fileName);

}

package com.bookstore.infrastructure.storage;

import org.springframework.stereotype.Service;

import com.bookstore.adapters.services.storage.IStorageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StorageService implements IStorageService {
    @Override
    public void save(String fileName, byte[] data) {
        log.info("Saving file: {}", fileName);

    }

    @Override
    public byte[] load(String fileName) {
        log.info("Loading file: {}", fileName);
        return new byte[0];
    }

    @Override
    public void delete(String fileName) {
        log.info("Deleting file: {}", fileName);

    }

}

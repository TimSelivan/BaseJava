package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;


public interface Storage {

    void clear();

    void update(Resume resume);

    void save(Resume newResume);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    int size();
}
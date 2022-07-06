package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size = 0;
    private Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume newResume) {
        storage[size] = newResume;
        size++;
        if(size == storage.length) {
            System.out.println("Current resume base is overloaded. Please, create the new one.");
        }
    }

    public void update(Resume[] resumes) {

    }

    public Resume get(String uuid) {
        int i = 0;
        boolean contains = false;
        for(i = 0; i < size; i++) {
            if(storage[i].getUuid().equals(uuid)) {
                contains = true;
                break;
            }
        }
        if(contains) {
            return storage[i];
        } else {
            return null;
        }
    }

    public void delete(String uuid) {
        int i = 0;
        boolean contains = false;
        for(i = 0; i < size; i++) {
            if(storage[i].getUuid().equals(uuid)) {
                contains = true;
                break;
            }
        }
        if(contains) {
            storage[i] = null;
            size--;
            System.arraycopy(storage, (i + 1), storage, i, (size - i));
        } else {
            System.out.println("Resume " + uuid + " was not found");
        }
    }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] arrayCopy = Arrays.copyOf(storage, size);
        return arrayCopy;
    }

    public int size() {
        return size;
    }

    public boolean contains(String uuid) {
        int i = 0;
        boolean contains = false;
        for(i = 0; i < size; i++) {
            if(storage[i].getUuid().equals(uuid)) {
                contains = true;
                break;
            }
        }
        return contains;
    }
}

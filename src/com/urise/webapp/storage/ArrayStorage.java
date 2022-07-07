package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("Resume " + resume.getUuid() + " is not exist");
        } else {
            storage[index] = resume;
            System.out.println("Resume is updated");
        }
    }

    public void save(Resume newResume) {
        if (getIndex(newResume.getUuid()) != -1) {
            System.out.println("Resume " + newResume.getUuid() + " already exists");
        } else if (size == storage.length) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = newResume;
            size++;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume is not exist");
            return null;
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index == -1) {
            System.out.println("Resume " + uuid + " is not exist");
        } else {
            storage[index] = null;
            size--;
            System.arraycopy(storage, (index + 1), storage, index, (size - index));
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}

package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

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

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        for(int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume newResume) {
        storage[size] = newResume;
        size++;
    }

    Resume get(String uuid) {
        int i = 0;
        boolean contains = false;
        for(i = 0; i < size; i++) {
            if(storage[i].uuid.equals(uuid)) {
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

    void delete(String uuid) {
        int i = 0;
        boolean contains = false;
        for(i = 0; i < size; i++) {
            if(storage[i].uuid.equals(uuid)) {
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
    Resume[] getAll() {
        Resume[] arrayCopy = new Resume[size];
        System.arraycopy(storage, 0, arrayCopy, 0, size);
        return arrayCopy;
    }

    int size() {
        return size;
    }
}

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for(int i = 0; i < storage.length; i++) {
            if(storage[i] != null) {
                storage[i] = null;
            } else {
                break;
            }
        }
    }

    void save(Resume newResume) {
        int count = 0;
        for(int i = count; i < storage.length; i++) {
            if(storage[i] != null) {
                count++;
            } else {
                break;
            }
        }
        storage[count] = newResume;
    }

    Resume get(String uuid) {
        int count = 0;
        for (Resume resume : storage) {
            count++;
            if (resume.uuid.equals(uuid)) {
                break;
            }
        }
        return storage[count];
    }

    void delete(String uuid) {
        int i = 0;
        for(i = 0; i < storage.length; i++) {
            if(storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                break;
            }
        }
        System.arraycopy(storage, (i + 1), storage, i, (storage.length - 1 - i));
        storage[storage.length - 1] = null;
    }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int arrayCopySize = size();
        Resume[] arrayCopy = new Resume[arrayCopySize];
        System.arraycopy(storage, 0, arrayCopy, 0, arrayCopySize);
        return arrayCopy;
    }

    int size() {
        int count = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

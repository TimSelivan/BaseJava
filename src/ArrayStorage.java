/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        for(int i = 0; i <= size; i++) {
            if(storage[i] != null) {
                storage[i] = null;
                size--;
            } else {
                break;
            }
        }
    }

    void save(Resume newResume) {
        int count = 0;
        for(int i = count; i < size; i++) {
            if(storage[i] != null) {
                count++;
            } else {
                break;
            }
        }
        storage[count] = newResume;
        size += 1;
    }

    Resume get(String uuid) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                break;
            }
            count++;
        }
        return storage[count];
    }

    void delete(String uuid) {
        int i = 0;
        for(i = 0; i < size; i++) {
            if(storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                size--;
                break;
            }
        }
        System.arraycopy(storage, (i + 1), storage, i, (size - i));
        storage[size] = null;
    }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
//        int arrayCopySize = size();
        Resume[] arrayCopy = new Resume[size];
        System.arraycopy(storage, 0, arrayCopy, 0, size);
        return arrayCopy;
    }

    int size() {
        return size;
    }
}

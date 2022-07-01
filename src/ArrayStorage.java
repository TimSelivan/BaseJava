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

    void save(Resume addResume) {
        int count = 0;
        for(int i = count; i < storage.length; i++) {
            if(storage[i] != null) {
                count++;
            } else {
                break;
            }
        }
        storage[count] = addResume;
    }

    Resume get(String uuid) {
        return null;
    }

    void delete(String uuid) {
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        return new Resume[0];
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

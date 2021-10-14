package ru.netology.manager;

import ru.netology.posterItem;

public class posterManager {
    private posterItem[] items = new posterItem[0];
    private int numberOfDisplayedFilms = 10;

    public posterManager(int numberOfDisplayedFilms) {
        this.numberOfDisplayedFilms = numberOfDisplayedFilms;
    }

    public posterManager() {
    }

    public posterItem[] findLessOrEqualFixedAmount() {
        int resultLength;
        if (items.length < numberOfDisplayedFilms) {
            resultLength = items.length;
        } else {
            resultLength = numberOfDisplayedFilms;
        }
        posterItem[] result = new posterItem[resultLength];
        for (int i = items.length - resultLength; i < items.length; i++) {
            int index = items.length - i + (items.length - resultLength - 1);
            result[i - (items.length - resultLength)] = items[index];
        }
        return result;
    }

    public void save(posterItem item) {
        int length = items.length + 1;
        posterItem[] tmp = new posterItem[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;

    }

    public posterItem[] getAll() {
        posterItem[] result = new posterItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        posterItem[] tmp2 = new posterItem[length];
        int index = 0;
        for (posterItem item : items) {
            if (item.getId() != id) {
                tmp2[index] = item;
                index++;
            }
        }
        items = tmp2;
    }

}

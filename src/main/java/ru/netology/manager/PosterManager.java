package ru.netology.manager;

import ru.netology.PosterItem;

public class PosterManager {
    private PosterItem[] items = new PosterItem[0];
    private int numberOfDisplayedFilms = 10;

    public PosterManager(int numberOfDisplayedFilms) {
        this.numberOfDisplayedFilms = numberOfDisplayedFilms;
    }

    public PosterManager() {
    }

    public PosterItem[] findLessOrEqualFixedAmount() {
        int resultLength;
        if (items.length < numberOfDisplayedFilms) {
            resultLength = items.length;
        } else {
            resultLength = numberOfDisplayedFilms;
        }
        PosterItem[] result = new PosterItem[resultLength];
        for (int i = items.length - resultLength; i < items.length; i++) {
            int index = items.length - i + (items.length - resultLength - 1);
            result[i - (items.length - resultLength)] = items[index];
        }
        return result;
    }

    public void save(PosterItem item) {
        int length = items.length + 1;
        PosterItem[] tmp = new PosterItem[length];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;

    }

    public PosterItem[] getAll() {
        PosterItem[] result = new PosterItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        PosterItem[] tmp2 = new PosterItem[length];
        int index = 0;
        for (PosterItem item : items) {
            if (item.getId() != id) {
                tmp2[index] = item;
                index++;
            }
        }
        items = tmp2;
    }
}

package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.manager.PosterManager;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerTest {
    PosterItem f1 = new PosterItem(1, "Бладшот", "боевик", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    PosterItem f2 = new PosterItem(2, "Вперед", "мульфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    PosterItem f3 = new PosterItem(3, "Отель Белград", "комедия", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    PosterItem f4 = new PosterItem(4, "Джентельмены", "боевик", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    PosterItem f5 = new PosterItem(5, "Человек-Неведимка", "ужасы", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    PosterItem f6 = new PosterItem(6, "Тролли", "мультфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", true);
    PosterItem f7 = new PosterItem(7, "Номер один", "комедия", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", true);
    PosterItem f8 = new PosterItem(8, "Шрек", "мультфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    PosterItem f9 = new PosterItem(9, "Шрек 2", "мультфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    PosterItem f10 = new PosterItem(10, "Вверх", "мультфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    PosterItem f11 = new PosterItem(11, "Кунгфу Панда", "мульфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);

    @Test
    public void shouldSaveIfNoOneFilmsExist() {
        PosterManager manager = new PosterManager();
        manager.save(f1);
        PosterItem[] expected = new PosterItem[]{f1};
        PosterItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveIfSomeFilmsExist() {
        PosterManager manager = new PosterManager();
        manager.save(f1);
        manager.save(f2);
        manager.save(f3);
        PosterItem[] expected = new PosterItem[]{f3, f2, f1};
        PosterItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveIfTheSameFilmExist() {
        PosterManager manager = new PosterManager();
        PosterItem f1 = new PosterItem(1, "Бладшот", "боевик", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
        PosterItem f2 = new PosterItem(2, "Вперед", "мульфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
        PosterItem f3 = new PosterItem(2, "Вперед", "мульфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
        manager.save(f1);
        manager.save(f2);
        manager.save(f3);
        PosterItem[] expected = new PosterItem[]{f3, f2, f1};
        PosterItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLessOrEqual10Of9() {
        PosterManager manager = new PosterManager();
        manager.save(f1);
        manager.save(f2);
        manager.save(f3);
        manager.save(f4);
        manager.save(f5);
        manager.save(f6);
        manager.save(f7);
        manager.save(f8);
        manager.save(f9);
        PosterItem[] expected = new PosterItem[]{f9, f8, f7, f6, f5, f4, f3, f2, f1};
        PosterItem[] actual = manager.findLessOrEqualFixedAmount();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLessOrEqual10IfEqual10() {
        PosterManager manager = new PosterManager();
        manager.save(f1);
        manager.save(f2);
        manager.save(f3);
        manager.save(f4);
        manager.save(f5);
        manager.save(f6);
        manager.save(f7);
        manager.save(f8);
        manager.save(f9);
        manager.save(f10);
        PosterItem[] expected = new PosterItem[]{f10, f9, f8, f7, f6, f5, f4, f3, f2, f1};
        PosterItem[] actual = manager.findLessOrEqualFixedAmount();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLessOrEqual10If11() {
        PosterManager manager = new PosterManager();
        manager.save(f1);
        manager.save(f2);
        manager.save(f3);
        manager.save(f4);
        manager.save(f5);
        manager.save(f6);
        manager.save(f7);
        manager.save(f8);
        manager.save(f9);
        manager.save(f10);
        manager.save(f11);
        PosterItem[] expected = new PosterItem[]{f11, f10, f9, f8, f7, f6, f5, f4, f3, f2};
        PosterItem[] actual = manager.findLessOrEqualFixedAmount();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLessOrEqual10IfNoOneExist() {
        PosterManager manager = new PosterManager();
        PosterItem[] expected = new PosterItem[0];
        PosterItem[] actual = manager.findLessOrEqualFixedAmount();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfManyFilmsExist() {
        PosterManager manager = new PosterManager();
        manager.save(f1);
        manager.save(f2);
        manager.save(f3);
        manager.save(f4);
        manager.save(f5);
        manager.save(f6);
        manager.save(f7);
        manager.removeById(4);
        PosterItem[] expected = new PosterItem[]{f7, f6, f5, f3, f2, f1};
        PosterItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfOneFilmExist() {
        PosterManager manager = new PosterManager();
        manager.save(f1);
        manager.removeById(1);
        PosterItem[] expected = new PosterItem[0];
        PosterItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
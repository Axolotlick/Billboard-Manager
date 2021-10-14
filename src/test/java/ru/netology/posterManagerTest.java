package ru.netology;

import org.junit.jupiter.api.Test;
import ru.netology.manager.posterManager;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class posterManagerTest {
    posterItem f1 = new posterItem(1, "Бладшот", "боевик", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    posterItem f2 = new posterItem(2, "Вперед", "мульфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    posterItem f3 = new posterItem(3, "Отель Белград", "комедия", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    posterItem f4 = new posterItem(4, "Джентельмены", "боевик", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    posterItem f5 = new posterItem(5, "Человек-Неведимка", "ужасы", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    posterItem f6 = new posterItem(6, "Тролли", "мультфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", true);
    posterItem f7 = new posterItem(7, "Номер один", "комедия", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", true);
    posterItem f8 = new posterItem(8, "Шрек", "мультфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    posterItem f9 = new posterItem(9, "Шрек 2", "мультфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    posterItem f10 = new posterItem(10, "Вверх", "мультфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
    posterItem f11 = new posterItem(11, "Кунгфу Панда", "мульфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);

    @Test
    public void shouldSaveIfNoOneFilmsExist() {
        posterManager manager = new posterManager();
        manager.save(f1);
        posterItem[] expected = new posterItem[]{f1};
        posterItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveIfSomeFilmsExist() {
        posterManager manager = new posterManager();
        manager.save(f1);
        manager.save(f2);
        manager.save(f3);
        posterItem[] expected = new posterItem[]{f3, f2, f1};
        posterItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveIfTheSameFilmExist() {
        posterManager manager = new posterManager();
        posterItem f1 = new posterItem(1, "Бладшот", "боевик", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
        posterItem f2 = new posterItem(2, "Вперед", "мульфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
        posterItem f3 = new posterItem(2, "Вперед", "мульфильм", "https://github.com/netology-code/javaqa-homeworks/blob/master/dependency/pic/afisha.png", false);
        manager.save(f1);
        manager.save(f2);
        manager.save(f3);
        posterItem[] expected = new posterItem[]{f3, f2, f1};
        posterItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLessOrEqual10Of9() {
        posterManager manager = new posterManager();
        manager.save(f1);
        manager.save(f2);
        manager.save(f3);
        manager.save(f4);
        manager.save(f5);
        manager.save(f6);
        manager.save(f7);
        manager.save(f8);
        manager.save(f9);
        posterItem[] expected = new posterItem[]{f9, f8, f7, f6, f5, f4, f3, f2, f1};
        posterItem[] actual = manager.findLessOrEqualFixedAmount();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLessOrEqual10IfEqual10() {
        posterManager manager = new posterManager();
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
        posterItem[] expected = new posterItem[]{f10, f9, f8, f7, f6, f5, f4, f3, f2, f1};
        posterItem[] actual = manager.findLessOrEqualFixedAmount();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLessOrEqual10If11() {
        posterManager manager = new posterManager();
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
        posterItem[] expected = new posterItem[]{f11, f10, f9, f8, f7, f6, f5, f4, f3, f2};
        posterItem[] actual = manager.findLessOrEqualFixedAmount();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLessOrEqual10IfNoOneExist() {
        posterManager manager = new posterManager();
        posterItem[] expected = new posterItem[0];
        posterItem[] actual = manager.findLessOrEqualFixedAmount();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfManyFilmsExist() {
        posterManager manager = new posterManager();
        manager.save(f1);
        manager.save(f2);
        manager.save(f3);
        manager.save(f4);
        manager.save(f5);
        manager.save(f6);
        manager.save(f7);
        manager.removeById(4);
        posterItem[] expected = new posterItem[]{f7, f6, f5, f3, f2, f1};
        posterItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfOneFilmExist() {
        posterManager manager = new posterManager();
        manager.save(f1);
        manager.removeById(1);
        posterItem[] expected = new posterItem[0];
        posterItem[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class posterItem {
    private int id;
    private String name;
    private String genre;
    private String pictureUrl;
    private boolean premiereTomorrow;

}
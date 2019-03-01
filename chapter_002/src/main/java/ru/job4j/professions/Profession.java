package ru.job4j.professions;

public class Profession {
    private String name;
    private String profession;

    public Profession(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }
}
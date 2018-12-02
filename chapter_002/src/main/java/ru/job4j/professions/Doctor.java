package ru.job4j.professions;

public class Doctor extends Profession {

    public Doctor(String name, String profession) {
        this.name = name;
        this.name = profession;
    }

    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}
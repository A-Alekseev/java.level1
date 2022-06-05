package ru.gb.alekseev.level2.homework1;

public class Course {

    private final Difficulty[] difficulties;

    public Course(Difficulty[] difficulties) {
        this.difficulties = difficulties;
    }

    public void doIt(Team team){
        for (Difficulty difficulty: difficulties) {
            for (Sportsman sportsman: team.getSportsmen()) {
                difficulty.makeSportsmanDoIt(sportsman);
            }
        }
    }
}

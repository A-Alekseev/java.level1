package ru.gb.alekseev.level2.homework1;

public class Team {
    public Team(Sportsman[] sportsmen) {
        this.sportsmen = sportsmen;
    }

    private Sportsman[] sportsmen;

    private String getSportsmenCompletedCource() {
        StringBuilder sb = new StringBuilder();
        for (Sportsman sportsman : sportsmen) {
            if (!sportsman.getIsDroppedOut()) {
                sb.append(sportsman).append(", ");
            }
        }
        return sb.toString();
    }

    private String getSportsmenAll(){
        StringBuilder sb = new StringBuilder();
        for (Sportsman sportsman : sportsmen) {
            sb.append(sportsman).append(", ");
        }
        return sb.toString();
    }


    public String getResults(){
        StringBuilder sb = new StringBuilder();
        sb.append("All sportsmen: ").append(getSportsmenAll())
        .append("\n");
        sb.append("Sportsmen completed course: ").append(getSportsmenCompletedCource());
        return sb.toString();
    }

    public void showResults() {
        System.out.println(getResults());
    }

    public Sportsman[] getSportsmen() {
        return sportsmen;
    }
}


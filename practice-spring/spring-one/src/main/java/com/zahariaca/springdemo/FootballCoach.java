package com.zahariaca.springdemo;

public class FootballCoach implements Coach {

    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public FootballCoach() {
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String getDailyWorkout() {
        return "Football for 2 hours today";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String toString() {
        return "FootballCoach{" +
                "fortuneService=" + fortuneService +
                ", emailAddress='" + emailAddress + '\'' +
                ", team='" + team + '\'' +
                '}';
    }

    private void initMethod() {
        System.out.println(this.getClass().getSimpleName() + ": initMethod");
    }

    private void destroyMethod() {
        System.out.println(this.getClass().getSimpleName() + ": destroyMethod");
    }
}

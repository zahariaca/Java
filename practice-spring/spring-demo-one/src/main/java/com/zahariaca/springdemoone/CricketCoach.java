package com.zahariaca.springdemoone;

/**
 * Created by Alex on 05.06.2017.
 */
public class CricketCoach implements Coach {
    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public CricketCoach(){
        System.out.println("    CricketCoach: inside of the constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Play cricket for some time I guess";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune() + "for the Cricketeers";
    }

    public void setFortuneService(FortuneService fortuneService){
        System.out.println("    CricketCoach: inside of setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("    CricketCoach: inside of setter method - setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("    CricketCoach: inside of setter method - setTeam");
        this.team = team;
    }
}

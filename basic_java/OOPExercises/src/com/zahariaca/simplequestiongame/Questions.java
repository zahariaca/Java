package com.zahariaca.simplequestiongame;

/**
 * Created by Zaharia Costin-Alexandru, email: zaharia.c.alexandru@gmail.com on 9/12/2016.
 */
public class Questions {
    private String text;
    private String[] answers;
    private String  rightAnswer;

    public Questions(String text, String... answers){
        this.text=text;
        this.answers=answers;
        this.rightAnswer=answers[0];
        shuffleAnswers(answers);
    }

    private void shuffleAnswers(String[] answers){
        for (int i = 0 ; i < answers.length; i++){
            int randomIndex = (int)(Math.random()*answers.length);
            String tmp = answers[i];
            answers[i] = answers[randomIndex];
            answers[randomIndex]= tmp;
        }
    }

    public void setText(String text){this.text=text;}
    public void setAnswers(String[] answers){this.answers=answers;}
    public void setRightAnswer(String rightAnswer){this.rightAnswer=rightAnswer;}
    public String getText(){return text;}
    public String[] getAnswers(){return answers;}
    public String getRightAnswer(){return rightAnswer;}


}

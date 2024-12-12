package org.baltimorecityschools.foodquizappjg;

public class Question {

    private String qText;
    private boolean correctAns;

    public Question(){
        qText = "TBD";
        correctAns = false;
    }
    public Question(String myqText, boolean mycorrectAns){
        qText = myqText;
        correctAns = mycorrectAns;
    }


    public String getqText(){
        return qText;
     }
     public boolean getCorrectAns(){
        return correctAns;
     }
     public void setqText(String newqText){
        qText = newqText;
     }
     public void setCorrectAns(boolean newCA){
        correctAns = newCA;
     }

    @Override
    public String toString() {
        return "Question{" +
                "qText='" + qText + '\'' +
                ", correctAns=" + correctAns +
                '}';
    }
}

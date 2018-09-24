package create_survey;

public class Constants {

    public  static final int checkbox=1;
    public  static final int radiobutton=2;
    public  static final int dropdown=3;
    public  static final int ranking=4;
    public  static final int emoji=5;
    public  static final int nps=6;
    public  static final int array=7;
    public  static final int textbox=8;
    public  static final int versus_logo=9;
    public  static final int versus_text=10;
    public  static final int normal_slider=11;
    public  static final int emoji_slider=12;
    public  static final int star_rating=13;

    String question;
    int type;

    public Constants(String question, int type) {
        this.question = question;
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

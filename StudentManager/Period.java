public class Period {
    String subject;
    int periodNum;
    String grade;

    public Period(String s, int num, String g) {
        subject = s;
        periodNum = num;
        grade = g;
    }
    public String toString() {
        return "Period "+periodNum+", "+subject+", "+grade;
    }
    
}

package no.simenbai.idatg2001.obligs.two;

import java.time.LocalDate;
import java.time.Period;

public class BonusMember {
    private final int memberNo;
    private final Personals personals;
    private final LocalDate enrolledDate;
    private int point = 0;

    public BonusMember(int memberNo, Personals personals, LocalDate enrolledDate, int point) {
        this.memberNo = memberNo;
        this.personals = personals;
        this.enrolledDate = enrolledDate;
        this.point = point;
    }

    public int findQualificationPoints(LocalDate time) {
        if(Period.between(enrolledDate, time).getDays() < 365){
            return getPoints();
        }
        return 0;
    }

    public boolean okPassword(String password) {
        return getPersonals().okPassword(password);
    }

    public void registerPoints(int points){
        this.point += points;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public Personals getPersonals() {
        return personals;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public int getPoints() {
        return point;
    }
}
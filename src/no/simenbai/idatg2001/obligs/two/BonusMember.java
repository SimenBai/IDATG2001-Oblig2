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
        if(getDays(Period.between(enrolledDate, time)) < 365){
            return getPoints();
        }
        return 0;
    }

    private int getDays(Period period){
        return Math.abs(period.getMonths()*30 + period.getYears() * 365 + period.getDays());
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
package no.simenbai.idatg2001.obligs.two;

import java.time.LocalDate;

public class SilverMember extends BonusMember{
    public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int points) {
        super(memberNo, personals, enrolledDate, points);
    }

    @Override
    public void registerPoints(int points) {
        super.registerPoints((int) (points*1.2));
    }
}
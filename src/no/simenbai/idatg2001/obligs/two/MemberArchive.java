package no.simenbai.idatg2001.obligs.two;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MemberArchive {
    static final int SILVER_LIMIT = 25000;
    static final int GOLD_LIMIT = 75000;
    static final Random RANDOM_NUMBER = new Random();
    ArrayList<BonusMember> members;

    public MemberArchive(ArrayList<BonusMember> members) {
        this.members = members;
    }
    public MemberArchive(){
        this.members = new ArrayList<>();
    }

    public int addMember(Personals personals, LocalDate date) {
        int memberNo = findAvailableNumber();
        members.add(new BasicMember(memberNo, personals, date));
        return memberNo;
    }

    public int findPoints(int memberNo, String password) {
        BonusMember member = findMember(memberNo);
        if (member != null && member.okPassword(password)) {
            return member.getPoints();
        }
        return -1;
    }

    public boolean registerPoints(int memberNo, int points) {
        BonusMember member = findMember(memberNo);
        if (member != null) {
            member.registerPoints(points);
            return true;
        }
        return false;
    }

    public void checkMembers(LocalDate date) {
        for (int i = 0; i < members.size(); i++) {
            BonusMember member = members.get(i);
            int qualifyingPoints = member.findQualificationPoints(date);
            if (qualifyingPoints >= GOLD_LIMIT && !(member instanceof GoldMember)) {
                members.set(i,
                        new GoldMember(
                                member.getMemberNo(),
                                member.getPersonals(),
                                member.getEnrolledDate(),
                                member.getPoints()
                        )
                );
            } else if (qualifyingPoints >= SILVER_LIMIT && !(member instanceof SilverMember)) {
                members.set(i,
                        new SilverMember(
                                member.getMemberNo(),
                                member.getPersonals(),
                                member.getEnrolledDate(),
                                member.getPoints()
                        )
                );
            }
        }
    }

    private BonusMember findMember(int memberNo) {
        for (BonusMember member : members) {
            if (member.getMemberNo() == memberNo) {
                return member;
            }
        }
        return null;
    }

    private int findAvailableNumber() {
        while (true) {
            int memberNo = RANDOM_NUMBER.nextInt();
            if (findMember(memberNo) == null) {
                return memberNo;
            }
        }
    }

    public static void main(String[] args) {
        // write your code here
    }
}

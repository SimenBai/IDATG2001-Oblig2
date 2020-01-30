package no.simenbai.idatg2001.obligs.two;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MemberArchive {
    static final int SILVER_LIMIT = 25000;
    static final int GOLD_LIMIT = 75000;
    static final int MAKS_TRY = 10;
    static final Random RANDOM_NUMBER = new Random();
    ArrayList<BonusMember> members;

    public MemberArchive(ArrayList<BonusMember> members) {
        this.members = members;
    }

    public int addMember(Personals personals, LocalDate date) {
        int memberNo = findAvailableNumber();
        members.add(new BonusMember(memberNo, personals, date));
        return memberNo;
    }

    public int findPoints(int memberNo, String password) {
        BonusMember member = findMember(memberNo);
        if (member.okPassword(password)) {
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

    }

    private BonusMember checkSilverLimit(int memberNo, LocalDate date) {
        return null;
    }

    private BonusMember checkGoldLimit(int memberNo, LocalDate date) {
        return null;
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

    public String createOutput(LocalDate date) {
        // Apparently a class I need
        return null;
    }

    public static void main(String[] args) {
        // write your code here
    }
}

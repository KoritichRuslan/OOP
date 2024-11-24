import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DutyController {
    private final List<Duty> duties;
    private final List<FamilyMember> familyMembers;
    private final Random random = new Random();

    public DutyController(List<Duty> duties, List<FamilyMember> familyMembers) {
        this.duties = duties;
        this.familyMembers = familyMembers;
    }

    public void distributeDuties() {
        for (Duty duty : duties) {
            FamilyMember member = selectRandomAvailableMember();
            if (member != null) {
                duty.doIt(member);
                simulation(member);
            } else {
                System.out.println("No available family member to perform " + duty.getClass().getName());
            }
        }
    }

    private FamilyMember selectRandomAvailableMember() {
        List<FamilyMember> availableMembers = new ArrayList<>();
        for (FamilyMember member : familyMembers) {
            if (member.isAvailable()) {
                availableMembers.add(member);
            }
        }
        if (availableMembers.isEmpty()) return null;
        return availableMembers.get(random.nextInt(availableMembers.size()));
    }

    private void simulation(FamilyMember member) {
        member.setAvailable(false);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
        member.setAvailable(true);
    }
}
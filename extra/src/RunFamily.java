import java.util.List;

public class RunFamily {
    public static void main(String[] args) {
        List<Duty> duties = List.of(
                new Cleaning(),
                new Cooking(),
                new KidsEducation()
        );

        List<FamilyMember> familyMembers = List.of(
                new Parent("Jane"),
                new Parent("John"),
                new IndependentKid("Bob")
        );

        DutyController dutyController = new DutyController(duties, familyMembers);
        dutyController.distributeDuties();
    }
}
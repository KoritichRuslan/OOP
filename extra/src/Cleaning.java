public class Cleaning implements Duty {
    @Override
    public void doIt(FamilyMember member) {
        System.out.println(member.getName() + " is cleaning.");
    }
}
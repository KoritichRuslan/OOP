public class Cooking implements Duty {
    @Override
    public void doIt(FamilyMember member) {
        System.out.println(member.getName() + " is cooking.");
    }
}
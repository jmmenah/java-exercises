// Slide 36
// Improved Secretary code

/*
Secretary can selectively override getSeniorityBonus; when getVacationDays runs, it will use the new version.
Choosing a method at runtime is called dynamic binding.
*/

// A class to represent secretaries.
public class Secretary extends Employee {
    
    // Salide 53
    public Secretary() {
        super();
    }
    

    public Secretary(int years) {
        super(years);
    }

    // Secretaries don't get a bonus for their years of service.
    public int getSeniorityBonus() {
        return 0;
    }

    public void takeDictation(String text) {
        System.out.println("Taking dictation of text: " + text);
    }
}

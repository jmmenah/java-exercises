// Slide 8

// A redundant class to represent secretaries.
public class Secretary {
    public int getHours() {
        return 40;           // works 40 hours / week
    }
    
    public double getSalary() {
        return 40000.0;      // $40,000.00 / year
    }
    
    public int getVacationDays() {
        return 10;           // 2 weeks' paid vacation
    }

    public String getVacationForm() {
        return "yellow";     // use the yellow form
    }
    
    public void takeDictation(String text) {
        System.out.println("Taking dictation of text: " + text);
    }
}

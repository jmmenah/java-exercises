import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    private int headCount;
    public ArrayList<SoftwareEngineer> reports = new ArrayList<>();

    public TechnicalLead(String name) {
        super(name);
        headCount = 4;
        setBaseSalary(getBaseSalary() * 1.3);

    }

    public boolean hasHeadCount() {
        return reports.size() < headCount;
    }

    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount()) {
            reports.add(e);
            return true;
        }
        return false;
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        return reports.contains(e) && e.getCodeAccess();
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (((Accountant) getManager()).approveBonus(bonus)) {
            ((SoftwareEngineer) e).bonus += bonus;
            return true;
        }
        return false;
    }

    public String getTeamStatus() {
        String output = "";
        output += employeeStatus();
        if (reports.size() == 0) output += " and no direct reports yet.";
        else {
            output += " and is managing: \n";
            for (int i = 0; i < reports.size(); i++) {
                output += reports.get(i).employeeStatus() + "\n";
            }
        }
        return output;
    }
}

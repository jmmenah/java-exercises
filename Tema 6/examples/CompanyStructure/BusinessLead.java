import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {
    private int headCount;
    private ArrayList<Accountant> reports = new ArrayList<>();

    public BusinessLead(String name) {
        super(name);
        setBaseSalary(getBaseSalary() * 2.0);
        headCount = 10;
    }

    public boolean hasHeadCount() {
        return reports.size() < headCount;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (hasHeadCount()) {
            reports.add(e);
            bonusBudget += e.getBaseSalary() * 1.1;
            return true;
        }
        return false;
    }

    public boolean requestBonus(Employee e, double bonus) {
        if (bonus < bonusBudget) {
            ((SoftwareEngineer) e).bonus += bonus;
            bonusBudget -= bonus;
            return true;
        }
        return false;
    }

    public boolean approveBonus(Employee e, double bonus) {
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i).equals(e.getManager()) && reports.get(i).approveBonus(bonus)) {
                return true;
            }
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

public class SoftwareEngineer extends TechnicalEmployee{
    private boolean codeAccess;
    public double bonus;

    public SoftwareEngineer(String name) {
        super(name);
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean access) {
        codeAccess = access;
    }

    public int getSuccessfulCheckIns() {
        return checkIns;
    }

    public boolean checkInCode() {
        if (((TechnicalLead) this.getManager()).approveCheckIn(this)) {
            checkIns++;
            return true;
        } else {
            codeAccess = false;
            return false;
        }
    }
}

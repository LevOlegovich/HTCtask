package com.nlv2022.htc.data.sharedpref;

public class GeneralInfoShared {


    private String nameCompany;
    private String ageCompany;
    private String competensec;
    private String timeUpdate;

    public GeneralInfoShared(String nameCompany, String ageCompany, String competensec, String timeUpdate) {
        this.nameCompany = nameCompany;
        this.ageCompany = ageCompany;
        this.competensec = competensec;
        this.timeUpdate = timeUpdate;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getAgeCompany() {
        return ageCompany;
    }

    public void setAgeCompany(String ageCompany) {
        this.ageCompany = ageCompany;
    }

    public String getCompetensec() {
        return competensec;
    }

    public void setCompetensec(String competensec) {
        this.competensec = competensec;
    }

    public String getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(String timeUpdate) {
        this.timeUpdate = timeUpdate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneralInfoShared that = (GeneralInfoShared) o;

        if (nameCompany != null ? !nameCompany.equals(that.nameCompany) : that.nameCompany != null)
            return false;
        if (ageCompany != null ? !ageCompany.equals(that.ageCompany) : that.ageCompany != null)
            return false;
        if (competensec != null ? !competensec.equals(that.competensec) : that.competensec != null)
            return false;
        return timeUpdate != null ? timeUpdate.equals(that.timeUpdate) : that.timeUpdate == null;
    }

    @Override
    public int hashCode() {
        int result = nameCompany != null ? nameCompany.hashCode() : 0;
        result = 31 * result + (ageCompany != null ? ageCompany.hashCode() : 0);
        result = 31 * result + (competensec != null ? competensec.hashCode() : 0);
        result = 31 * result + (timeUpdate != null ? timeUpdate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GeneralInfoShared{" +
                "nameCompany='" + nameCompany + '\'' +
                ", ageCompany='" + ageCompany + '\'' +
                ", competensec='" + competensec + '\'' +
                ", timeUpdate='" + timeUpdate + '\'' +
                '}';
    }
}

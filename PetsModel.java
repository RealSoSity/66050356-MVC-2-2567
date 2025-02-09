public class PetsModel {
    private String id;
    private String petType;
    private String lastCheckupDate;
    private int vaccineCount;

    public PetsModel(String id, String petType, String lastCheckupDate, int vaccineCount) {
        this.id = id;
        this.petType = petType;
        this.lastCheckupDate = lastCheckupDate;
        this.vaccineCount = vaccineCount;
    }

    public String getid() { return id; }
    public String getPetType() { return petType; }
    public String getLastCheckupDate() { return lastCheckupDate; }
    public int getVaccineCount() { return vaccineCount; }

    @Override
    public String toString() {
        return id + "," + petType + "," + lastCheckupDate + "," + vaccineCount;
    }
    
}
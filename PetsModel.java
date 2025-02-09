public class PetsModel {
    //ผมทำข้อแรก ของ MVC ที่เป็นเรื่องสัตว์เลี้ยง
    //Attribute
    private String id;
    private String type;
    private String lastCheckupDate;
    private int vaccineCount;
    private boolean accepted;

    //Constructor
    public PetsModel(String id, String type,String lastCheckupDate, int vaccineCount, boolean accepted){
        this.id = id;
        this.type = type;
        this.lastCheckupDate = lastCheckupDate;
        this.vaccineCount = vaccineCount;
        this.accepted = accepted;

    }

    //Getter setter
    public String getId() { return id; }
    public String getType() { return type; }
    public String getLastCheckupDate() { return lastCheckupDate; }
    public int getVaccineCount() { return vaccineCount; }
    public boolean getAccept(){return accepted;};

    public String toCSV(){
        return id + "," + type + "," + lastCheckupDate + "," + vaccineCount + "," + accepted;
    }
    
}
public class Model{
    //ผมทำข้อแรก ของ MVC ที่เป็นเรื่องสัตว์เลี้ยง
    //Attribute
    private String id;
    private String type;
    private String lastCheckupDate;
    private int vaccineCount;

    //Constructor
    public Model(String id, String type,String lastCheckupDate, int vaccineCount){
        this.id = id;
        this.type = type;
        this.lastCheckupDate = lastCheckupDate;
        this.vaccineCount = vaccineCount;
    }

    //Getter setter
    public String getId() { return id; }
    public String getType() { return type; }
    public String getLastCheckupDate() { return lastCheckupDate; }
    public int getVaccineCount() { return vaccineCount; }

    //toString
    @Override
    public String toString() {
        return "Model [id=" + id + ", type=" + type + ", lastCheckupDate=" + lastCheckupDate + ", vaccineCount="
                + vaccineCount + "]";
    }

    
}
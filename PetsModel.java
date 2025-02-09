public class PetsModel {
    //ผมทำข้อแรก ของ MVC ที่เป็นเรื่องสัตว์เลี้ยง
    //Attribute
    private int id;  //id
    private String type; //type e.g. Phoenix, Dragon, Owl
    private String lastCheckupDate;  //Last healrh check-up Date
    private int vaccineCount; //How many pet have vaccine
    private boolean accepted; //Accept or reject (true: Accept, false : Reject)

    //Constructor of this class
    public PetsModel(int id, String type,String lastCheckupDate, int vaccineCount, boolean accepted){
        this.id = id;
        this.type = type;
        this.lastCheckupDate = lastCheckupDate;
        this.vaccineCount = vaccineCount;
        this.accepted = accepted;

    }

    //Getter setter
    public String getId() { return Integer.toString(id); }
    public String getType() { return type; }
    public String getLastCheckupDate() { return lastCheckupDate; }
    public int getVaccineCount() { return vaccineCount; }
    public boolean getAccept(){return accepted;};

    public String toCSV(){
        return id + "," + type + "," + lastCheckupDate + "," + vaccineCount + "," + accepted;
    }
}
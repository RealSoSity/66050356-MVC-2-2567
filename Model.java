public class Model{
    //ผมทำข้อแรก ของ MVC ที่เป็นเรื่องสัตว์เลี้ยง
    //Attribute
    private String id;
    private String type;
    private String lastCheckupDate;
    private int vaccineCount;
    private boolean accepted;

    //Constructor
    public Model(String id, String type,String lastCheckupDate, int vaccineCount, boolean accepted){
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

}

// class Phoenix extends PetsModel{
//     private boolean fireProofCertificate;
//     public Phoenix(String id, String lastCheckupDate, int vaccineCount, boolean fireProofCertificate){
//         super(id, "Phoenix",lastCheckupDate,vaccineCount);
//         // if(!fireProofCertificate){
//         //     throw new Exception("Not have FireProof Ceritificate")
//         // }

//         this.fireProofCertificate = fireProofCertificate;
//     }
// }

// class Dragon extends PetsModel{
//     private int smokePollutionLevel;

//     public Dragon(String id, String lastCheckupDate, int vaccineCount, int smokePollutionLevel){
//         super(id, "Dragon",lastCheckupDate,vaccineCount);
//         // if(!fireProofCertificate){
//         //     throw new Exception("Not have FireProof Ceritificate")
//         // }

//         this.smokePollutionLevel = smokePollutionLevel;
//     }
// }

// class Owl extends PetsModel{
//     private int fightDistance;

//     public Owl(String id, String lastCheckupDate, int vaccineCount, int fightDistance){
//         super(id, "Owl",lastCheckupDate,vaccineCount);
//         // if(!fireProofCertificate){
//         //     throw new Exception("Not have FireProof Ceritificate")
//         // }

//         this.fightDistance = fightDistance;
//     }
// }


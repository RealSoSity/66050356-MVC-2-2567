import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvRead {
    private List<PetsModel> pets = new ArrayList<>();
    private String file_path;

    public CsvRead(String file_path){
        this.file_path = file_path;
    }

    //Use to read data,which in CSV file
    private void readCsvData(){
        try(BufferedReader  br = new BufferedReader(new FileReader(file_path))){
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(",");

                if(data.length == 4){
                    pets.add(new PetsModel(data[0], data[1], data[2], Integer.parseInt(data[3])));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<PetsModel> getPetsList(){
        return pets;
    }
}

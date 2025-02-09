import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvRead {
    //Setup Attribute
    private String file_path; //File path

    public CsvRead(String file_path){
        this.file_path = file_path;
        //read csv when open program
    }

    //Use to read data,which in CSV file
    public void readCsvData(List<PetsModel> pets){
        try(BufferedReader  br = new BufferedReader(new FileReader(file_path))){
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(",");

                if(data.length == 5){
                    pets.add(new PetsModel(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), Boolean.parseBoolean(data[4])));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

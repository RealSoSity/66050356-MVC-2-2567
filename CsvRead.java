import java.io.BufferedReader;
import java.io.FileReader;

public class CsvRead {
    private String file_path;

    public CsvRead(String file_path){
        this.file_path = file_path;
    }

    //Use to read data.which in CSV file
    private void readCsvData(){
        try(BufferedReader  br = new BufferedReader(new FileReader(file_path))){
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWritter {

    private String file_path;
    //Write data into CSV
    public CsvWritter(String file_path){
        this.file_path = file_path;
    }

    public void addPets(List<PetsModel> pets){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file_path))) {
            for (PetsModel pet : pets) {
                writer.write(pet.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

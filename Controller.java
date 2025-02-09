import java.util.ArrayList;
import java.util.List;

public class Controller {
    //Attribute and Set-up
    private View view;
    private CsvRead csvRead;
    private CsvWritter csvWritter;
    private List<PetsModel> pets = new ArrayList<>();

    public Controller(View view, CsvRead csvRead, CsvWritter csvWritter){
        this.view = view;
        this.csvRead = csvRead;
        this.csvWritter = csvWritter;
        pets = csvRead.getPetsList();
    }

    private void addPets(PetsModel pet){
        pets.add(pet);
        csvWritter.addPets(pets);
    }

    public int getAcceptCount(String type){
        return (int) pets.stream().filter(p -> p.getType().equals(type) && p.getAccept()).count();
    }

    public int getRejectCount(){
        return (int) pets.stream().filter(p -> !p.getAccept()).count();
    }


}

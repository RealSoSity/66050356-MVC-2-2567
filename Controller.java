import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

        this.view.addPetsActionListener(new addPetsActionListener());
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



    // AddActionlistener to button

    class addPetsActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = view.getIdField();
            String type = view.getTypeSelected();
            String date = view.getDate();
            int Vaccines = view.getVaccineCount();
            boolean accepted = true;

            if (!Pattern.matches("[1-9][0-9]{7}", id)) {
                view.showMessage("Invalid ID: Must be 8 digits, first digit not 0");
                return;
            }
            if (!Pattern.matches("\\d{2}/\\d{2}/\\d{4}", date)) {
                view.showMessage("Invalid Date: Format should be DD/MM/YYYY");
                return;
            }
            if (!(Integer.toString(Vaccines)).matches("\\d+") || Vaccines < 0) {
                view.showMessage("Invalid Vaccine Count: Must be a positive integer");
                return;
            }

            if((type.toLowerCase()).equals("phoenix") && !view.getFireProof()){
                accepted = false;
                view.showMessage("Phoenix not have Fire Proof Certificate");
            }else if((type.toLowerCase()).equals("dragon") && view.getPollutionField() > 70){
                accepted = false;
                view.showMessage("Pollution more than 70%");
            }else if((type.toLowerCase()).equals("owl") && view.getFlightDis() < 100){
                accepted = false;
                view.showMessage("Flight Distance less than 100km");
            }

            addPets(new PetsModel(Integer.parseInt(id), type, date, Vaccines, accepted));
            view.updateTable(pets);
        }
    }

    class ReportAddActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           view.showReport(getAcceptCount("Phoenix"), getAcceptCount("Dragon"), getAcceptCount("Owl"), getRejectCount());
        }
        
    }



}

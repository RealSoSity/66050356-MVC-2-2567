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



    // AddActionlistener to AddPets button (Add pets to school)

    class addPetsActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String id = view.getIdField();
            String type = view.getTypeSelected();
            String date = view.getDate();
            int Vaccines = view.getVaccineCount();
            boolean accepted = true;

            //Check constraint when user input

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

            //Check format of date
            String[] dateParts = date.split("/");
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            if(month < 1 || month > 12 || day < 1 || day > 31) {
                view.showMessage("Invalid Date: Month should be between 1-12 and Day should be between 1-31");
                return;
            }

            //Check that we will accept pet or not by check constraint
            if((type.toLowerCase()).equals("phoenix") && !view.getFireProof()){ //check if Phoenix have FireProofCertificate
                accepted = false;
                view.showMessage("Phoenix not have Fire Proof Certificate"); //Show message to tell user
            }else if((type.toLowerCase()).equals("dragon") && view.getPollutionField() > 70){ //Check if Dragon unlease pollution not more than 70
                accepted = false;
                view.showMessage("Pollution more than 70%");
            }else if((type.toLowerCase()).equals("owl") && view.getFlightDis() < 100){ //check if owl can flight more 100km by dont eating anything
                accepted = false;
                view.showMessage("Flight Distance less than 100km");
            }

            addPets(new PetsModel(Integer.parseInt(id), type, date, Vaccines, accepted));
            view.updateTable(pets);
        }
    }
    
    
    //Call function when user press Report button

    class ReportAddActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           view.showReport(getAcceptCount("Phoenix"), getAcceptCount("Dragon"), getAcceptCount("Owl"), getRejectCount());
        }
        
    }



}

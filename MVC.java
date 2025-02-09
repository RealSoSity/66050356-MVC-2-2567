public class MVC {
    public static void main(String[] args) {
        View view = new View();
        CsvRead csvRead = new CsvRead("Animals.csv");
        CsvWritter csvWritter = new CsvWritter("Animals.csv");
        new Controller(view, csvRead, csvWritter);
        view.setVisible(true);
    }
}

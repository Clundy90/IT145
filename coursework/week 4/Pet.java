package coursework;

public class Pet {

    // Attributes set to private for encapsulation
    private String petType;
    private String petName;
    private int petAge;
    private int dogSpaces;
    private int catSpaces;
    private int daysStay;
    private double amountDue;

    // Blank constructor
    public Pet() {
        petType = "";
        petName = "";
        petAge = 0;
        dogSpaces = 0;
        catSpaces = 0;
        daysStay = 0;
        amountDue = 0.0;
    }

    // Constructor with parameters using this keyword to assign values to a Pet object when it is created
    public Pet(String petType, String petName, int petAge, int dogSpaces, int catSpaces, int daysStay, double amountDue) {
        this.petType = petType;
        this.petName = petName;
        this.petAge = petAge;
        this.dogSpaces = dogSpaces;
        this.catSpaces = catSpaces;
        this.daysStay = daysStay;
        this.amountDue = amountDue;
    }

    // Accessor for petType
    public String getPetType() {
        return petType;
    }

    // Mutator for petType
    public void setPetType(String petType) {
        this.petType = petType;
    }

    // Accessor for petName
    public String getPetName() {
        return petName;
    }  

    // Mutator for petName
    public void setPetName(String petName) {
        this.petName = petName;
    }

    // Accessor for petAge
    public int getPetAge() {
        return petAge;
    }

    // Mutator for petAge
    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    // Accessor for dogSpaces
    public int getDogSpaces() {
        return dogSpaces;
    }
    
    // Mutator for dogSpaces
    public void setDogSpaces(int dogSpaces) {
        this.dogSpaces = dogSpaces;
    }

    // Accessor for catSpaces
    public int getCatSpaces() {
        return catSpaces;
    }
    
    // Mutator for catSpaces
    public void setCatSpaces(int catSpaces) {
        this.catSpaces = catSpaces;
    }
    
    // Accessor for daysStay
    public int getDaysStay() {
        return daysStay;
    }

    // Mutator for daysStay
    public void setDaysStay(int daysStay) {
        this.daysStay = daysStay;
    }
    
    // Accessor for amountDue
    public double getAmountDue() {
        return amountDue;
    }
    
    // Mutator for amountDue
    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }
    

}
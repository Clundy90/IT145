package coursework;

public class Dog extends Pet {

    // Attributes set to private for encapsulation
    private int dogSpaceNumber;
    private double dogWeight;
    private boolean grooming;

    // Blank constructor
   public Dog() {
        dogSpaceNumber = 0;
        dogWeight = 0.0;
        grooming = false;
    }

    // Constructor with parameters using this keyword to assign values to a Dog object when it is created
    public Dog(int dogSpaceNumber, double dogWeight, boolean grooming) {
        this.dogSpaceNumber = dogSpaceNumber;
        this.dogWeight = dogWeight;
        this.grooming = grooming;
    }

    // Accessor for dogSpaceNumber
    public int getDogSpaceNumber() {
        return dogSpaceNumber;
    }

    // Mutator for dogSpaceNumber
    public void setDogSpaceNumber(int dogSpaceNumber) {
        this.dogSpaceNumber = dogSpaceNumber;
    }

    // Accessor for dogWeight
    public double getDogWeight() {
        return dogWeight;
    }

    // Mutator for dogWeight
    public void setDogWeight(double dogWeight) {
        this.dogWeight = dogWeight;
    }

    // Accessor for grooming
    public boolean getGrooming() {
        return grooming;
    }

    // Mutator for grooming
    public void setGrooming(boolean grooming) {
        this.grooming = grooming;
    }
}
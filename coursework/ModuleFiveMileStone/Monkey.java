
package coursework.ModuleFiveMileStone;


public class Monkey extends RescueAnimal {

    // Instance variables
    private String species;
    private String tailLength;
    private String height;
    private String bodyLength;

    public Monkey() {
        super();
        setAnimalType("monkey");
    }

    // Complete Constructor with the missing attributes added
    public Monkey(String name, String species, String tailLength, String height, String bodyLength,
              String gender, String age, String weight, String acquisitionDate,
              String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry) {
                
    setName(name);
    setSpecies(species);
    setTailLength(tailLength);
    setHeight(height);
    setBodyLength(bodyLength);
    setGender(gender);
    setAge(age);
    setWeight(weight);
    setAcquisitionDate(acquisitionDate);
    setAcquisitionLocation(acquisitionCountry);
    setTrainingStatus(trainingStatus);
    setReserved(reserved);
    setInServiceCountry(inServiceCountry);
    setAnimalType("monkey");
}

    // Accessor for species
    public String getSpecies() {
        return species;
    }

    // Mutator for species
    public void setSpecies(String monkeySpecies) {
        species = monkeySpecies;
    }
    // Acessor for tailLength
    public String getTailLength() {
        return tailLength;
    }

    // Mutator for tailLength
    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }

    // Acessor for height
    public String getHeight() {
        return height;
    }

    // Mutator for height
    public void setHeight(String height) {
        this.height = height;
    }

    // Acessor for bodyLength
    public String getBodyLength() {
        return bodyLength;
    }

    // Mutator for bodyLength
    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }
}

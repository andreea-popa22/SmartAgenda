package smartagenda.entitiesHelpers;

public enum ServiceType {
    MEDICAL("Medical"),
    MAKE_UP("Make up"),
    HAIR_STYLING("Hair styling"),
    HAIRCUT("Haircut"),
    HAIR_COLORING("Hair coloring"),
    MANICURE("Manicure"),
    PEDICURE("Pedicure"),
    THERAPY("Therapy"),
    YOGA("Yoga");


    private final String name;

    ServiceType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

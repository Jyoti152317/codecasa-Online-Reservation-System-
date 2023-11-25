class Reservation {
    private int id;
    private String name;
    private String date;
    private int numberOfGuests;

    public Reservation(int id, String name, String date, int numberOfGuests) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.numberOfGuests = numberOfGuests;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }
}
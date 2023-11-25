import java.util.ArrayList;
import java.util.List;

class ReservationSystem {
    private List<Reservation> reservations = new ArrayList<>();
    private int nextId = 1;

    public Reservation makeReservation(String name, String date, int numberOfGuests) {
        Reservation reservation = new Reservation(nextId++, name, date, numberOfGuests);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Reservation getReservationById(int id) {
        for (Reservation reservation : reservations) {
            if (reservation.getId() == id) {
                return reservation;
            }
        }
        return null;
    }

    public boolean cancelReservation(int id) {
        Reservation reservation = getReservationById(id);
        if (reservation != null) {
            reservations.remove(reservation);
            return true;
        }
        return false;
    }
}

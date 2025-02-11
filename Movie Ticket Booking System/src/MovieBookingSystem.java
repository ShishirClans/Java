import java.util.*;

class Movie {
    private String title;
    private List<Showtime> showtimes;

    public Movie(String title) {
        this.title = title;
        this.showtimes = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
    }

    public List<Showtime> getShowtimes() {
        return showtimes;
    }

    @Override
    public String toString() {
        return title;
    }
}

class Showtime {
    private String time;
    private Seat[][] seats;

    public Showtime(String time) {
        this.time = time;
        this.seats = new Seat[5][5]; // 5x5 seating arrangement
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                seats[i][j] = new Seat(i, j);
            }
        }
    }

    public String getTime() {
        return time;
    }

    public void displaySeats() {
        System.out.println("Seating Chart (X = booked, O = available):");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(seats[i][j].isBooked() ? "X " : "O ");
            }
            System.out.println();
        }
    }

    public boolean bookSeat(int row, int col) {
        if (row < 0 || row >= 5 || col < 0 || col >= 5) {
            System.out.println("Invalid seat selection.");
            return false;
        }
        if (seats[row][col].isBooked()) {
            System.out.println("Seat is already booked.");
            return false;
        }
        seats[row][col].book();
        return true;
    }
}

class Seat {
    private int row, col;
    private boolean booked;

    public Seat(int row, int col) {
        this.row = row;
        this.col = col;
        this.booked = false;
    }

    public boolean isBooked() {
        return booked;
    }

    public void book() {
        this.booked = true;
    }
}

class Ticket {
    private Movie movie;
    private Showtime showtime;
    private int row, col;

    public Ticket(Movie movie, Showtime showtime, int row, int col) {
        this.movie = movie;
        this.showtime = showtime;
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Movie: " + movie.getTitle() + "\nShowtime: " + showtime.getTime() + "\nSeat: [" + row + "," + col + "]";
    }
}

class User {
    private String name;
    private List<Ticket> tickets;

    public User(String name) {
        this.name = name;
        this.tickets = new ArrayList<>();
    }

    public void bookTicket(Movie movie, Showtime showtime, int row, int col) {
        if (showtime.bookSeat(row, col)) {
            Ticket ticket = new Ticket(movie, showtime, row, col);
            tickets.add(ticket);
            System.out.println("Booking successful! Your ticket details:");
            System.out.println(ticket);
        } else {
            System.out.println("Booking failed. Try again.");
        }
    }

    public void showTickets() {
        if (tickets.isEmpty()) {
            System.out.println(name + " has no booked tickets.");
        } else {
            System.out.println(name + "'s Tickets:");
            for (Ticket ticket : tickets) {
                System.out.println(ticket);
                System.out.println("----------------------");
            }
        }
    }
}

public class MovieBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();

        // Sample Movies & Showtimes
        Movie movie1 = new Movie("Inception");
        Showtime showtime1 = new Showtime("5:00 PM");
        Showtime showtime2 = new Showtime("8:00 PM");
        movie1.addShowtime(showtime1);
        movie1.addShowtime(showtime2);

        Movie movie2 = new Movie("Titanic");
        Showtime showtime3 = new Showtime("6:30 PM");
        movie2.addShowtime(showtime3);

        movies.add(movie1);
        movies.add(movie2);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        User user = new User(userName);

        while (true) {
            System.out.println("\n--- Movie Ticket Booking ---");
            System.out.println("1. View Movies");
            System.out.println("2. Book a Ticket");
            System.out.println("3. View My Tickets");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("\nAvailable Movies:");
                for (int i = 0; i < movies.size(); i++) {
                    System.out.println((i + 1) + ". " + movies.get(i).getTitle());
                }
            } else if (choice == 2) {
                System.out.println("\nSelect a Movie:");
                for (int i = 0; i < movies.size(); i++) {
                    System.out.println((i + 1) + ". " + movies.get(i).getTitle());
                }
                System.out.print("Enter choice: ");
                int movieChoice = scanner.nextInt();
                if (movieChoice < 1 || movieChoice > movies.size()) {
                    System.out.println("Invalid movie selection.");
                    continue;
                }
                Movie selectedMovie = movies.get(movieChoice - 1);

                System.out.println("\nAvailable Showtimes:");
                List<Showtime> availableShowtimes = selectedMovie.getShowtimes();
                for (int i = 0; i < availableShowtimes.size(); i++) {
                    System.out.println((i + 1) + ". " + availableShowtimes.get(i).getTime());
                }
                System.out.print("Enter choice: ");
                int showtimeChoice = scanner.nextInt();
                if (showtimeChoice < 1 || showtimeChoice > availableShowtimes.size()) {
                    System.out.println("Invalid showtime selection.");
                    continue;
                }
                Showtime selectedShowtime = availableShowtimes.get(showtimeChoice - 1);

                selectedShowtime.displaySeats();
                System.out.print("Enter row (0-4): ");
                int row = scanner.nextInt();
                System.out.print("Enter column (0-4): ");
                int col = scanner.nextInt();

                user.bookTicket(selectedMovie, selectedShowtime, row, col);
            } else if (choice == 3) {
                user.showTickets();
            } else if (choice == 4) {
                System.out.println("Thank you for using the Movie Ticket Booking System!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}

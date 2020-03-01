package oracle.ocp.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class NoneMachShortCircuitCheck {
    public static void main(String args[]) {
        Stream<Client> clients = Stream.of(
                new Client("Will", "vps server", 200),
                new Client("Rachel", "java program", 1200),
                new Client("Antony", "Configuration", 1000));

        Predicate<Client> function = e -> {
            System.out.println(e.getName() + " ");
            return e.getBudget() > 1000.0;
        };

        clients.peek(System.out::println).noneMatch(function);
    }

}

class Client {
    private double budget;
    private String name;
    private String project;

    public Client(String name, String project, double budget) {
        this.budget = budget;
        this.name = name;
        this.project = project;
    }

    public double getBudget() {
        return budget;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", " + budget;
    }

}
package Models;

import java.time.LocalDateTime;

public record Motorcycle(String registration, String owner, LocalDateTime entryTime) implements Vehicle{
}

package Models;

import java.time.LocalDateTime;

public record Car(String registration, String owner, LocalDateTime entryTime) implements Vehicle{
}

package Models;

import java.time.LocalDateTime;

record Car(String registration, String owner, LocalDateTime entryTime) implements Vehicle{
}

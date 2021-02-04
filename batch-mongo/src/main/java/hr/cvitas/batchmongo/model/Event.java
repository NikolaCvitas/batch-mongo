package hr.cvitas.batchmongo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

public class Event {

    @Id
    UUID id;

    private UUID uuid;

    private String code;

    private String description;

    private long created_date;


    public Event() {
    }

    public Event(UUID id, UUID uuid, String code, String description, long created_date) {
        this.id = id;
        this.uuid = uuid;
        this.code = code;
        this.description = description;
        this.created_date = created_date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreated_date() {
        return created_date;
    }

    public void setCreated_date(long created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", created_date=" + created_date +
                '}';
    }
}

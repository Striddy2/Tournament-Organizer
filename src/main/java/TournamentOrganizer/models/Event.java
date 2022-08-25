package TournamentOrganizer.models;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Event extends AbstractEntity {

    @NotBlank(message = "Name is required!")
    @NotNull
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters!")
    private String name;

    @NotBlank(message = "Description is required!")
    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Location is required")
    @NotNull
    @Size(max = 50, message = "Location is too long!")
    private String location;

    @NotBlank(message = "Competitive level required!")
    @NotNull
    private String competitiveLevel;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "Date is required!")
    @NotNull
    private String date;

    @NotBlank(message = "Summary is required!")
    @NotNull
    @Size(max = 100, message = "Summary is too long!")
    private String summary;

    @NotBlank(message = "Entry Fee is required!")
    @NotNull
    private String entryFee;

    public Event(String name, String description, String location, String competitiveLevel, String date, String summary, String entryFee) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.competitiveLevel = competitiveLevel;
        this.date = date;
        this.summary = summary;
        this.entryFee = entryFee;
    }

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompetitiveLevel() {
        return competitiveLevel;
    }

    public void setCompetitiveLevel(String competitiveLevel) {
        this.competitiveLevel = competitiveLevel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(String entryFee) {
        this.entryFee = entryFee;
    }

    @Override
    public String toString() {
        return name;
    }
}


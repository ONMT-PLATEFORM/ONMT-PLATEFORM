package ma.onmt.api.regionservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "events")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    // Additional fields
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "location")
    private String location;
    @ManyToOne
    Region region;

    // Constructors, getters, setters, and other methods
}

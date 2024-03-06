package ma.onmt.api.regionservice.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@Entity
@Table(name = "accommodations")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    // Additional fields
    @Column(name = "type")
    private String type;

    @Column(name = "amenities")
    private String amenities;

    @ManyToOne
    Region region;
}

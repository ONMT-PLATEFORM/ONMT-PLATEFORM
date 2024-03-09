package ma.onmt.api.regionservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "touristic_attractions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TouristicAttraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private String description;
    private String location;
    private String image;
    @ManyToOne
    Region region;
}

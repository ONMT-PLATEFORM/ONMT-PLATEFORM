package ma.onmt.api.regionservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "regions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description",length = 1000)
    private String description;
    private String imageUrl;
    private String area ;
    private String gdp;
    private String population;
}

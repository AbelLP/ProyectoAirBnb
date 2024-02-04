package naranco.dam.proyectoalojamientos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="barrios")
@Data
@NoArgsConstructor
public class Barrios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name="distrito_id", nullable = false)
    private Distritos distritos;
}

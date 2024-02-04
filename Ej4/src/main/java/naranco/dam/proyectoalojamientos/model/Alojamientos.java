package naranco.dam.proyectoalojamientos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="alojamientos")
@Data
@NoArgsConstructor
public class Alojamientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre", length = 255)
    private String nombre;

    @Column(name="banos")
    private int banos;

    @Column(name="camas")
    private int camas;

    @Column(name="habitaciones")
    private int habitaciones;

    @Column(name="aseos")
    private int aseos;

    @Column(name="longitud")
    private int longitud;

    @Column(name = "latitud")
    private int latitud;

    @Column(name="precio")
    private double precio;

    @Column(name="puntuacion")
    private double puntuacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="propietario_id", nullable = false)
    private Propietarios propietario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="tipoHabitacion_id", nullable = false)
    private TiposHabitacion tiposHabitacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="barrio_id", nullable = false)
    private Barrios barrios;
}

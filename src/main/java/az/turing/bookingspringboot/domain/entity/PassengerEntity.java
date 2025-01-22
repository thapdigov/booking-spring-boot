package az.turing.bookingspringboot.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "passenger")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long ID;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
}

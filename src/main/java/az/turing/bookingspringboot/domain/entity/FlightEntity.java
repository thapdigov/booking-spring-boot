package az.turing.bookingspringboot.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flight")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightId")
    private Long ID;
    @Column(name = "flightFrom")
    private String flightFrom;
    @Column(name = "flightTo")
    private String flightTo;
    @Column(name = "availableSeat")
    private Integer availableSeat;
    @Column(name = "totalSeat")
    private Integer totalSeat;
}

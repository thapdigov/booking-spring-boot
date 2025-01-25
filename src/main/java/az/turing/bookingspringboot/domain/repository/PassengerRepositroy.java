package az.turing.bookingspringboot.domain.repository;

import az.turing.bookingspringboot.domain.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepositroy extends JpaRepository<PassengerEntity, Long> {
    boolean existsByNameAndSurname(String name, String surname);

    boolean existsByID(Long id);
}

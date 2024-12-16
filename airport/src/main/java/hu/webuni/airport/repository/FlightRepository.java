package hu.webuni.airport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import hu.webuni.airport.model.Flight;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface FlightRepository extends JpaRepository<Flight, Long>,
        JpaSpecificationExecutor<Flight>,
        QuerydslPredicateExecutor<Flight>
        {

}

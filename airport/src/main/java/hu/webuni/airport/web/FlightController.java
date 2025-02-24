package hu.webuni.airport.web;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.airport.dto.FlightDto;
import hu.webuni.airport.mapper.FlightMapper;
import hu.webuni.airport.model.Flight;
import hu.webuni.airport.service.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/flights")
public class FlightController {

	private final FlightService flightService;
	private final FlightMapper flightMapper;
	
	
	@PostMapping
	public FlightDto createFlight(@RequestBody @Valid FlightDto flightDto) {
		Flight flight = flightService.save(flightMapper.dtoToFlight(flightDto));
		return flightMapper.flightToDto(flight);
	}
	
	@PostMapping("/search")
	public List<FlightDto> searchFlights(@RequestBody FlightDto example){
		return flightMapper.flightsToDtos(flightService.findFlightsByExample(flightMapper.dtoToFlight(example)));
	}
}

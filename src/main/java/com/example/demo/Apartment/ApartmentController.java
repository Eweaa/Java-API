package com.example.demo.Apartment;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ApartmentController
{
    private final ApartmentRepository apartmentRepository;

    public ApartmentController(ApartmentRepository apartmentRepository)
    {
        this.apartmentRepository = apartmentRepository;
    }

    @GetMapping("/hello")
    String Home()
    {
        return "Hello, from Apartment";
    }

    @GetMapping("/api/apartments")
    List<Apartment> findAll()
    {
        return apartmentRepository.findAll();
    }

//    @GetMapping("/api/apartments/{Id}")
//    Apartment findById(@PathVariable Integer Id)
//    {
//        return apartmentRepository.findById(Id);
//    }

    @GetMapping("/api/apartments/{Id}")
    Apartment findById(@PathVariable Integer Id)
    {
        Optional<Apartment> res = apartmentRepository.findById(Id);
        if (res.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Apartment Was Not Found");
        }
        return res.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Apartment apartment)
    {
        apartmentRepository.create(apartment);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{Id}")
    void update(@Valid @RequestBody Apartment apartment,@PathVariable Integer Id)
    {
        apartmentRepository.update(apartment, Id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{Id}")
    void delete(Integer Id)
    {
        apartmentRepository.delete(Id);
    }
}

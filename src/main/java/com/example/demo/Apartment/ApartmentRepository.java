package com.example.demo.Apartment;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ApartmentRepository
{
    private List<Apartment> apartments = new ArrayList<>();

    List<Apartment> findAll()
    {
        return apartments;
    }

//    Apartment findById(Integer Id)
//    {
//        return apartments.stream().filter(a -> a.Id() == Id).findFirst().get();
//    }

    Optional<Apartment> findById(Integer Id)
    {
        return apartments.stream().filter(a -> a.Id() == Id).findFirst();
    }

    void create(Apartment apartment)
    {
        apartments.add(apartment);
    }

    void update(Apartment apartment, Integer Id)
    {
        Optional<Apartment> exisitingApartment = findById(Id);
        if(exisitingApartment.isPresent())
        {
            apartments.set(apartments.indexOf(exisitingApartment.get()), apartment);
        }
    }

    void delete(Integer Id)
    {
        apartments.removeIf(apartment -> apartment.Id().equals(Id));
    }


    @PostConstruct
    private void init()
    {
        apartments.add(new Apartment(1, 200, "Somewhere 1"));
        apartments.add(new Apartment(2, 400, "Somewhere 2"));
    }
}

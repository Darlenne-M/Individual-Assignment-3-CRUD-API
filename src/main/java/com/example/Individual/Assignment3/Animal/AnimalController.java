package com.example.Individual.Assignment3.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * AnimalController is a REST controller that handles HTTP requests related to
 * students.
 * It provides endpoints for CRUD operations on student data.
 */
@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService;

     /**
   * Endpoint to get all dogs
   *
   * @return List of all dogs
   */

    @GetMapping("/animals")
    public Object getAllAnimals(){
        return animalService.getAllAnimals();
    }

      /**
   * Endpoint to get a animal by ID
   *
   * @param id The ID of the animal to retrieve
   * @return The animal with the specified ID
   */

   @GetMapping("/animals/{id}")
   public Animal getAnimalById(@PathVariable long id){
    return animalService.getAnimalById(id);
   }

    /**
   * Endpoint to get animal by name
   *
   * @param name The name of the animal to search for
   * @return List of animal with the specified name
   */

   @GetMapping("/animals/name")
   public Object getAnimalsByName(@RequestParam String key){
        if(key != null){
            return animalService.getAnimalsByName(key);
        }else{
            return animalService.getAllAnimals();
        }
   }


    /**
   * Endpoint to get students by major
   *
   * @param major The major to search for
   * @return List of students with the specified major
   */

  


}

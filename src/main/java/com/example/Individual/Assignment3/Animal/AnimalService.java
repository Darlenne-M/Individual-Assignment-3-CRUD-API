package com.example.Individual.Assignment3.Animal;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AnimalService {
    
    @Autowired
    private AnimalRepository animalRepository;

  /**
   * Method to get all students
   *
   * @return List of all students
   */
    public Object getAllAnimals(){
        return animalRepository.findAll();
    }

      /**
   * Method to get a student by ID
   *
   * @param studentId The ID of the student to retrieve
   * @return The student with the specified ID
   */

   public Animal getAnimalById(@PathVariable long dogId){
    return animalRepository.findById(dogId).orElse(null);
   }

   
  /**
   * Method to get students by name
   *
   * @param name The name of the student to search for
   * @return List of students with the specified name
   */
  public Object getAnimalsByName(String name){
    return animalRepository.getAnimalsByName(name);
  }

 /**
   * Method to get students by major
   *
   * @param major The major to search for
   * @return List of students with the specified major
   */
  public Object getAnimalsByBreed(String breed){
    return animalRepository.getAnimalsByBreed(breed);
  }

  
  /**
   * Fetch all students with a GPA above a threshold.
   *
   * @param gpa the threshold
   * @return the list of matching Students
   */

   public Object getAgeOverTwo(double age){
    return animalRepository.getAgeOverTwo(age);
   }

  /**
   * Method to add a new student
   *
   * @param student The student to add
   */

   public Animal addAnimal(Animal animal){
    return animalRepository.save(animal);
   }

   /**
   * Method to update a student
   *
   * @param studentId The ID of the student to update
   * @param student   The updated student information
   */

   public Animal updateAnimal(Long dogId, Animal animal){
    return animalRepository.save(animal);
   }

 /**
   * Method to delete a student
   *
   * @param studentId The ID of the student to delete
   */

   public void deleteAnimal(Long dogId){
    animalRepository.deleteById(dogId);
   }

   /**
   * Method to write a student object to a JSON file
   *
   * @param student The student object to write
   */

   public String writeJson(Animal animal){
    ObjectMapper objectMapper = new ObjectMapper();
    try{
        objectMapper.writeValue(new File("animals.json"), animal);
        return "Animal written to JSON file successfully";
    }catch(IOException e){
        e.printStackTrace();
        return "Error writing animal to JSON file";
    }
   }


     /**
   * Method to read a student object from a JSON file
   *
   * @return The student object read from the JSON file
   */

   public Object readJson(){
    ObjectMapper objectMapper = new ObjectMapper();
    try{
        return objectMapper.readValue(new File("animal.json"), Animal.class);
    }catch (IOException e){
        e.printStackTrace();
        return null;
    }
   }

}

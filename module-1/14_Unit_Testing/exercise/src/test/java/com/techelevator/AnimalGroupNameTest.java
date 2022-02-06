package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {

    //Initializing AnimalGroupName for testing
    AnimalGroupName animalGroupName = new AnimalGroupName();

    @Test
    public void get_herd_works_with_all_lowercase_strings() {
        //Arrange
        String animal = "crow";
        String expected = "Murder";

        //Act
        String actual = animalGroupName.getHerd(animal);

        //Assert
        Assert.assertEquals("Did not get expected herd", expected, actual);
    }

    @Test public void get_herd_works_with_random_capital_letters() {
        //Arrange
        String animal = "gIRaFFe";
        String expected = "Tower";
        String animal2 = "FLAMINGO";
        String expected2 = "Pat";

        //Act
        String actual = animalGroupName.getHerd(animal);
        String actual2 = animalGroupName.getHerd(animal2);

        //Assert
        Assert.assertEquals("Did not get expected herd name", expected, actual);
        Assert.assertEquals("Did not get expected herd name", expected2, actual2);
    }

    @Test
    public void get_herd_works_with_empty_input() {
        //Arrange
        String animal = "";
        String expected = "unknown";

        //Act
        String actual = animalGroupName.getHerd(animal);

        //Assert
        Assert.assertEquals("Should return unknown for an empty string", expected, actual);
    }

    @Test
    public void get_herd_cannot_identify_unregistered_herd() {
        //Arrange
        String animal = "Fish";
        String expected = "unknown";

        //Act
        String actual = animalGroupName.getHerd(animal);

        //Assert
        Assert.assertEquals("This hashmap should not know the herd name of this animal", expected, actual);
    }

    @Test
    public void get_herd_works_with_null_input() {
        //Arrange
        String expected = "unknown";

        //Act
        String actual = animalGroupName.getHerd(null);

        //Assert
        Assert.assertEquals("Null values should return unknown", expected, actual);
    }
}

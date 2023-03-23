package org.example.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class  HumanBeing implements Comparable<HumanBeing>{
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    @JacksonXmlProperty
    private Coordinates coordinates; //Поле не может быть null

//    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    private Boolean realHero; //Поле не может быть null
    private Boolean hasToothpick; //Поле не может быть null
    private Double impactSpeed; //Значение поля должно быть больше -992, Поле может быть null
    private String soundtrackName; //Поле не может быть null
    private WeaponType weaponType; //Поле не может быть null
    private Mood mood; //Поле не может быть null
    @JacksonXmlProperty
    private Car car; //Поле может быть null


    public HumanBeing() {
    }

    public HumanBeing(Integer id, String name, Coordinates coordinates, ZonedDateTime creationDate, Boolean realHero, Boolean hasToothpick, Double impactSpeed, String soundtrackName, WeaponType weaponType, Mood mood, Car car) {
        Random random = new Random(new Date().getTime());
        this.id = id != null ? id : random.nextInt();
        this.name = name;
        this.coordinates = coordinates;
//        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }
    public HumanBeing(int id, String name, Coordinates coordinates, Boolean realHero, Boolean hasToothpick, Double impactSpeed, String soundtrackName, WeaponType weaponType, Mood mood, Car car) {
        this.id=id;
        this.name = name;
        this.coordinates = coordinates;

        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

//    public ZonedDateTime getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(ZonedDateTime creationDate) {
//        this.creationDate = creationDate;
//    }

    public Boolean getRealHero() {
        return realHero;
    }

    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }

    public Boolean getHasToothpick() {
        return hasToothpick;
    }

    public void setHasToothpick(Boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public Double getImpactSpeed() {
        return impactSpeed;
    }

    public void setImpactSpeed(Double impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public String getSoundtrackName() {
        return soundtrackName;
    }

    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: "+ id +" name: "+ name +" coordinates: "+ coordinates +" realHero: "+ realHero +" hasToothpicks: "+ hasToothpick +" impactSpeed: "+ impactSpeed +" soundtrackName: "+ soundtrackName +" weaponType: "+ weaponType +" moon: "+ mood +" car: "+ car;
    }



    @Override
    public int compareTo(HumanBeing o) {
        if (this.getName().length()>o.getName().length()){
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HumanBeing that = (HumanBeing) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(coordinates, that.coordinates) &&
                Objects.equals(realHero, that.realHero) && Objects.equals(hasToothpick, that.hasToothpick) &&
                Objects.equals(impactSpeed, that.impactSpeed) && Objects.equals(soundtrackName, that.soundtrackName) &&
                weaponType == that.weaponType && mood == that.mood && Objects.equals(car, that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, realHero, hasToothpick, impactSpeed, soundtrackName, weaponType, mood, car);
    }
}

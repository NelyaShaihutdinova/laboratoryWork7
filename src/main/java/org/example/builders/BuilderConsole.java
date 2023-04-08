//package org.example.builders;
//
//import org.example.entities.*;
//
//import java.util.Date;
//import java.util.Random;
//import java.util.Scanner;
//
//public class BuilderConsole {
//    private String newName;
//    private int newId;
//    private Coordinates newCoordinates;
//    private Boolean newRealHero;
//    private Boolean newHasToothpick;
//    private Double newImpactSpeed;
//    private String newSoundtrackName;
//    private Car newCar;
//    private WeaponType weaponType;
//    private Mood mood;
//
//
//    Scanner scanner = new Scanner(System.in);
//
//    public void setNewName(){
//        System.out.println("print name:");
//        String newName = scanner.nextLine();
//    }
//    public void setNewCoordinates(){
//        System.out.println("print x:");
//        Double newX = scanner.nextDouble();
//        System.out.println("print y:");
//        Integer newY = scanner.nextInt();
//        Coordinates newCoordinates = new Coordinates(newX, newY);
//
//    }
////    public void setNewY(){
////        System.out.println("print y:");
////        Integer newY = scanner.nextInt();
////    }
//    public void setNewRealHero(){
//        System.out.println("print realHero:");
//        Boolean newRealHero = scanner.nextBoolean();
//    }
//    public void setNewHasToothpick(){
//        System.out.println("print hasToothpicks:");
//        Boolean newHasToothpick = scanner.nextBoolean();
//    }
//    public void setNewImpactSpeed(){
//        System.out.println("print impactSpeed:");
//        Double newImpactSpeed = scanner.nextDouble();
//    }
//    public void setNewSoundtrackName(){
//        scanner.nextLine();
//        System.out.println("print soundtrackName:");
//        String newSoundtrackName = scanner.nextLine();
//    }
//    public void setNewCar(){
//        System.out.println("print cool:");
//        Boolean newCool = scanner.nextBoolean();
//        Car newCar = new Car(newCool);
//    }
//    public void setNewWeaponType(){
//        System.out.println("print WeaponType:");
//        Integer newWeaponType = scanner.nextInt();
//        WeaponType weaponType = WeaponType.fromInteger(newWeaponType);
//
//    }
//    public void setNewMood(){
//        System.out.println("print Mood:");
//        Integer newMood = scanner.nextInt();
//        Mood mood  = Mood.fromInteger(newMood);
//    }
//    public void setNewId(){
//        Random random = new Random(new Date().getTime());
//        int newId = random.nextInt();
//    }
//    public void createHuman(){
//        setNewName();
//        setNewCar();
//        setNewId();
//        setNewCoordinates();
//
//        setNewMood();
//        setNewHasToothpick();
//        setNewImpactSpeed();
//        setNewWeaponType();
//        setNewRealHero();
//        setNewSoundtrackName();
//        HumanBeing humanBeing = new HumanBeing(newId, newName, newCoordinates,  newRealHero, newHasToothpick, newImpactSpeed, newSoundtrackName, weaponType, mood, newCar);
//    }
////    Coordinates newCoordinates = new Coordinates(newX, newY);
////    Car newCar = new Car(newCool);
////    WeaponType weaponType = WeaponType.fromInteger(newWeaponType);
////    Mood mood  = Mood.fromInteger(newMood);
////    HumanBeing humanBeing = new HumanBeing(newId, newName, newCoordinates, newRealHero, newHasToothpick, newImpactSpeed, newSoundtrackName, weaponType, mood, newCar);
//}

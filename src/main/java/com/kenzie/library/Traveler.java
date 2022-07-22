package com.kenzie.library;

public class Traveler {
    //define properties
    protected String name;
    protected int food;
    protected boolean isHealthy;

    //define constructors
    public Traveler(){
        this.name = "";
        this.food = 1;
        this.isHealthy = true;
    }
    public Traveler(String name){
        this.name = name;
        this.food = 1;
        this.isHealthy = true;
    }

    //define methods


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public boolean getIsHealthy() {
        return isHealthy;
    }

    public void setIsHealthy(boolean healthy) {
        this.isHealthy = healthy;
    }
    public void hunt(){
        //increase the traveler's food by 2
        this.food +=2;
    }
    public void eat(){
        //consumes 1 unit of the traveler's food.
        //If traveler has no food, then traveler is no longer healthy
        if (this.food > 0){
            this.food -=1;
        }else {
            isHealthy = false;
        }
    }
}

class Doctor extends Traveler {
    //define properties--no properties
    //define constructors
    public Doctor(){
        super();
    }
    public Doctor(String name){
        super(name);
    }

    //define methods--no getter/setter
    public void heal(Traveler traveler){
        traveler.setIsHealthy(true);
    }
}

class Hunter extends Traveler {
    //define properties--none
    //define constructors
    public Hunter(){
        //hunter starts with 2 food
        super();
        this.food = 2;
    }
    public Hunter(String name){
        super(name);
        this.food = 2;
    }

    //define methods--no getter/setter
    public void hunt(){
        this.food += 5;
    }
    public void eat(){
        if (this.food >= 2){
            this.food -= 2;
        }else {
            this.food = 0;
            this.isHealthy = false;
        }
    }
    public void giveFood(Traveler traveler, int numOfFoodUnits){
        //hunter lose food--lose numOfFoodUnits
        if (this.food >= numOfFoodUnits){
            this.food -= numOfFoodUnits;
        }
        //traveler gains food--numOfFoodUnits
        traveler.food += numOfFoodUnits;
    }
}


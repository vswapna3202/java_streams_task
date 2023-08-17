package org.techreturners.data_models;

public record Car(Integer id, String make, String model, String colour, Integer year, Double price) {

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}

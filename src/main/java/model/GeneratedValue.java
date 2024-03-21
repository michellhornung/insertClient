package model;



import jakarta.persistence.GenerationType;

public @interface GeneratedValue {

	GenerationType strategy();

}

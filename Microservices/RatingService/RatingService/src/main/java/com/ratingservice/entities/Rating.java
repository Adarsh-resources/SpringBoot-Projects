package com.ratingservice.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.lang.annotation.Documented;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ratings")
//@Documented("user_ratings")
public class Rating {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratingId;

    @Column
    private String userId;

    @Column
    private String hotelId;

    @Column
    private int rating;

    @Column
    private String feedback;
}

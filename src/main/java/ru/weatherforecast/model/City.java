package ru.weatherforecast.model;

import javax.persistence.*;

@Entity
@Table(name = "City", schema = "public", catalog = "WeatherForecast")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nameLowerRegistry")
    private String nameLowerRegistry;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "url")
    private String url;
}

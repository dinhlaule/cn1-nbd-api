package com.example.quanlycacloaitramdo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tag;

    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "status")
    private String status;

    @Column(name = "code")
    private String code;

    @Column(name = "names")
    private String name;
    private String type;

}

package com.saqaya.demo.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USERS")
public class UserEntity implements Serializable {

    @Id
    @GenericGenerator(name = "user_id", strategy = "com.saqaya.demo.generator.UserIdGenerator")
    @GeneratedValue(generator = "user_id")
    @Column(name = "ID")
    private String id;

    @Basic
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Basic
    @Column(name = "LAST_NAME")
    private String lastName;

    @Basic
    @Column(name = "EMAIL")
    private String email;

    @Basic
    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Basic
    @Column(name = "MARKETING_CONSENT")
    private boolean marketingConsent;

}

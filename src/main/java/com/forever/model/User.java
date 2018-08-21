package com.forever.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private Integer userId;

    private String userName;

    private String password;

    private String phone;

}
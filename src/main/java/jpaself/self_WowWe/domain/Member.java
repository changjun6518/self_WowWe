package jpaself.self_WowWe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.PasswordAuthentication;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "Member_id")
    private Long id;

    private String email;
    private String password;

    private String nickname;
    private String provider;

    private int point;
    private boolean isCreator;
}

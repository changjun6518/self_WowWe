package jpaself.self_WowWe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class VideoTheme {

    @Id
    @GeneratedValue
    @Column(name = "videoTheme_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;


    // theme 별로 볼수 없으면... 이것도 entity?
    @Enumerated(EnumType.STRING)
    private Theme theme;
}

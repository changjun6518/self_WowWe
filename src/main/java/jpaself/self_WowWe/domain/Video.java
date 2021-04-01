package jpaself.self_WowWe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Video {

    @Id
    @GeneratedValue
    @Column(name = "video_id")
    private Long id;

    private String fileUrl;
    private String title;
    private String description;
    private boolean isLive;
    private LocalDateTime uploadTime;
    private String thumnailImg;
    private LocalDateTime duration;
    private LocalDateTime startTime;

}

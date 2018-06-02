package com.unesco.core.entities.journal;

import com.unesco.core.entities.schedule.Lesson;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="un_lesson_event")
public class LessonEvent {
    @Id
    @SequenceGenerator(name = "lessonEventSequenceGen", sequenceName = "lessonEventSequenceGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lessonEventSequenceGen")
    private long id;

    private Date date;

    private boolean everyDay;

    @ManyToOne
    @JoinColumn(name = "point_type_id", referencedColumnName = "id")
    private PointType type;

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    private Lesson lesson;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isEveryDay() {
        return everyDay;
    }
    public void setEveryDay(boolean everyDay) {
        this.everyDay = everyDay;
    }

    public PointType getType() {
        return type;
    }
    public void setType(PointType type) {
        this.type = type;
    }

    public Lesson getLesson() {
        return lesson;
    }
    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

}
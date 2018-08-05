package com.unesco.core.dto.journal;

import com.unesco.core.dto.shedule.LessonDTO;

import java.util.Date;

public class LessonEventDTO implements Cloneable {
    private long id;
    private Date date;
    private String comment;
    private PointTypeDTO type;
    private int maxValue;
    private LessonDTO lesson;

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

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public PointTypeDTO getType() {
        return type;
    }
    public void setType(PointTypeDTO type) {
        this.type = type;
    }

    public int getMaxValue() {
        return maxValue;
    }
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public LessonDTO getLesson() {
        return lesson;
    }
    public void setLesson(LessonDTO lesson) {
        this.lesson = lesson;
    }

    @Override
    public LessonEventDTO clone() {
        Object cloned = null;
        try {
            cloned = super.clone();
        } catch (CloneNotSupportedException exc) {
            // В данном примере недостижимо.
        }
        return (LessonEventDTO)cloned;
    }

}

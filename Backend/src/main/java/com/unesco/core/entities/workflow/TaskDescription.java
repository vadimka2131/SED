package com.unesco.core.entities.workflow;

import com.unesco.core.entities.account.UserEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="task_description")
public class TaskDescription {
    @Id
    @SequenceGenerator(name = "taskDescriptionSequenceGen", sequenceName = "taskDescriptionSequenceGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskDescriptionSequenceGen")
    private long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity creator;

    /*  FetchType.
        LAZY = Загрузит при обращении к полю этого класса
        EAGER = Загрузит сразу, при создании объекта этого класса
    */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taskDescription")
    private List<Task> subTasks;

    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getCreator() {
        return creator;
    }

    public void setCreator(UserEntity creator) {
        this.creator = creator;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

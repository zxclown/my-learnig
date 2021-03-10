package com.zxclown.learning.statemachine.bean;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

@Entity
@Table(name = "state_flow", uniqueConstraints = {@UniqueConstraint(columnNames = {"biz_no", "machine_id"})})
@Data
public class StateFlow implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "biz_no")
    private String bizNo;
    @Column(name = "state")
    private String state;
    @Column(name = "machine_id")
    private String machineId;
}

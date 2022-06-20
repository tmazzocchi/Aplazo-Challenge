package com.mazzocchitomas.simpleinterestmicroservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer responseId;
    private Integer paymentNumber;
    private Double amount;
    private LocalDate paymentDate;
    @ManyToOne
    @JoinColumn(name = "requestId")
    private Request request;
}

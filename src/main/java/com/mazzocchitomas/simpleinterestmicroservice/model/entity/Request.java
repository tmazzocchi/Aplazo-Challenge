package com.mazzocchitomas.simpleinterestmicroservice.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer requestId;
    private Double amount;
    private Integer terms;
    private Double rate;
    @OneToMany(mappedBy = "request", cascade = CascadeType.PERSIST)
    private List<Response> responseList;
}

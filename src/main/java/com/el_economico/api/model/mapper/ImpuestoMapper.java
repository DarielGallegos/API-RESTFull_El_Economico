package com.el_economico.api.model.mapper;

import com.el_economico.api.model.DTO.REQUEST.ImpuestoReq;
import com.el_economico.api.model.entity.Impuesto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImpuestoMapper {
    public List<ImpuestoReq> toImpuestoReq(List<Impuesto> list){
        return list.stream().map(this::toImpuestoReq).toList();
    }

    private ImpuestoReq toImpuestoReq(Impuesto e){
        return ImpuestoReq.builder()
                .ID(e.getID())
                .nombre(e.getNombre())
                .impuesto(e.getImpuesto())
                .build();
    }

}

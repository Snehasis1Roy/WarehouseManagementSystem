package com.example.warehouse.Mapper;

import com.example.warehouse.dto.request.RackRequest;
import com.example.warehouse.dto.response.RackResponse;
import com.example.warehouse.model.Rack;
import org.springframework.stereotype.Component;

@Component
public class RackMapper {

    public Rack toEntity(RackRequest source, Rack target) {
        target.setLength(source.length());
        target.setBredth(source.bredth());
        target.setHeight(source.height());
        return target;
    }

    public RackResponse toResponse(Rack rack) {
        return new RackResponse(
            rack.getRackId(),
            rack.getLength(),
            rack.getBredth(), // Note: RackResponse uses 'breadth', but Rack uses 'bredth'
            rack.getHeight()
        );
    }
}

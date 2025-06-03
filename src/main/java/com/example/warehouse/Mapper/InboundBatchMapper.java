package com.example.warehouse.Mapper;

import com.example.warehouse.dto.request.InboundBatchRequest;
import com.example.warehouse.dto.response.InboundBatchResponse;
import com.example.warehouse.model.InboundBatch;
import org.springframework.stereotype.Component;

@Component
public class InboundBatchMapper {

   public InboundBatch toEntity(InboundBatchRequest source, InboundBatch target) {
       target.setCountOfRejectedUnit(source.countOfRejectedUnit());
       target.setCountOfAcceptedUnit(source.countOfAcceptedUnit());
       return target;
   }

   public InboundBatchResponse toResponse(InboundBatch inboundBatch) {
       return new InboundBatchResponse(
           inboundBatch.getBatchCode(),
           inboundBatch.getCountOfRejectedUnit(),
           inboundBatch.getCountOfAcceptedUnit()
       );
   }
}

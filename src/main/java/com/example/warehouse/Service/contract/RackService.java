package com.example.warehouse.Service.contract;

import com.example.warehouse.dto.request.RackRequest;
import com.example.warehouse.dto.response.RackResponse;

public interface RackService {
     RackResponse createNewRack(RackRequest rackRequest,String blockId );

}

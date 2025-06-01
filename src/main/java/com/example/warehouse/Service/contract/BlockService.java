package com.example.warehouse.Service.contract;

import com.example.warehouse.dto.request.BlockRequest;
import com.example.warehouse.dto.response.BlockResponse;

public interface BlockService {
    BlockResponse createNewBlock(BlockRequest blockRequest,String roomId);
}

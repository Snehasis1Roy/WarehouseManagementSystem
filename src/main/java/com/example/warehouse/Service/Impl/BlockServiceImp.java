package com.example.warehouse.Service.Impl;

import com.example.warehouse.Mapper.BlockMapper;
import com.example.warehouse.Repositery.BlockRepo;
import com.example.warehouse.Repositery.RoomRepo;
import com.example.warehouse.Service.contract.BlockService;
import com.example.warehouse.dto.request.BlockRequest;
import com.example.warehouse.dto.response.BlockResponse;
import com.example.warehouse.exception.blockHandler.UnSupportedBlockType;
import com.example.warehouse.exception.blockHandler.RoomsByIdNotFound;
import com.example.warehouse.model.Block;
import com.example.warehouse.model.RackedBlock;
import com.example.warehouse.model.Rooms;
import com.example.warehouse.model.UnrackedBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlockServiceImp implements BlockService {

    @Autowired
    private BlockRepo blockRepo;

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private BlockMapper blockMapper;

    @Transactional
    @Override
    public BlockResponse createNewBlock(BlockRequest blockRequest, String roomId) {
        Rooms Rm= roomRepo.findById(roomId).orElseThrow(()-> new RoomsByIdNotFound("Room with this is are not found "));
        Block block = switch (blockRequest.type()){
            case RACKED -> blockMapper.toEntity(blockRequest,new RackedBlock());
            case UNRACKED -> blockMapper.toEntity(blockRequest,new UnrackedBlock());
            default -> throw new UnSupportedBlockType(blockRequest.type()+" Not Supported!");
        };
            block.setRooms(Rm);
            roomRepo.save(Rm);
            blockRepo.save(block);
            return blockMapper.toResponse(block);
    }
}

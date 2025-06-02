package com.example.warehouse.Service.Impl;

import com.example.warehouse.Mapper.RackMapper;
import com.example.warehouse.Repositery.BlockRepo;
import com.example.warehouse.Repositery.RackRepo;
import com.example.warehouse.Service.contract.RackService;
import com.example.warehouse.dto.request.RackRequest;
import com.example.warehouse.dto.response.RackResponse;
import com.example.warehouse.exception.BlockNotFoundByIdException;
import com.example.warehouse.exception.RackBlockNotCreatedException;
import com.example.warehouse.model.Block;
import com.example.warehouse.model.Rack;
import com.example.warehouse.model.RackedBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RackServiceImpl implements RackService {
    @Autowired
    private RackRepo rackRepo;
    @Autowired
    private BlockRepo blockRepo;
    @Autowired
    private RackMapper rackMapper;


    @Override
    public RackResponse createNewRack(RackRequest rackRequest,String blockID) {
        Block block= blockRepo.findById(blockID).orElseThrow(()-> new BlockNotFoundByIdException("Block With this Id is Not Present In Db"));
        Rack rack=null;
        if(block instanceof RackedBlock rackedBlock){
            rack= rackMapper.toEntity(rackRequest,new Rack());
            rack.setRackedBlock(rackedBlock);
            blockRepo.save(rackedBlock);
            rackRepo.save(rack);
        }
        else
            throw new RackBlockNotCreatedException("Racks cannot be created in the blocks");


        return null;
    }
}

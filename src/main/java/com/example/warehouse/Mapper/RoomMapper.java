package com.example.warehouse.Mapper;

import com.example.warehouse.dto.request.RoomRequest;
import com.example.warehouse.dto.response.RoomResponse;
import com.example.warehouse.model.Rooms;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

  public Rooms toEntity(RoomRequest source, Rooms target) {
      if (source != null && target != null) {
          target.setRoomName(source.roomName());
      }
      return target;
  }

  public RoomResponse toResponse(Rooms rooms) {
      if (rooms == null) return null;
      return new RoomResponse(
          rooms.getRoomId(),
          rooms.getRoomName()
      );
  }
}

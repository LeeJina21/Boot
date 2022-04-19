package kopo.poly.service;

import kopo.poly.dto.RedisDTO;

import java.util.List;
import java.util.Set;

public interface IMyRedisService {
    /**
     * String 타입 저장하기
     */
    int saveRedisString() throws Exception;

    /**
     * String 타입 가져오기
     */
    RedisDTO getRedisString() throws Exception;


    /**
     * String 타입 가져오기
     */
    int saveRedisStringJSON() throws Exception;
}

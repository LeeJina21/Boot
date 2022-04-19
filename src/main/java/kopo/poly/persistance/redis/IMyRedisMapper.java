package kopo.poly.persistance.redis;

import kopo.poly.dto.RedisDTO;

import java.util.List;
import java.util.Set;

public interface IMyRedisMapper {
    /**
     * String 타입 저장하기
     */

    int saveRedisString(String redisKey, RedisDTO pDTO) throws Exception;

    /**
     * String 타입 가져오기
     */
    RedisDTO getRedisString(String redisKey) throws Exception;


    /**
     * String 타입에 JSON 형태로 저장
     */
    int saveRedisStringJSON(String redisKey, RedisDTO pDTO) throws Exception;
}

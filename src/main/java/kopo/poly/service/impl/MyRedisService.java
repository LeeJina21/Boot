package kopo.poly.service.impl;

import kopo.poly.dto.RedisDTO;
import kopo.poly.persistance.redis.IMyRedisMapper;
import kopo.poly.service.IMyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Slf4j
@Service("MyRedisService")
public class MyRedisService implements IMyRedisService {
    @Resource(name="MyRedisMapper")
    private IMyRedisMapper myRedisMapper;

    @Override
    public int saveRedisString() throws Exception{
        log.info(this.getClass().getName() + ".saveRedisString 시작");

        String redisKey="myRedis_String";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setTest_text("난 String타입으로 지정할 일반 문자열이다!!!");

        int res = myRedisMapper.saveRedisString(redisKey, pDTO);

        log.info(this.getClass().getName() + ".saveRedisString 끝");

        return res;
    }

    @Override
    public RedisDTO getRedisString() throws Exception{
        log.info(this.getClass().getName() + ".etRedisString 시작");

        String redisKey = "myRedis_String";

        RedisDTO rDTO = myRedisMapper.getRedisString(redisKey);

        if(rDTO == null){
            rDTO = new RedisDTO();
        }

        log.info(this.getClass().getName() + ".etRedisString 끝");

        return rDTO;
    }


    @Override
    public int saveRedisStringJSON() throws Exception{
        log.info(this.getClass().getName() + ".etRedisStringJSON 시작");

        String redisKey = "myRedis_String_JSON";

        RedisDTO pDTO = new RedisDTO();
        pDTO.setTest_text("난 Strint타입에 JSON 구조로 저장할 일반 문자열");
        pDTO.setName("이진아");
        pDTO.setAddr("경기도");
        pDTO.setEmail("JNA@naver.com");

        int res = myRedisMapper.saveRedisStringJSON(redisKey, pDTO);

        log.info(this.getClass().getName() + ".etRedisStringJSON 끝");

        return res;
    }

}

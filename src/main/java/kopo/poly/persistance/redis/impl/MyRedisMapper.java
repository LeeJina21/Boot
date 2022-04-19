package kopo.poly.persistance.redis.impl;

import kopo.poly.dto.RedisDTO;
import kopo.poly.persistance.redis.IMyRedisMapper;
import kopo.poly.util.CmmUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component("MyRedisMapper")
public class MyRedisMapper implements IMyRedisMapper {
    public final RedisTemplate<String, Object> redisDB;

    public MyRedisMapper(RedisTemplate<String, Object> redisDB) {
        this.redisDB = redisDB;
    }

    @Override
    public int saveRedisString(String redisKey, RedisDTO pDTO)throws Exception{
        log.info(this.getClass().getName() + ".saveRedisString 시작");

        int res=0;

        String saveData = CmmUtil.nvl(pDTO.getTest_text());

        /*
         저장 및 읽기에 대한 데이터 타입 지정 string타입으로 지정
         */
        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new StringRedisSerializer());


        if (!redisDB.hasKey(redisKey)) {
            //데이터 저장하기
            redisDB.opsForValue().set(redisKey, saveData);

            //
            // 2일이 자니면, 자동으로 데이터가 삭제되도록 설정함
            redisDB.expire(redisKey, 2, TimeUnit.DAYS);

            log.info("Save Data");
            res = 1;
        }

        log.info(this.getClass().getName() + ".saveRedisString 끝");

        return res;
    }

    @Override
    public RedisDTO getRedisString(String redisKey)throws Exception{

        log.info(this.getClass().getName() + ".saveRedisString 시작");

        log.info("String redisKey : " + redisKey);
        RedisDTO rDTO = new RedisDTO();
        /*
        redis 저장 및
         */
        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new StringRedisSerializer());

        if(redisDB.hasKey(redisKey)){
            String res = (String) redisDB.opsForValue().get(redisKey);

            log.info("res : " + res);

            //RedisDB에 저장된 데이터를 DTO에 저장하기
            rDTO.setTest_text(res);
        }

        log.info(this.getClass().getName() + ".saveRedisString 끝");

        return rDTO;
    }

    @Override
    public int saveRedisStringJSON(String redisKey, RedisDTO pDTO)throws Exception{
        log.info(this.getClass().getName() + ".saveRedisStringJSON 시작");

        int res=0;

        redisDB.setKeySerializer(new StringRedisSerializer());
        redisDB.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisDTO.class));

        if(!redisDB.hasKey(redisKey)){
            redisDB.opsForValue().set(redisKey, pDTO);

            redisDB.expire(redisKey, 2, TimeUnit.DAYS);

            log.info("Save Data");
            res=1;
        }


        log.info(this.getClass().getName() + ".saveRedisStringJSON 끝");

        return res;
    }
}

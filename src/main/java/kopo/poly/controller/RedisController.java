package kopo.poly.controller;

import kopo.poly.dto.RedisDTO;
import kopo.poly.service.IMyRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
public class RedisController {
    @Resource(name="MyRedisService")
    private IMyRedisService myRedisService;

    /**
     * Redis 문자열 저장 실습
     */
    @GetMapping(value = "redis/saveRedisString")
    public String saveRedisString() throws Exception{

        log.info(this.getClass().getName() + ".saveRedisString 시작");

        //수집 결과 출력
        String msg;

        int res = myRedisService.saveRedisString();

        if(res==1){
            msg ="success";
        }else{
            msg="fail";
        }

        log.info(this.getClass().getName() + ".saveRedisString 끝");

        return msg;
    }

    /**
     * Redis 문자열 저장된 값 가져오기
     */
    @GetMapping(value = "redis/getRedisString")
    public RedisDTO getRedisString() throws Exception{
        log.info(this.getClass().getName() + ".getRedisString 시작");

        RedisDTO rDTO = myRedisService.getRedisString();

        log.info(this.getClass().getName() + ".getRedisString 끝");

        return rDTO;
    }


    /**
     * JSON 저장 실습
     *
     */
    @GetMapping(value = "redis/saveRedisStringJSON")
    public String saveRedisStringJSON() throws Exception{
        log.info(this.getClass().getName() + ".getRedisStringJSON 시작");

        String msg;

        int res = myRedisService.saveRedisStringJSON();

        if(res==1){
            msg="success";
        }else{
            msg = "fail";
        }

        log.info(this.getClass().getName() + ".getRedisStringJSON 끝");

        return msg;
    }



}

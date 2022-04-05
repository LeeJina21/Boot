package kopo.poly.service;

import kopo.poly.dto.MelonDTO;

import java.util.List;

public interface IMelonService {


    /**
     * 멜론 노래 리스트 저장하기
     */
    int collectMelonSong() throws Exception;

    /**
     * 멜론 노래 한번에 저장하기
     */
    int collectMelonSongMany() throws Exception;

    /**
     * 오늘 수집된 멜론 노래리스트 가져오기
     */
    List<MelonDTO> getSongList() throws Exception;

    /* ??? */
    List<MelonDTO> getSingerSong() throws Exception;
    /**
     * 멜론 가수별 노래 수 가져오기
     */
    List<MelonDTO> getSingerSongCnt() throws Exception;


    /**
     * 가수의 노래 삭제하기
     */
    int deleteSong() throws Exception;

    /**
     * singer 필드의 값인 방탄소년단을 BTS로 변경하기
     */
    int updateBTSName() throws Exception;

    /**
     * BTS 노래마다 nickname 필드를 추가하고, 그 필드에 BTS 저장하기
     * @return
     * @throws Exception
     */
    int updateAddBTSNickname() throws Exception;

    /**
     * BTS 멤퍼 추가
     */
    int updateAddBTSMember() throws Exception;
}

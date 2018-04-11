package com.rpc.dubbo.provider.impl;

import com.rpc.dubbo.api.dthrift.*;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service("searchServiceThriftImpl")
public class SearchServiceThriftImpl implements SearchThriftProvider.Iface{
    private static final Logger logger = LoggerFactory.getLogger(SearchServiceThriftImpl.class);


    @Override
    public SearchMoviePersonResultDto searchMoviePerson(boolean normalValidState, String key, int startIndex, int count) throws TException {
        try{
            logger.warn(">>>>>>>>>thriftapi:searchMoviePerson received");
            SearchMoviePersonResultDto resultDto = new SearchMoviePersonResultDto();
            resultDto.setStartIndex(1);
            resultDto.setHasMore(1);
            resultDto.setTotalCount(100);

            List<MoviePersonDataDto> personDataDtoList = new ArrayList<>();

            MoviePersonInfoVo moviePersonInfo = new MoviePersonInfoVo();
            moviePersonInfo.setAddress("海珠区扛把子");
            moviePersonInfo.setBirthday("20081010");
            MoviePersonStatDataVo statData = new MoviePersonStatDataVo();
            statData.setGainAwardNumIsSet(true);
            statData.setGainAwardNum(234);
            MoviePersonDataDto personDataDto = new MoviePersonDataDto();
            personDataDto.setMoviePersonInfo(moviePersonInfo);
            personDataDto.setStatData(statData);
            personDataDtoList.add(personDataDto);
            resultDto.setMoviePersonDataDtoList(personDataDtoList);
            return resultDto;
        }catch (Exception e){
            throw new TException(e);
        }
    }

    @Override
    public String ping() throws TException {
        return "pong:"+ Instant.now();
    }

    @Override
    public MoviePersonInfoVo getMoviePersonInfo(int id) throws TException {
        MoviePersonInfoVo moviePersonInfo = new MoviePersonInfoVo();
        moviePersonInfo.setAddress("海珠区扛把子");
        moviePersonInfo.setBirthday("20081010");
        return moviePersonInfo;
    }

    @Override
    public List<MoviePersonInfoVo> getMoviePersonInfoList(int id) throws TException {
        List<MoviePersonInfoVo> list = new ArrayList<>();
        MoviePersonInfoVo moviePersonInfo = new MoviePersonInfoVo();
        moviePersonInfo.setAddress("海珠区扛把子");
        moviePersonInfo.setBirthday("20081010");
        list.add(moviePersonInfo);
        MoviePersonInfoVo moviePersonInfo2 = new MoviePersonInfoVo();
        moviePersonInfo2.setAddress("天河区扛把子");
        moviePersonInfo2.setBirthday("20081110");
        list.add(moviePersonInfo2);
        return list;
    }

    @Override
    public MoviePerson getMoviePerson(int id) throws TException {
        MoviePerson moviePerson = new MoviePerson();
        moviePerson.setId(11);
//        List<MoviePersonStatDataVo> list =new ArrayList<MoviePersonStatDataVo>();

//        MoviePersonStatDataVo vo = new MoviePersonStatDataVo();
//        vo.setGainAwardNum(100);
//        vo.setImageNum(233);
//        list.add(vo);
//
//        MoviePersonStatDataVo vo2 = new MoviePersonStatDataVo();
//        vo2.setGainAwardNum(100);
//        vo2.setImageNum(233);
//        list.add(vo2);

        List<MoviePersonDataDto> personDataDtoList = new ArrayList<>();

        MoviePersonInfoVo moviePersonInfo = new MoviePersonInfoVo();
        moviePersonInfo.setAddress("海珠区扛把子");
        moviePersonInfo.setBirthday("20081010");
        MoviePersonStatDataVo statData = new MoviePersonStatDataVo();
        statData.setGainAwardNumIsSet(true);
        statData.setGainAwardNum(234);
        MoviePersonDataDto personDataDto = new MoviePersonDataDto();
        personDataDto.setMoviePersonInfo(moviePersonInfo);
        personDataDto.setStatData(statData);
        personDataDtoList.add(personDataDto);

        moviePerson.setStatDataList(personDataDtoList);
        return moviePerson;
    }

    @Override
    public SearchMoviePersonResultDto getMoviePersonAll(int id) throws TException {
        return searchMoviePerson(  true,  "",  1,  1);
    }
}

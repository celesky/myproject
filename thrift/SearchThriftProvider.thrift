namespace java com.youhaoxi.soa.search.api.thrift

service SearchThriftProvider {
	//SearchMoviePersonResultDto searchMoviePerson(1:required bool normalValidState,2:required string key,3:required i32 startIndex,4:required i32 count ),
	SearchMoviePersonResultDto searchMoviePerson(1:required string normalValidState,2:required string key,3:required i32 startIndex,4:required i32 count  ),
	string ping(),
    MoviePersonInfoVo getMoviePersonInfo(1:required i32 id);
    list<MoviePersonInfoVo> getMoviePersonInfoList(1:required i32 id);
    MoviePerson getMoviePerson(1:required i32 id);
    SearchMoviePersonResultDto getMoviePersonAll(1:required i32 id);
}

struct MoviePerson {
    1: optional i32 id;
    2: optional list<MoviePersonDataDto> statDataList;
}

struct MoviePersonDataDto {

    1: optional MoviePersonInfoVo moviePersonInfo;

    2: optional MoviePersonStatDataVo statData;
}
struct MoviePersonInfoVo {

    1: optional i32 id;

    2: optional string name;

    3: optional string img;

    4: optional i32 sex;

    5: optional string birthday;

    6: optional string deathday;

    7: optional double rating;

    8: optional string intro;

    9: optional string address;

    10: optional string profession;

    11: optional string constellation;

    12: optional i32 validState;
    }
struct MoviePersonStatDataVo {

    1: optional i32 gainAwardNum;

    2: optional i32 nominationAwardNum;

    3: optional i32 joinMovieNum;

    4: optional i32 imageNum;
    }
struct SearchMoviePersonResultDto {

    1: optional i32 startIndex;

    2: optional i32 hasMore;

    3: optional i32 totalCount;

    4: optional list<MoviePersonDataDto> moviePersonDataDtoList;
    }

package com.jvm.generic;

public class Util {

//    public static <T extends BaseAnalysisResultBean> T getLongestNightSleepDto(List<T> sleepList){
//        if(sleepList==null){
//            return null;
//        }
//        if(sleepList.size()==1){
//            //只有一条的情况 直接返回这一条
//            T e = sleepList.get(0);
//
//            if(isNightSleep(e)){
//                e.setNightSleep(true);
//            }
//            return e;
//        }
//        //取最长一条
//        optional<T> optional = sleepList.stream()
//                .filter(e->isNightSleep(e))
//                .max(Comparator.comparingInt(T::getTotalSleepTime))
//                .map(e->e.setNightSleep(true));
//        if(optional.isPresent()){
//            //有夜间睡眠则返回最长的夜间睡眠
//            return optional.get();
//        }else{
//            optional = sleepList.stream()
//                    .max(Comparator.comparingInt(T::getTotalSleepTime))
//                    .map(e->e.setNightSleep(true));
//            return optional.orElse(null);
//        }
//
//    }

    /**
     * 夜间睡眠 返回true
     * @param sleepDto
     * @return
     */
//    public static boolean isNightSleep(BaseAnalysisResultBean sleepDto){
//        //睡眠所属日期
//        String sleepDateStr = getBelongDateStr(sleepDto.getAwakeningTime());
//        Date nightBegin = DateUtils.parseDate(sleepDateStr+" 01:00:00",DateUtils.TIMESTAMP_PATTERN);
//        Date nightEnd = DateUtils.parseDate(sleepDateStr+" 06:00:00",DateUtils.TIMESTAMP_PATTERN);
//
//        if(sleepDto.getSleepTime().getTime()<nightBegin.getTime()&&sleepDto.getAwakeningTime().getTime()>nightEnd.getTime()){
//            return true;
//        }
//
//        if(sleepDto.getAwakeningTime().getTime()>nightBegin.getTime()&&sleepDto.getAwakeningTime().getTime()<nightEnd.getTime()){
//            return true;
//        }
//        if(sleepDto.getSleepTime().getTime()>nightBegin.getTime()&&sleepDto.getSleepTime().getTime()<nightEnd.getTime()){
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * @param measurementDate
//     * @return
//     */
//    public static String getBelongDateStr(Date measurementDate){
////        Date beginDate = getRecordBeginDate(measurementDate);
////        Date currentDate = getDayOfYear(beginDate, 1, 0, 0, 0);//记录所属的日期
//        String currentDateStr = DateUtils.format(measurementDate, "yyyy-MM-dd");//转换成年月日
//        return currentDateStr;
//    }
}

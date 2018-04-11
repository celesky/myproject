package com.rpc.dubbo.consumer;

import com.rpc.dubbo.api.*;
import com.rpc.dubbo.api.dthrift.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

//import com.provider.user.UserService;

public class DemoConsumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/spring.xml"});
        context.start();
        HelloServiceProvider helloService = (HelloServiceProvider) context.getBean(HelloServiceProvider.class);
        String dubboMsg = helloService.hello();
        System.out.println("dubbo:"+dubboMsg);

        ThriftApiProvider.Iface thriftService = (ThriftApiProvider.Iface) context.getBean(ThriftApiProvider.Iface.class);
        String thirftMsg = thriftService.hello("jack");
        System.out.println("dthrift:"+thirftMsg);

        SearchThriftProvider.Iface searchThriftService = (SearchThriftProvider.Iface) context.getBean(SearchThriftProvider.Iface.class);
        String pong = searchThriftService.ping();

        System.out.println("dthrift ping = " + pong);

        MoviePersonInfoVo personInfoVo = searchThriftService.getMoviePersonInfo(1);
        System.out.println("personInfoVo = " + personInfoVo.toString());

        List<MoviePersonInfoVo> list = searchThriftService.getMoviePersonInfoList(1);
        list.stream().forEach(System.out::println);

        MoviePerson moviePerson = searchThriftService.getMoviePerson(11);
        System.out.println("moviePerson = " + moviePerson.toString());

        for(int i=0;i<1000;i++){
            SearchMoviePersonResultDto dto2 = searchThriftService.getMoviePersonAll(11);
            System.out.println("moviePerson = " + dto2.toString());
        }



        SearchMoviePersonResultDto dto = searchThriftService.searchMoviePerson(true,"",1,1);
        System.out.println("dto = " + dto.toString());
//        for (int i = 0; i < 1000; i++) {
//            try{
//                String dubboMsg = helloService.hello();
//                System.out.println(dubboMsg);
//                Thread.sleep(2000);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
////            try {
////                String thriftMsg = thriftService.hello("tom");
////                System.out.println(thriftMsg);
////                Thread.sleep(2000);
////            } catch (Exception e) {
////                System.out.println("thriftService error");
////            }
//
//        }


        //动态传入ConsumerClient.class这个类，让spring去生产这个类的对象
//        AutowireCapableBeanFactory defaultBeanFactory = context.getAutowireCapableBeanFactory();
//        ConsumerClient client = ServiceExporter.createSpringBean((DefaultListableBeanFactory)defaultBeanFactory,ConsumerClient.class);
//        client.test();

    }


}

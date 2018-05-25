package com.sede.fst;

import com.alibaba.fastjson.JSON;
import com.redis.RedisUtil;
import java.util.ArrayList;
import java.util.List;

public class Demo {


    public static void main(String[] args) {
        Demo.se();
        Demo.de();

        

    }

    public static void de(){
        byte[] bytes = RedisUtil.jedis.get("mybean".getBytes());
        User user = Util.unserialize(bytes);
        List<User> users = user.getSons();
        System.out.println("users = " + users);
        String json = JSON.toJSONString(user);
        System.out.println("json = " + json);
    }

    public static void se(){
        User son1 = new User();
        son1.setUserName("son1");
        son1.setPassword("123456");
        son1.setAge(1000000);

        User son2 = new User();
        son2.setUserName("son2");
        son2.setPassword("123456");
        son2.setAge(1000000);

        User son3 = new User();
        son3.setUserName("son3");
        son3.setPassword("123456");
        son3.setAge(1000000);

        List<User> list  = new ArrayList<>();
        list.add(son1);
        list.add(son2);
        list.add(son3);

        User bean = new User();
        bean.setUserName("xxxxx");
        bean.setPassword("123456");
        bean.setAge(1000000);
        bean.setSons(list);

        byte[] bytes = Util.serialize(bean);
        String json = JSON.toJSONString(bean);
        System.out.println("json = " + json);
        System.out.println("fst 序列化 bytes length:" + bytes.length);
        RedisUtil.jedis.set("mybean".getBytes(),bytes);


        System.out.println("fastjson 序列化 bytes length:" + json.getBytes().length);
    }
    static class User{
        String userName;
        String password;
        Integer age;
        String hobby="打篮球 打羽毛球 打乒乓球 精通电脑开关机 word文档开关机,玩蛇 等极限操作";
        String intro="影片故事承接上一集，钢铁侠研发的一个维和项目意外成为危机导火索，本来用于保护世界的奥创机器人却拥有了自我意识，扭曲的信念导致它掀起了一场意图灭绝人类的邪恶攻势。超级英雄们——钢铁侠、美国队长、雷神、绿巨人、黑寡妇和鹰眼等面临着又一次艰巨考验，他们更因为各自理念发生争执，内部矛盾使得复仇者联盟几近分崩离析。随着奥创崛起，复仇者联盟必须重新站在一起面对前所未有的强大劲敌；一场遍布全球、独一无二的史诗冒险就此展开！";
        List<User> sons;
        //String love;

        public String getUserName() {
            return userName;
        }

        public User setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public User setPassword(String password) {
            this.password = password;
            return this;
        }

        public Integer getAge() {
            return age;
        }

        public User setAge(Integer age) {
            this.age = age;
            return this;
        }

        public List<User> getSons() {
            return sons;
        }

        public User setSons(List<User> sons) {
            this.sons = sons;
            return this;
        }

        public String getHobby() {
            return hobby;
        }

        public User setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public String getIntro() {
            return intro;
        }

        public User setIntro(String intro) {
            this.intro = intro;
            return this;
        }

//        public String getLove() {
//            return love;
//        }
//
//        public User setLove(String love) {
//            this.love = love;
//            return this;
//        }
    }
}

package com.sizeofobject.cao;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by pan on 2017/4/17.
 */
public class UserEntity implements Serializable{

    private Long id;

    /**
     * 运营商编码
     */
    private String carrierCode;

    /**
     * 乐心号
     */
    private String lifesenseId;

    /**
     * 姓名
     */
    private String name;

//    /**
//     * 头像
//     */
//    private String headImg;
//
//    /**
//     * 性别：男=1；女=2
//     */
//    private Integer sex;
//
//    /**
//     * 出生日期
//     */
//    private Date birthday;
//
//    /**
//     * 邮箱
//     */
//    private String email;
//
//    /**
//     * 手机号码
//     */
//    private String mobile;
//
//    /**
//     * 身份证号
//     */
//    private String idcard;
//
//    /**
//     * 社保号
//     */
//    private String insuranceId;
//
//    /**
//     * 身高（单位：cm）
//     */
//    private Double height;
//
//    /**
//     * 腰围（单位：cm）
//     */
//    private Double waist;
//
//    /**
//     * 微信UnionId
//     */
//    private String wechatUnionId;
//
//    /**
//     * 创建时间
//     */
//    private Date created;
//
//    private String appVersion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取运营商编码
     *
     * @return carrier_code - 运营商编码
     */
    public String getCarrierCode() {
        return carrierCode;
    }

    /**
     * 设置运营商编码
     *
     * @param carrierCode 运营商编码
     */
    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    /**
     * 获取乐心号
     *
     * @return lifesense_id - 乐心号
     */
    public String getLifesenseId() {
        return lifesenseId;
    }

    /**
     * 设置乐心号
     *
     * @param lifesenseId 乐心号
     */
    public void setLifesenseId(String lifesenseId) {
        this.lifesenseId = lifesenseId;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }




}

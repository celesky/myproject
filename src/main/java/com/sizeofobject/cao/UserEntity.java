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

    /**
     * 获取头像
     *
     * @return head_img - 头像
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 设置头像
     *
     * @param headImg 头像
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    /**
     * 获取性别：男=1；女=2
     *
     * @return sex - 性别：男=1；女=2
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别：男=1；女=2
     *
     * @param sex 性别：男=1；女=2
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取出生日期
     *
     * @return birthday - 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置出生日期
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号码
     *
     * @return mobile - 手机号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取身份证号
     *
     * @return idcard - 身份证号
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置身份证号
     *
     * @param idcard 身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 获取社保号
     *
     * @return insurance_id - 社保号
     */
    public String getInsuranceId() {
        return insuranceId;
    }

    /**
     * 设置社保号
     *
     * @param insuranceId 社保号
     */
    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    /**
     * 获取身高（单位：cm）
     *
     * @return height - 身高（单位：cm）
     */
    public Double getHeight() {
        return height;
    }

    /**
     * 设置身高（单位：cm）
     *
     * @param height 身高（单位：cm）
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * 获取腰围（单位：cm）
     *
     * @return waist - 腰围（单位：cm）
     */
    public Double getWaist() {
        return waist;
    }

    /**
     * 设置腰围（单位：cm）
     *
     * @param waist 腰围（单位：cm）
     */
    public void setWaist(Double waist) {
        this.waist = waist;
    }

    /**
     * 获取微信UnionId
     *
     * @return wechat_unionid - 微信UnionId
     */
    public String getWechatUnionId() {
        return wechatUnionId;
    }

    /**
     * 设置微信UnionId
     *
     * @param wechatUnionId 微信UnionId
     */
    public void setWechatUnionId(String wechatUnionId) {
        this.wechatUnionId = wechatUnionId;
    }

    /**
     * 获取创建时间
     *
     * @return created - 创建时间
     */
    public Date getCreated() {
        return created;
    }

    /**
     * 设置创建时间
     *
     * @param created 创建时间
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }




}

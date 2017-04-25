package com.sizeofobject.cao;

/**
 * Created by pan on 2017/4/17.
 */
public class SyncObject extends BaseEntity {
    /**
     * 更新时间戳
     */
    private Long updated = System.currentTimeMillis();

    /**
     * 客户端ID
     */
    private String clientId;

    /**
     * 删除标识
     */
    private boolean deleted = false;

    /**
     * 获取更新时间戳
     *
     * @return updated - 更新时间戳
     */
    public Long getUpdated() {
        return updated;
    }

    /**
     * 设置更新时间戳
     *
     * @param updated 更新时间戳
     */
    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    /**
     * 获取客户端ID
     *
     * @return client_id - 客户端ID
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * 设置客户端ID
     *
     * @param clientId 客户端ID
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * 获取删除标识
     * @return
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * 设置删除标识
     *
     * @param deleted 是否删除
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}


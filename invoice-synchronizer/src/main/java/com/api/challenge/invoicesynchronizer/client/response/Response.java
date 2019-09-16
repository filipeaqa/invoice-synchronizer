package com.api.challenge.invoicesynchronizer.client.response;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    private Status status;
    private List<Data> data;
    private Page page;

    private Integer count;

    private String signature;

    public Response() {
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Data> getData() {
        return data;
    }
    public void setData(List<Data> data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }
    public void setPage(Page page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", data=" + data +
                ", page=" + page +
                ", count=" + count +
                ", signature='" + signature + '\'' +
                '}';
    }
}

package com.api.challenge.invoicesynchronizer.client.response;

import java.net.URL;

public class Page {

    private URL next;
    private URL previous;

    public Page(URL next, URL previous) {
        this.next = next;
        this.previous = previous;
    }

    public URL getNext() {
        return next;
    }

    public URL getPrevious() {
        return previous;
    }

    @Override
    public String toString() {
        return "Page{" +
                "next=" + next +
                ", previous=" + previous +
                '}';
    }
}

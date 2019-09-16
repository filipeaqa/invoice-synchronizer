package com.api.challenge.invoicesynchronizer.mapper.xml;

import javax.xml.bind.annotation.XmlElement;

public class ICMSTot {

  public ICMSTot() {}

  private Double vNf;
  public Double getvNf() {
    return vNf;
  }

  @XmlElement(name = "vNF")
  public void setvNf(final Double vNf) {
    this.vNf = vNf;
  }
}

package com.api.challenge.invoicesynchronizer.mapper;

import com.api.challenge.invoicesynchronizer.mapper.xml.NFe;
import com.api.challenge.invoicesynchronizer.mapper.xml.NfeProc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

class XmlConverterHelper {

    static NfeProc xmlToNfeProc(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(NfeProc.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (NfeProc) jaxbUnmarshaller.unmarshal(new StringReader(xml));
    }

    static NFe xmlToNfe(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(NFe.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (NFe) jaxbUnmarshaller.unmarshal(new StringReader(xml));
    }
}
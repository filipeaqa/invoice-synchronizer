package com.api.challenge.invoicesynchronizer.mapper;

import com.api.challenge.invoicesynchronizer.client.response.Data;
import com.api.challenge.invoicesynchronizer.entity.InvoiceEntity;
import com.api.challenge.invoicesynchronizer.mapper.xml.NFe;
import com.api.challenge.invoicesynchronizer.mapper.xml.NfeProc;
import org.springframework.util.Base64Utils;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceMapper {

    private static InvoiceEntity invoiceDataToInvoiceEntity(Data invoiceData) throws JAXBException {
        String xmlString = base64ToXmlString(invoiceData.getXml());
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setInvoiceKey(invoiceData.getAccess_key());

        String xmlPrefix = xmlString.substring(0,6);

        switch (xmlPrefix) {
            case "<NFe x":
                NFe nfe = XmlConverterHelper.xmlToNfe(xmlString);
                invoiceEntity.setTotal(nfe.getInfNFe().getTotal().getICMSTot().getvNf());
                break;
            case "<nfePr":
                NfeProc nfeProc = XmlConverterHelper.xmlToNfeProc(xmlString);
                invoiceEntity.setTotal(nfeProc.getNFe().getInfNFe().getTotal().getICMSTot().getvNf());
                break;
            default:
                throw new IllegalStateException("Unexpected prefix value: " + xmlPrefix);
        }

        return invoiceEntity;
    }

    public static List<InvoiceEntity> dataToEntities(List<Data> invoiceDataList)  {
        try {
            List<InvoiceEntity> entities = new ArrayList<>();
            for (Data data : invoiceDataList) {
                entities.add(invoiceDataToInvoiceEntity(data));
            }
            return entities;
        } catch (JAXBException ex) {
            throw new RuntimeException("Error when converting data to Entity");
        }
    }

    private static String base64ToXmlString(String encodedXmlString) {
        return new String(Base64Utils.decodeFromString(encodedXmlString));
    }
}
